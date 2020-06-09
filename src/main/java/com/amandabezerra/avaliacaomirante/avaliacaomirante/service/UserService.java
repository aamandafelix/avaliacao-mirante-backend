package com.amandabezerra.avaliacaomirante.avaliacaomirante.service;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.User;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> index () {
        return userRepository.findAll();
    }

    public User create(User user) throws Exception {
        User existingUser = userRepository.findOneByUsername(user.getUsername());
        if (existingUser != null) {
            throw new Exception("Username already exists");
        }

        String passwordEncoded = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        return userRepository.save(user);
    }

    public User edit(User user) {
        return userRepository.save(user);
    }

    public User findOneByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUsername(username);
        return user;
    }
}
