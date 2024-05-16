# Rest API con Spring Boot, mySQL y docker-compose.

Todo lo que necesitas está en la carpeta `src/main/application`

## Carpetas
  - `controllers`: Fichero de enrutamiento.
  - `models`: fichero de entidades.
  - `persistence`: Fichero encargado de las conexiones a la base de datos.
  - `repositories`: Fichero encargado de almacenar las interfaces CRUD con CrusRepository.
  - `services`: Fichero encargado de contener la lógica de cada entidad.

## Ficheros Importantes
  - `application.yml`: Fichero que contiene las configuraciones de la aplicación
    > #### Configuraciones para:
    > - `datasource`: conexión a la base de datos
    > - `jpa`: establecer tipo de dialecto para Hibernate
      
  - `build.gradle`: Fichero de configuración de dependencias de Spring Boot.
    
  - `docker-compose`: Fichero que crea el servicio de bases de datos a través de contenedores.
    > #### Contenedores para:
    > - `mySQL`: Gestor de base de datos.
    > - `PhpAdmin`: Interfaz de manejo de base de datos.

## Nomenclatura
  - `dto`: ( Data Transfer Object ) sub-fichero con las estructura de un objecto.
  - `dao`: ( Data Access Object ) fichero con la estructura de acceso a los parámetros de un objeto.
  - `implementations`: sub-fichero que contiene la implementación de una interfaz, usada para mapear los métodos de una clase.
