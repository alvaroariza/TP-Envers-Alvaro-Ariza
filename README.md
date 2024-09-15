*TP-Envers-Alvaro-Ariza*

*Descripción*
Este repositorio contiene la implementación de un proyecto utilizando Hibernate Envers, una herramienta que permite el versionado y auditoría de entidades en una base de datos. El proyecto tiene como objetivo demostrar cómo auditar cambios en entidades usando Envers en una aplicación basada en Java.

*Tecnologías utilizadas*
- Java: Lenguaje de programación principal.
- Hibernate: Framework ORM para la gestión de entidades.
- Hibernate Envers: Extensión de Hibernate para el versionado de entidades.
- Maven: Sistema de gestión de proyectos y dependencias.
- H2 Database: Base de datos en memoria utilizada para pruebas.

En esta aplicacion los cambios en las entidades serán auditados automáticamente utilizando Envers.

*Función principal*
La clase PersistenceApp.java tiene como función principal inicializar la aplicación y gestionar la configuración de persistencia de Hibernate.

- Se crea una sesión de Hibernate para interactuar con la base de datos.
- Gestiona transacciones para asegurar que las operaciones de inserción, actualización, y eliminación se realicen de forma atómica.
- Ejecuta las operaciones CRUD (crear, leer, actualizar y eliminar) sobre las entidades que serán auditadas por Envers.
- Accede a las revisiones de las entidades mediante el uso de AuditReader, que es el componente de Envers encargado de obtener las versiones anteriores de los registros.
