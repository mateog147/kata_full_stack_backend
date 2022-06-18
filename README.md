
# KATA Full Stack

Este proyecto consta del Backend y el Frontend de un aplicativo para gestionar listas tipo checklist
, pueden realizarse todas las operaciones CRUD tanto para las listas como para las tareas que las componen.

El backend esta construido con Spring-Boot y el Frontend con JavaScript Vanilla.

- Video Explicativo: https://youtu.be/GHJRZQzmamc



## Para consultar el codigo de cada una de las partes: 
- Frontend: https://github.com/mateog147/kata_full_stack_frontend.git
- Backend: https://github.com/mateog147/kata_full_stack_backend.git



## Antes de correr

Ejecute un servidor MySQL. Puede usar usbwebserver

```bash
  https://www.usbwebserver.net/webserver/
```

Cree una base de datos con nombre todolists.

```bash
  CREATE DATABASE todolists;
```

En el proyecto del backend abra el archivo application.propieties y configure:


```bash
    spring.datasource.url=jdbc:mysql://127.0.0.1:{PUERTO DE SU BASE DE DATTOS}/todolist
    spring.datasource.username={USUARIO PARA SU BASE DE DATOS}
    spring.datasource.password={CLAVE DE ACCESO PARA ESE USUARIO}
```

El backend es un proyecto Maven por lo cual antes de Correr asegure tener actualizadas las
dependencias valiendose del archivo POM.xml.


El frontend debe ser ejecutado por un servidor para esto puede usar la extensión LiveServer.


```bash
  https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer
```


## Correr localmente.

Con la base de datos ya configurada. 

Corra en el proyecto backend el archivo  CrudApplication.java

Con esto tendra el servidor listo para atender atraves de un serivio API REST las solicitudes del Frontend.

En el proyecto del Fronted abra el archivo index.html.


## Autor

- [@mateog147](https://github.com/mateog147)

