

<h1 align = "center"> API REST - Blog Pessoal </h1>

Projeto desenvolvido pelo professor Jefeno curso Java/Kotlin, da Digital House, com parceria da Empiricus. 
O objetivo foi construir uma API Rest para entender o conceito da arquiterura mvc, utilizando o Spring Framework.

# Índice

- [Estrutura do Projeto](##Estrutura-do-projeto)
- [Escopo da solução](##Escopo-da-solução)
- [Tecnologias utilizadas](##Tecnologias-utilizadas)
- [Postman - Requisições API](##Requisições-api)



## Configuração do projeto


**1. Clone o repositório**

```bash
git clone 
```

**2. Criação do banco de dados no My SQL**
```bash
create database blogapi
```
- run `src/main/resources/blogapi.sql`

**3. Alteração mysql username e password**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Executar a aplicação usando maven**

```bash
mvn spring-boot:run
```
A aplicação será executada na porta 8080  <br>
<http://localhost:8080>






## Escopo da Solução





## Tecnologias utilizadas


- [IntelliJ Community](https://www.jetbrains.com/idea/download/)
- [Spring Initializer](https://start.spring.io/)
- [Apache Maven](https://maven.apache.org/)
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [My SQL](https://dev.mysql.com/downloads/installer/)


### Dependências Spring
- Spring Security
- Spring Web
- Spring Data JPA
- Apache Commons Codec


## Postman - Requisições API

  

