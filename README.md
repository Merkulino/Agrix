# Agrix - Gerenciador de Fazendas

Este projeto é uma API REST desenvolvida como parte do último projeto do curso da Trybe, e é uma excelente prática para trabalhar com o Spring Boot.

A API Rest Agrix é um sistema de gerenciamento de fazendas que permite o cadastro de usuários, fazendas, plantações e fertilizantes. Os usuários registrados no sistema podem fazer requisições à API, enquanto requisições não autenticadas são bloqueadas pelo Spring Security. O processo de autenticação é realizado por meio de login, que gera um token de autorização usando a tecnologia JWT (Json Web Token).

As principais funcionalidades da API incluem:
- Cadastro de usuários.
- Cadastro de fazendas, plantações e fertilizantes.
- Associação entre entidades: Fazendas podem ter várias plantações (relação 1:N) e cada plantação pode estar associada a uma fazenda. Além disso, plantações podem ter vários fertilizantes e vice-versa (relação N:M).

## Tecnologias e Habilidades Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- API Rest
- JWT (Json Web Token)
- Arquitetura em Camadas
- CRUD (Create, Read, Update, Delete)

## Como rodar 🚀

Caso queira executar esse projeto em sua máquina, você pode:
 * Fazer o clone desse repositório
 * Instalar as dependências utilizando rodando em seu terminal `mvn install -Dskip Tests`
 * Para iniciar a aplicação, rode em seu terminal `./mvnw spring-boot:run`
 * Se tudo ocorrer como esperado, a sua aplicação deve estar rodando no link http://localhost:8080

## Autor

**Melqui Brito de Jesus**

Linkedin: https://www.linkedin.com/in/melqui-brito-871676188/

Telegram: https://t.me/Merkulino

Email: Merkulino11@gmail.com
