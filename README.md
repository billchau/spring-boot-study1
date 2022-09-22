# spring-boot-study1
MVP for studying spring boot

Achieved:

1, Create a simple CRUD api

2, Create different business layers

3, Connect to database

4, Build and run the executable

5, Code in Kotlin


# 

PS. the project is missing a "application.properties" file. The following settings should be added after downloaded the project

spring.datasource.url=jdbc:postgresql://localhost:5432/student

spring.datasource.username=postgres

spring.datasource.password=[your database password]

spring.jpa.hibernate.ddl-auto=create-drop

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.properties.hibernate.format_sql=true

server.error.include-message=always
