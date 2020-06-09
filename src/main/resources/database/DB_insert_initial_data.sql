INSERT INTO perfil (nome) VALUES ('Administrador');
INSERT INTO perfil (nome) VALUES ('Gerente');
INSERT INTO perfil (nome) VALUES ('Analista');

INSERT INTO tipo_pessoa (nome) VALUES ('Física');
INSERT INTO tipo_pessoa (nome) VALUES ('Jurídica');

INSERT INTO tipo_telefone (nome) VALUES ('Celular');
INSERT INTO tipo_telefone (nome) VALUES ('Fixo');
INSERT INTO tipo_telefone (nome) VALUES ('Comercial');

INSERT INTO user (username, password) VALUES ('administrador', '$2a$10$XDYPS3gyVN3gHhozy0amB.Mo1mNDGb1ZXWEUepxJcd1dMHsmVTDne');
INSERT INTO user_perfis (user_id, perfil_name) values (1, 'Administrador');
INSERT INTO operador (nome, user_id) VALUES ('Admin', 1);
