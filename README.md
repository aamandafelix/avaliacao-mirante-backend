<div align="center">
    <h1>Avaliação Mirante</h1>
    <p>
        Este projeto consiste numa API para utilização no projeto <a href="https://github.com/amandabezerra/avaliacao-mirante-frontend">Avaliação Mirante</a>.
    </p>
    <div>
        <a href="#tecnologias">Tecnologias</a>
        &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="#desenvolvimento">Instalação</a>
        &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="#desenvolvimento">Desenvolvimento</a>
        &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="#banco">Banco de Dados</a>
        &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="#referencia">Referência</a>
    </div>
</div>

<h2 id="tecnologias">Tecnologias</h2>

+ [Java 8](https://www.java.com/pt_BR/)
+ [Hibernate](https://hibernate.org/)
+ [Maven](https://maven.apache.org/)
+ [Spring Boot](https://spring.io/projects/spring-boot)
+ [JWT](https://jwt.io/)


<h2 id="instalacao">Instalação</h2>

Execute o comando:

``
$ ./mvnw clean install
``

<h2 id="desenvolvimento">Desenvolvimento</h2>

Execute o comando:

``
$ ./mvnw spring-boot:run
``

Realize uma carga inicial de dados com o script [DB_insert_initial_data.sql](./src/main/resources/database/DB_insert_initial_data.sql).

A API estará disponível no endereço [http://localhost:8080/](http://localhost:8080/).

Pronto, agora é possível utilizar a [Avaliação Mirante](https://github.com/amandabezerra/avaliacao-mirante-frontend) logando inicialmente com as seguintes credenciais:

``
Login: administrador
``

``
Senha: administrador
``


<h2 id="banco">Banco de Dados</h2>

Acesse [http://localhost:8080/h2-console](http://localhost:8080/h2-console) para acessar as tabelas e rodar scripts no banco de dados.


<h2 id="referencia">Referência</h2>

Para visualizar a documentação da API acesse [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).


<br>
<br>
<br>
<br>

> Observações: As configurações atuais deste projeto são voltadas para desenvolvimento, para versões de homologação e produção configure outro banco de dados e proteja a informação da SECRET_KEY JWT. 
