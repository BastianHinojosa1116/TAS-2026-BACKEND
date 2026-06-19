# Ejemplos de Peticiones - DondeVamos Backend

## 1. Provincias

### Crear Provincia
```bash
POST http://localhost:8080/api/provincias
Content-Type: application/json

{
  "nombre": "Región de Los Lagos"
}
```

### Obtener Todas las Provincias
```bash
GET http://localhost:8080/api/provincias
```

### Obtener Provincia por ID
```bash
GET http://localhost:8080/api/provincias/1
```

### Actualizar Provincia
```bash
PUT http://localhost:8080/api/provincias/1
Content-Type: application/json

{
  "nombre": "Región de Los Lagos (Actualizada)"
}
```

### Eliminar Provincia
```bash
DELETE http://localhost:8080/api/provincias/1
```

---

## 2. Comunas

### Crear Comuna
```bash
POST http://localhost:8080/api/comunas
Content-Type: application/json

{
  "nombre": "Puerto Montt",
  "idProvincia": 1
}
```

### Obtener Todas las Comunas
```bash
GET http://localhost:8080/api/comunas
```

---

## 3. Municipios

### Crear Municipio
```bash
POST http://localhost:8080/api/municipios
Content-Type: application/json

{
  "nombre": "Puerto Montt",
  "estado": "activo",
  "idComuna": 1
}
```

---

## 4. Roles

### Crear Rol
```bash
POST http://localhost:8080/api/roles
Content-Type: application/json

{
  "codigo": "ADMIN",
  "nombre": "Administrador"
}
```

---

## 5. Categorías

### Crear Categoría
```bash
POST http://localhost:8080/api/categorias
Content-Type: application/json

{
  "nombre": "Deportes"
}
```

---

## 6. Usuarios App

### Crear Usuario App
```bash
POST http://localhost:8080/api/usuarios-app
Content-Type: application/json

{
  "nombre": "Juan Pérez",
  "correo": "juan.perez@example.com",
  "estado": "activo",
  "firebaseUid": "firebase_uid_123456"
}
```

### Actualizar Usuario App
```bash
PUT http://localhost:8080/api/usuarios-app/1
Content-Type: application/json

{
  "nombre": "Juan Pablo Pérez",
  "correo": "juan.pablo@example.com",
  "estado": "activo",
  "firebaseUid": "firebase_uid_123456"
}
```

---

## 7. Usuarios Municipio

### Crear Usuario Municipio
```bash
POST http://localhost:8080/api/usuarios-municipio
Content-Type: application/json

{
  "nombreResponsable": "María García",
  "correo": "maria.garcia@municipio.cl",
  "telefono": "+56912345678",
  "estado": "activo",
  "idRol": 1,
  "idMunicipio": 1
}
```

---

## 8. Eventos

### Crear Evento
```bash
POST http://localhost:8080/api/eventos
Content-Type: application/json

{
  "nombreEvento": "Festival de Verano 2024",
  "direccion": "Parque Central, Puerto Montt",
  "imagen": "https://example.com/festival.jpg",
  "esPagado": false,
  "descripcionEvento": "Festival de música y gastronomía local",
  "petFriendly": true,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "qr": "https://example.com/qr/123456",
  "estado": "programado",
  "idMunicipio": 1,
  "idCategorias": [1, 2]
}
```

### Actualizar Evento
```bash
PUT http://localhost:8080/api/eventos/1
Content-Type: application/json

{
  "nombreEvento": "Festival de Verano 2024 - Edición Especial",
  "direccion": "Parque Central, Puerto Montt",
  "imagen": "https://example.com/festival-updated.jpg",
  "esPagado": false,
  "descripcionEvento": "Festival de música, gastronomía y arte local",
  "petFriendly": true,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "qr": "https://example.com/qr/123456",
  "estado": "programado",
  "idMunicipio": 1,
  "idCategorias": [1, 2, 3]
}
```

---

## 9. Fechas/Horarios de Evento

### Crear Fecha y Horario
```bash
POST http://localhost:8080/api/fechas-evento
Content-Type: application/json

{
  "fecha": "2024-12-15",
  "horario": "18:00:00",
  "idEvento": 1
}
```

---

## 10. Comentarios

### Crear Comentario
```bash
POST http://localhost:8080/api/comentarios
Content-Type: application/json

{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "opinion": "Excelente evento, muy bien organizado",
  "calidad": "excelente"
}
```

---

## 11. Asistencias Evento

### Crear Asistencia
```bash
POST http://localhost:8080/api/asistencias
Content-Type: application/json

{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "estado": "confirmado"
}
```

### Actualizar Estado de Asistencia
```bash
PUT http://localhost:8080/api/asistencias/1
Content-Type: application/json

{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "estado": "asistio"
}
```

---

## Respuestas Esperadas

### Respuesta Exitosa (201 Created)
```json
{
  "idEvento": 1,
  "nombreEvento": "Festival de Verano 2024",
  "direccion": "Parque Central, Puerto Montt",
  "imagen": "https://example.com/festival.jpg",
  "esPagado": false,
  "descripcionEvento": "Festival de música y gastronomía local",
  "petFriendly": true,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "qr": "https://example.com/qr/123456",
  "estado": "programado",
  "municipio": {
    "idMunicipio": 1,
    "nombre": "Puerto Montt",
    "estado": "activo",
    "comuna": {...}
  },
  "categorias": [...]
}
```

### Respuesta de Error (404 Not Found)
```json
{
  "timestamp": "2024-06-17T10:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Evento no encontrado con id: 999",
  "path": "/api/eventos/999"
}
```

### Respuesta de Error de Validación (400 Bad Request)
```json
{
  "timestamp": "2024-06-17T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "errors": {
    "nombreEvento": "El nombre del evento es requerido",
    "correo": "El correo debe ser válido"
  },
  "path": "/api/eventos"
}
```

---

## Notas Importantes

1. Todas las fechas se devuelven en formato ISO 8601
2. Los IDs son autoincrementales
3. Las relaciones se devuelven anidadas en los DTOs de respuesta
4. Para eliminaciones exitosas (204 No Content), no hay body en la respuesta
5. Todos los campos requeridos se marcan con validaciones
