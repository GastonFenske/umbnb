---
title: Umbnb
description: A basic Java Spring Boot server
tags:
  - spring
  - java
---

[![Deploy on Railway](https://railway.app/button.svg)](https://railway.app/new?template=https%3A%2F%2Fgithub.com%2Frailwayapp%2Fexamples%2Ftree%2Fmaster%2Fexamples%2Fkotlin-spring)

## ✨ Features

- Spring
- Java

## 💁‍♀️ How to use

- Click the link: https://umbnb-production.up.railway.app/

# Railway

# Deploy en [railway.app](https://railway.app/) Spring Boot

### Creamos un proyecto

### Podemos conectarlo con el repo en github directamente

### Instalamos el [CLI](https://docs.railway.app/develop/cli)

### Nos logueamos localmente

```powershell
$ railway login
```

### Nos conectamos al proyecto

```powershell
$ railway link <projectId>
```

### Detenemos un proyecto

```powershell
$ railway down
```

### Subimos/iniciamos un deploy haciendo un push a la rama principal del repositorio o con el comando:

```powershell
$ railway up
```

### Antes de hacer un push a la rama main

Hay que agregar un archivo system.properties en la raiz del proyecto de Spring Boot y espesificar la version de java

```properties
java.runtime.version=11
```

### En la config de nuestra app, generamos el dominio

### Creamos la base de datos, en variables y connect podemos ver las credenciales para conectarnos

### En el archivo application.properties de Spring Boot queda la config asi
```properties
spring.datasource.url=jdbc:mysql://root:nf64M6pwjgGBchcN9jrO@containers-us-west-67.railway.app:6271/railway
spring.datasource.username=root
spring.datasource.password=nf64M6pwjgGBchcN9jrO
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect
spring.jpa.hibernate.ddl-auto=update
logging.level.org.hibernate.SQL=debug
server.port=${PORT:8080}
```

