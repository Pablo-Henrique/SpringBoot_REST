# Java/Java EE, Spring Framework e Scrum/Kanban

## Spring Framework

Spring é uma ferramenta open source para java/kotlin criada por Rod jhonson.
É baseado em padroes de projeto, inversão de controle e injeção de dependencias.

## Spring Boot

O Spring Boot é uma ferramenta que visa facilitar o processo de configuração e publicação de aplicações que utilizem o ecossistema Spring.
Com configurações rápidas, você consegue, por exemplo, disponibilizar uma aplicação baseada no Spring MVC, utilizando o Hibernate + JPA e o Thymeleaf como template engine.

* Spring Boot Starter;
* Spring Boot AutoConfigurator;
* Spring Boot Actuator;

### Starter

Sua função é combinar varias as dependencias do Spring boot em uma dependencia,
Eliminando as configurações multiplas dependencias no maven/gradle.

### AutoConfigurator

O spring Boot ele identifica as configurações necessaria pelo tipo de aplicação, Exemplo Web, JPA ou uma Api Rest

### Actuator

É uma ferramenta que permite ao programador, verificar oque esta acontecendo internamente em uma aplicação com o Spring boot

-------------------------------------------------------------------------------------------------------------------------------

## Web

* Servlets
* Portlets
* Struts

### Servlets

- O DispatcherServlet direciona as requisições dos usuários para os Controladores (Controllers). Um controlador Spring faz o uso da anotação @Controller (Indentifica um controlador),
E @RequestMapping(Mapea URLs web Ex: www.dns/cadastro) Ofereçe uma ampla gama de Recursos para Manipulação de requesições Web.

### Portlets

- 

## Data Accesse/Integration

* JDBC
* ORM
* OXM
* JMS
* Transactions

## Core Container

* beans
* Core
* Context
* Expression Language
