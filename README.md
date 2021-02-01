# Spring Framework

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
* Struts

### Servlets

O DispatcherServlet direciona as requisições dos usuários para os Controladores (Controllers). Um controlador Spring faz o uso da anotação @Controller (Indentifica um controlador),
E @RequestMapping(Mapea URLs web Ex: www.dns/cadastro) Ofereçe uma ampla gama de Recursos para Manipulação de requesições Web.

### Struts

O Struts é um framework de código aberto que amplia a API do Servlet Java e implanta uma arquitetura MVC ( Modelo, View, Controlador ).
Permite criar aplicações Web manuteníveis, extensíveis e flexíveis baseadas em tecnologias padrão, como páginas JSP, JavaBeans, pacotes de recursos e XML.

-------------------------------------------------------------------------------------------------------------------------------

## Data Accesse/Integration

* JDBC
* ORM
* JMS

### JDBC

é utilizado para definição do conjunto de conexões do JDBC. Baseia-se na implementação do conjunto de conexões do JDBC do Tomcat.

### ORM

ORM (Object Relational Mapper) é uma técnica de mapeamento objeto relacional que permite fazer uma relação dos objetos com os dados que os mesmos representam.
Mapeador objeto relacional, é um tipo de ferramenta muito utilizada hoje em dia, com o propósito de unir o mundo orietado a objetos e o mundo relacional.

### JMS

Um aplicativo Spring Framework pode usar a classe JMSTemplate para enviar mensagens JMS ou receber mensagens JMS síncronas.
No tempo de execução, o objeto JMSTemplate pode localizar um destino com base em seu nome JNDI que foi configurada em uma referência de recurso do aplicativo.

-------------------------------------------------------------------------------------------------------------------------------

## Core Container

* beans
* Core
* Context

### Beans

Um bean é um objeto que é criado, gerenciado e destruído pelo container do spring,
o framework é totalmente responsável por este objeto, criando, injetando suas propriedades (Injeção de dependência).

### Core

O core container consiste de um dos módulos do Spring Framework que cuida das injeções de dependências e inversão de controle em um determinado projeto java.

### Context

Módulo Context: onde são implementadas as classes mais avançadas. Módulo Expression Language: definem através de xml ou anotações em tempo de execução, valores e comportamentos dos beans.
