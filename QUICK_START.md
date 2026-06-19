# Guía Rápida - DondeVamos Backend

## Estructura Creada

### Entidades (11 total)
✅ Provincia - Región administrativa
✅ Comuna - Subdivisión de provincia
✅ Municipio - Ciudad/municipio
✅ Rol - Roles de usuarios municipales
✅ Categoria - Categorías de eventos
✅ UsuarioApp - Usuarios finales de la aplicación
✅ UsuarioMunicipio - Funcionarios/administradores municipales
✅ Evento - Eventos municipales
✅ FechaHorarioEvento - Fechas y horarios de eventos
✅ Comentario - Comentarios de usuarios en eventos
✅ AsistenciaEvento - Registro de asistencia a eventos

### Capas Implementadas

1. **Controllers** (11 total)
   - Todos con CRUD completo (GET, GET by ID, POST, PUT, DELETE)
   - CORS configurado por @CrossOrigin

2. **Services** (11 total)
   - Interfaces y Implementaciones
   - Lógica de negocio

3. **Repositories** (11 total)
   - Extiendes JpaRepository
   - CRUD automático

4. **Mappers** (11 total)
   - Interfaces de mapeo
   - Implementaciones con lógica de conversión

5. **DTOs** (22 total - 11 Request + 11 Response)
   - Con validaciones Bean Validation

6. **Excepciones** (3 total)
   - ResourceNotFoundException
   - BadRequestException
   - ErrorResponse
   - GlobalExceptionHandler

7. **Configuración** (1 total)
   - WebConfig para CORS global

## Rutas Base de API

```
/api/provincias          (Provincias)
/api/comunas             (Comunas)
/api/municipios          (Municipios)
/api/roles               (Roles)
/api/categorias          (Categorías)
/api/usuarios-app        (Usuarios App)
/api/usuarios-municipio  (Usuarios Municipio)
/api/eventos             (Eventos)
/api/fechas-evento       (Fechas/Horarios Evento)
/api/comentarios         (Comentarios)
/api/asistencias         (Asistencias Evento)
```

## Relaciones Implementadas

```
Provincia 1 → N Comuna
Comuna N → 1 Provincia
Comuna 1 → N Municipio
Municipio N → 1 Comuna

Municipio 1 → N Evento
Municipio 1 → N UsuarioMunicipio
Evento 1 → N FechaHorarioEvento
Evento 1 → N Comentario
Evento 1 → N AsistenciaEvento
Evento N → N Categoria (a través de EventoCategoria)

UsuarioApp 1 → N Comentario
UsuarioApp 1 → N AsistenciaEvento

Rol 1 → N UsuarioMunicipio
UsuarioMunicipio N → 1 Municipio
UsuarioMunicipio N → 1 Rol
```

## Validaciones Implementadas

✅ @NotBlank en campos de texto requeridos
✅ @NotNull en IDs requeridos
✅ @Email en campos de correo
✅ Mensajes personalizados en español

## Configuración CORS

✅ Origen permitido: http://localhost:4200
✅ Métodos: GET, POST, PUT, DELETE, OPTIONS
✅ Headers: *
✅ Credenciales: permitidas
✅ Max Age: 3600 segundos

## Base de Datos

- Todos los IDs usan: @GeneratedValue(strategy = GenerationType.IDENTITY)
- Compatible con Azure SQL Server
- Validación de esquema (ddl-auto=validate)

## Pasos Siguientes

1. Actualizar application.properties con credenciales de Azure SQL
2. Ejecutar los scripts SQL de base de datos
3. Compilar: `mvn clean install`
4. Ejecutar: `mvn spring-boot:run`
5. Probar endpoints con Postman o cliente REST

## Estadísticas

- Archivos Java creados: 125+
- Líneas de código: ~10,000+
- Entidades: 11
- Servicios: 11
- Controladores: 11
- DTOs: 22
- Mappers: 11
- Repositorios: 11
- Excepciones: 3
