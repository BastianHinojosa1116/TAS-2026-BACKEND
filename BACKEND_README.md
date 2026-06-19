# DondeVamos Backend

Backend RESTful para la plataforma DondeVamos usando Spring Boot 3.5.15 y Azure SQL Database.

## Características

- ✅ Arquitectura en capas (Controller → Service → Repository)
- ✅ Entidades JPA con relaciones completas
- ✅ DTOs para Request/Response
- ✅ Mappers para conversión entidad-DTO
- ✅ Servicios con lógica de negocio
- ✅ Controladores REST CRUD completo
- ✅ Validación con Bean Validation
- ✅ Manejo global de excepciones
- ✅ CORS configurado para http://localhost:4200
- ✅ Lombok para reducir boilerplate

## Stack Tecnológico

- Java 21
- Spring Boot 3.5.15
- Maven
- Spring Web
- Spring Data JPA
- SQL Server Driver
- Validation (Jakarta)
- Lombok
- Azure SQL Database

## Estructura de Carpetas

```
cl.dondevamos.backend
├── config/              # Configuración (CORS, WebConfig)
├── controller/          # Controladores REST
├── dto/
│   ├── request/        # DTOs de entrada
│   └── response/       # DTOs de salida
├── entity/             # Entidades JPA
├── exception/          # Excepciones personalizadas
├── mapper/             # Mappers entidad-DTO
├── repository/         # Repositorios JPA
├── service/            # Servicios/Lógica de negocio
└── DondeVamosBackendApplication.java
```

## Configuración

### 1. Base de Datos

Edita `application.properties` con tus credenciales de Azure SQL:

```properties
spring.datasource.url=jdbc:sqlserver://SERVER_NAME.database.windows.net:1433;database=DATABASE_NAME;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 2. Compilar Proyecto

```bash
mvn clean install
```

### 3. Ejecutar Proyecto

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## Endpoints API

### Provincias
- `GET /api/provincias` - Obtener todas
- `GET /api/provincias/{id}` - Obtener por ID
- `POST /api/provincias` - Crear
- `PUT /api/provincias/{id}` - Actualizar
- `DELETE /api/provincias/{id}` - Eliminar

### Comunas
- `GET /api/comunas` - Obtener todas
- `GET /api/comunas/{id}` - Obtener por ID
- `POST /api/comunas` - Crear
- `PUT /api/comunas/{id}` - Actualizar
- `DELETE /api/comunas/{id}` - Eliminar

### Municipios
- `GET /api/municipios` - Obtener todos
- `GET /api/municipios/{id}` - Obtener por ID
- `POST /api/municipios` - Crear
- `PUT /api/municipios/{id}` - Actualizar
- `DELETE /api/municipios/{id}` - Eliminar

### Roles
- `GET /api/roles` - Obtener todos
- `GET /api/roles/{id}` - Obtener por ID
- `POST /api/roles` - Crear
- `PUT /api/roles/{id}` - Actualizar
- `DELETE /api/roles/{id}` - Eliminar

### Categorías
- `GET /api/categorias` - Obtener todas
- `GET /api/categorias/{id}` - Obtener por ID
- `POST /api/categorias` - Crear
- `PUT /api/categorias/{id}` - Actualizar
- `DELETE /api/categorias/{id}` - Eliminar

### Usuarios App
- `GET /api/usuarios-app` - Obtener todos
- `GET /api/usuarios-app/{id}` - Obtener por ID
- `POST /api/usuarios-app` - Crear
- `PUT /api/usuarios-app/{id}` - Actualizar
- `DELETE /api/usuarios-app/{id}` - Eliminar

### Usuarios Municipio
- `GET /api/usuarios-municipio` - Obtener todos
- `GET /api/usuarios-municipio/{id}` - Obtener por ID
- `POST /api/usuarios-municipio` - Crear
- `PUT /api/usuarios-municipio/{id}` - Actualizar
- `DELETE /api/usuarios-municipio/{id}` - Eliminar

### Eventos
- `GET /api/eventos` - Obtener todos
- `GET /api/eventos/{id}` - Obtener por ID
- `POST /api/eventos` - Crear
- `PUT /api/eventos/{id}` - Actualizar
- `DELETE /api/eventos/{id}` - Eliminar

### Fechas/Horarios Evento
- `GET /api/fechas-evento` - Obtener todas
- `GET /api/fechas-evento/{id}` - Obtener por ID
- `POST /api/fechas-evento` - Crear
- `PUT /api/fechas-evento/{id}` - Actualizar
- `DELETE /api/fechas-evento/{id}` - Eliminar

### Comentarios
- `GET /api/comentarios` - Obtener todos
- `GET /api/comentarios/{id}` - Obtener por ID
- `POST /api/comentarios` - Crear
- `PUT /api/comentarios/{id}` - Actualizar
- `DELETE /api/comentarios/{id}` - Eliminar

### Asistencias Evento
- `GET /api/asistencias` - Obtener todas
- `GET /api/asistencias/{id}` - Obtener por ID
- `POST /api/asistencias` - Crear
- `PUT /api/asistencias/{id}` - Actualizar
- `DELETE /api/asistencias/{id}` - Eliminar

## Ejemplo de Request

### Crear Evento

```json
POST /api/eventos

{
  "nombreEvento": "Festival Municipal 2024",
  "direccion": "Av. Principal 123",
  "descripcionEvento": "Evento familiar con actividades para todos",
  "esPagado": false,
  "petFriendly": true,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "imagen": "https://example.com/imagen.jpg",
  "qr": "https://example.com/qr",
  "estado": "activo",
  "idMunicipio": 1,
  "idCategorias": [1, 2, 3]
}
```

## Validaciones

Todos los DTOs incluyen validaciones con Bean Validation:
- `@NotBlank` - Campo requerido y no vacío
- `@NotNull` - Campo requerido
- `@Email` - Formato de email válido

## Manejo de Excepciones

El backend implementa un `GlobalExceptionHandler` que maneja:
- `ResourceNotFoundException` - Recurso no encontrado (404)
- `BadRequestException` - Solicitud inválida (400)
- `MethodArgumentNotValidException` - Validación fallida (400)
- Excepciones genéricas (500)

## CORS

CORS está configurado para permitir solicitudes desde `http://localhost:4200`

Métodos permitidos: GET, POST, PUT, DELETE, OPTIONS

## Notas Importantes

1. Los IDs en todas las entidades son autoincrementales usando `@GeneratedValue(strategy = GenerationType.IDENTITY)`
2. Las fechas se manejan como `LocalDateTime` y `LocalDate`
3. Los objetos relacionados se devuelven en los DTOs de respuesta
4. Se utiliza inyección de dependencias para todos los servicios
5. Se sigue el patrón de arquitectura en capas
6. No se exponen las entidades directamente, solo los DTOs

## Próximos Pasos

- Configurar la base de datos en Azure SQL
- Ejecutar los scripts SQL para crear las tablas
- Configurar autenticación y autorización (si es necesario)
- Agregar más endpoints según requisitos
- Implementar búsqueda y filtrado avanzado
- Agregar documentación con Swagger/SpringFox

## Licencia

Este proyecto es privado y está destinado solo para el equipo de DondeVamos.
