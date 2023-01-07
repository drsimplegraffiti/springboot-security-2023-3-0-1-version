

![Image description](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/fdgmofhpidw5ggsom5sh.png)


#### Application properties setup
```properties

# configure postgres database
spring.datasource.url=jdbc:postgresql://localhost:5432/***********
spring.datasource.username=postgres
spring.datasource.password=***************
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false

# server port
server.port=8080


```

#### application.yml
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/********?useSSL=false
    driver-class-name: org.postgresql.Driver
    username: postgres
    password: **************
  jpa:
    hibernate:
      ddl-auto: create-drop # This will create and drop the tables every time the application is run
    show-sql: true
    properties:
      hibernate:
        format_sql: true
    database: postgresql
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    
server:
    port: 8080
```

#### Generate Secret key
allkeysgenerator.com/Random/Security-Encryption-Key-Generator.aspx
Click Encryption key
Choose 256-bit
Tick Hex    