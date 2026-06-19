# 📚 Documentación de Endpoints - DondeVamos Backend

**URL Base:** `http://localhost:8080`  
**CORS:** Habilitado para `http://localhost:4200`  
**Content-Type:** `application/json`

---

## 1. PROVINCIAS 🏞️

### GET - Obtener todas las provincias
```
GET /api/provincias
```
**Respuesta (200 OK):**
```json
[
  {
    "idProvincia": 1,
    "nombre": "Santiago"
  },
  {
    "idProvincia": 2,
    "nombre": "Valparaíso"
  }
]
```

### GET - Obtener provincia por ID
```
GET /api/provincias/{id}
```
**Parámetros:**
- `id` (path): ID de la provincia

**Respuesta (200 OK):**
```json
{
  "idProvincia": 1,
  "nombre": "Santiago"
}
```

### POST - Crear provincia
```
POST /api/provincias
```
**Body:**
```json
{
  "nombre": "Nueva Provincia"
}
```

**Respuesta (201 CREATED):**
```json
{
  "idProvincia": 3,
  "nombre": "Nueva Provincia"
}
```

### PUT - Actualizar provincia
```
PUT /api/provincias/{id}
```
**Body:**
```json
{
  "nombre": "Provincia Actualizada"
}
```

**Respuesta (200 OK):**
```json
{
  "idProvincia": 1,
  "nombre": "Provincia Actualizada"
}
```

### DELETE - Eliminar provincia
```
DELETE /api/provincias/{id}
```

**Respuesta (204 NO CONTENT)** - Sin cuerpo

---

## 2. COMUNAS 🏘️

### GET - Obtener todas las comunas
```
GET /api/comunas
```

**Respuesta (200 OK):**
```json
[
  {
    "idComuna": 1,
    "nombreProvicia": "Santiago",
    "provincia": {
      "idProvincia": 1,
      "nombre": "Santiago"
    }
  }
]
```

### GET - Obtener comuna por ID
```
GET /api/comunas/{id}
```

### POST - Crear comuna
```
POST /api/comunas
```
**Body:**
```json
{
  "nombreProvicia": "Santiago",
  "idProvincia": 1
}
```

**Respuesta (201 CREATED):**
```json
{
  "idComuna": 1,
  "nombreProvicia": "Santiago",
  "provincia": {
    "idProvincia": 1,
    "nombre": "Santiago"
  }
}
```

### PUT - Actualizar comuna
```
PUT /api/comunas/{id}
```
**Body:**
```json
{
  "nombreProvicia": "Santiago Updated",
  "idProvincia": 1
}
```

### DELETE - Eliminar comuna
```
DELETE /api/comunas/{id}
```

---

## 3. MUNICIPIOS 🏛️

### GET - Obtener todos los municipios
```
GET /api/municipios
```

**Respuesta (200 OK):**
```json
[
  {
    "idMunicipio": 1,
    "nombre": "Municipio Central",
    "estado": "activo",
    "comuna": {
      "idComuna": 1,
      "nombreProvicia": "Santiago"
    }
  }
]
```

### GET - Obtener municipio por ID
```
GET /api/municipios/{id}
```

### POST - Crear municipio
```
POST /api/municipios
```
**Body:**
```json
{
  "nombre": "Nuevo Municipio",
  "estado": "activo",
  "idComuna": 1
}
```

**Respuesta (201 CREATED):**
```json
{
  "idMunicipio": 2,
  "nombre": "Nuevo Municipio",
  "estado": "activo",
  "comuna": {
    "idComuna": 1,
    "nombreProvicia": "Santiago"
  }
}
```

### PUT - Actualizar municipio
```
PUT /api/municipios/{id}
```
**Body:**
```json
{
  "nombre": "Municipio Actualizado",
  "estado": "activo",
  "idComuna": 1
}
```

### DELETE - Eliminar municipio
```
DELETE /api/municipios/{id}
```

---

## 4. ROLES 👤

### GET - Obtener todos los roles
```
GET /api/roles
```

**Respuesta (200 OK):**
```json
[
  {
    "idRol": 1,
    "codigo": "ADMIN",
    "nombre": "Administrador"
  },
  {
    "idRol": 2,
    "codigo": "USER",
    "nombre": "Usuario"
  }
]
```

### GET - Obtener rol por ID
```
GET /api/roles/{id}
```

### POST - Crear rol
```
POST /api/roles
```
**Body:**
```json
{
  "codigo": "MODERATOR",
  "nombre": "Moderador"
}
```

**Respuesta (201 CREATED):**
```json
{
  "idRol": 3,
  "codigo": "MODERATOR",
  "nombre": "Moderador"
}
```

### PUT - Actualizar rol
```
PUT /api/roles/{id}
```
**Body:**
```json
{
  "codigo": "MOD",
  "nombre": "Moderador Actualizado"
}
```

### DELETE - Eliminar rol
```
DELETE /api/roles/{id}
```

---

## 5. CATEGORÍAS 🏷️

### GET - Obtener todas las categorías
```
GET /api/categorias
```

**Respuesta (200 OK):**
```json
[
  {
    "idCategoria": 1,
    "nombre": "Deportes"
  },
  {
    "idCategoria": 2,
    "nombre": "Cultura"
  }
]
```

### GET - Obtener categoría por ID
```
GET /api/categorias/{id}
```

### POST - Crear categoría
```
POST /api/categorias
```
**Body:**
```json
{
  "nombre": "Entretenimiento"
}
```

**Respuesta (201 CREATED):**
```json
{
  "idCategoria": 3,
  "nombre": "Entretenimiento"
}
```

### PUT - Actualizar categoría
```
PUT /api/categorias/{id}
```
**Body:**
```json
{
  "nombre": "Entretenimiento Actualizado"
}
```

### DELETE - Eliminar categoría
```
DELETE /api/categorias/{id}
```

---

## 6. USUARIOS APP 👥

### GET - Obtener todos los usuarios
```
GET /api/usuarios-app
```

**Respuesta (200 OK):**
```json
[
  {
    "idUsuarioApp": 1,
    "nombre": "Juan Pérez",
    "correo": "juan@example.com",
    "estado": "activo",
    "fechaCreacion": "2026-06-17T12:00:00",
    "firebaseUid": "firebase_uid_123"
  }
]
```

### GET - Obtener usuario por ID
```
GET /api/usuarios-app/{id}
```

### POST - Crear usuario
```
POST /api/usuarios-app
```
**Body:**
```json
{
  "nombre": "María García",
  "correo": "maria@example.com",
  "estado": "activo",
  "firebaseUid": "firebase_uid_456"
}
```

**Respuesta (201 CREATED):**
```json
{
  "idUsuarioApp": 2,
  "nombre": "María García",
  "correo": "maria@example.com",
  "estado": "activo",
  "fechaCreacion": "2026-06-17T13:00:00",
  "firebaseUid": "firebase_uid_456"
}
```

### PUT - Actualizar usuario
```
PUT /api/usuarios-app/{id}
```
**Body:**
```json
{
  "nombre": "María García Updated",
  "correo": "maria.updated@example.com",
  "estado": "activo",
  "firebaseUid": "firebase_uid_456"
}
```

### DELETE - Eliminar usuario
```
DELETE /api/usuarios-app/{id}
```

---

## 7. USUARIOS MUNICIPIO 🏢

### GET - Obtener todos los usuarios municipio
```
GET /api/usuarios-municipio
```

**Respuesta (200 OK):**
```json
[
  {
    "idUsuarioMunicipio": 1,
    "nombreResponsable": "Carlos López",
    "correo": "carlos@municipio.cl",
    "telefono": "912345678",
    "estado": "activo",
    "fechaCreacion": "2026-06-17T10:00:00",
    "rol": {
      "idRol": 1,
      "codigo": "ADMIN",
      "nombre": "Administrador"
    },
    "municipio": {
      "idMunicipio": 1,
      "nombre": "Municipio Central"
    }
  }
]
```

### GET - Obtener usuario municipio por ID
```
GET /api/usuarios-municipio/{id}
```

### POST - Crear usuario municipio
```
POST /api/usuarios-municipio
```
**Body:**
```json
{
  "nombreResponsable": "Ana Rodríguez",
  "correo": "ana@municipio.cl",
  "telefono": "987654321",
  "estado": "activo",
  "idRol": 2,
  "idMunicipio": 1
}
```

**Respuesta (201 CREATED):**
```json
{
  "idUsuarioMunicipio": 2,
  "nombreResponsable": "Ana Rodríguez",
  "correo": "ana@municipio.cl",
  "telefono": "987654321",
  "estado": "activo",
  "fechaCreacion": "2026-06-17T14:00:00",
  "rol": {
    "idRol": 2,
    "codigo": "USER",
    "nombre": "Usuario"
  },
  "municipio": {
    "idMunicipio": 1,
    "nombre": "Municipio Central"
  }
}
```

### PUT - Actualizar usuario municipio
```
PUT /api/usuarios-municipio/{id}
```
**Body:**
```json
{
  "nombreResponsable": "Ana Rodríguez Updated",
  "correo": "ana.updated@municipio.cl",
  "telefono": "987654321",
  "estado": "activo",
  "idRol": 2,
  "idMunicipio": 1
}
```

### DELETE - Eliminar usuario municipio
```
DELETE /api/usuarios-municipio/{id}
```

---

## 8. EVENTOS 🎪

### GET - Obtener todos los eventos
```
GET /api/eventos
```

**Respuesta (200 OK):**
```json
[
  {
    "idEvento": 1,
    "nombreEvento": "Festival de Música",
    "direccion": "Parque Central, Santiago",
    "imagen": "https://example.com/image.jpg",
    "esPagado": false,
    "petFriendly": true,
    "accesibilidadDiscapacidad": true,
    "estacionamiento": true,
    "descripcionEvento": "Festival con música en vivo",
    "qr": "QR_CODE_123",
    "estado": "activo",
    "municipio": {
      "idMunicipio": 1,
      "nombre": "Municipio Central"
    },
    "categorias": [
      {
        "idCategoria": 1,
        "nombre": "Deportes"
      },
      {
        "idCategoria": 2,
        "nombre": "Cultura"
      }
    ]
  }
]
```

### GET - Obtener evento por ID
```
GET /api/eventos/{id}
```

### POST - Crear evento
```
POST /api/eventos
```
**Body:**
```json
{
  "nombreEvento": "Concierto de Rock",
  "direccion": "Estadio Nacional, Santiago",
  "imagen": "https://example.com/concierto.jpg",
  "esPagado": true,
  "petFriendly": false,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "descripcionEvento": "Concierto de rock nacional",
  "qr": "QR_CONCIERTO_001",
  "estado": "activo",
  "idMunicipio": 1,
  "idCategorias": [1, 2]
}
```

**Respuesta (201 CREATED):**
```json
{
  "idEvento": 2,
  "nombreEvento": "Concierto de Rock",
  "direccion": "Estadio Nacional, Santiago",
  "imagen": "https://example.com/concierto.jpg",
  "esPagado": true,
  "petFriendly": false,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "descripcionEvento": "Concierto de rock nacional",
  "qr": "QR_CONCIERTO_001",
  "estado": "activo",
  "municipio": {
    "idMunicipio": 1,
    "nombre": "Municipio Central"
  },
  "categorias": [
    {
      "idCategoria": 1,
      "nombre": "Deportes"
    },
    {
      "idCategoria": 2,
      "nombre": "Cultura"
    }
  ]
}
```

### PUT - Actualizar evento
```
PUT /api/eventos/{id}
```
**Body:**
```json
{
  "nombreEvento": "Concierto de Rock Actualizado",
  "direccion": "Estadio Nacional, Santiago",
  "imagen": "https://example.com/concierto-updated.jpg",
  "esPagado": true,
  "petFriendly": false,
  "accesibilidadDiscapacidad": true,
  "estacionamiento": true,
  "descripcionEvento": "Concierto de rock nacional actualizado",
  "qr": "QR_CONCIERTO_001_UPDATED",
  "estado": "activo",
  "idMunicipio": 1,
  "idCategorias": [1]
}
```

### DELETE - Eliminar evento
```
DELETE /api/eventos/{id}
```

---

## 9. FECHAS Y HORARIOS DE EVENTOS ⏰

### GET - Obtener todas las fechas/horarios
```
GET /api/fecha-horario-eventos
```

**Respuesta (200 OK):**
```json
[
  {
    "idFechaHorarioEvento": 1,
    "fecha": "2026-07-15",
    "horario": "20:00:00",
    "evento": {
      "idEvento": 1,
      "nombreEvento": "Festival de Música"
    }
  }
]
```

### GET - Obtener fecha/horario por ID
```
GET /api/fecha-horario-eventos/{id}
```

### POST - Crear fecha/horario
```
POST /api/fecha-horario-eventos
```
**Body:**
```json
{
  "fecha": "2026-07-20",
  "horario": "19:00:00",
  "idEvento": 1
}
```

**Respuesta (201 CREATED):**
```json
{
  "idFechaHorarioEvento": 2,
  "fecha": "2026-07-20",
  "horario": "19:00:00",
  "evento": {
    "idEvento": 1,
    "nombreEvento": "Festival de Música"
  }
}
```

### PUT - Actualizar fecha/horario
```
PUT /api/fecha-horario-eventos/{id}
```
**Body:**
```json
{
  "fecha": "2026-07-21",
  "horario": "18:00:00",
  "idEvento": 1
}
```

### DELETE - Eliminar fecha/horario
```
DELETE /api/fecha-horario-eventos/{id}
```

---

## 10. COMENTARIOS 💬

### GET - Obtener todos los comentarios
```
GET /api/comentarios
```

**Respuesta (200 OK):**
```json
[
  {
    "idComentario": 1,
    "usuarioApp": {
      "idUsuarioApp": 1,
      "nombre": "Juan Pérez",
      "correo": "juan@example.com"
    },
    "evento": {
      "idEvento": 1,
      "nombreEvento": "Festival de Música"
    },
    "fecha": "2026-06-17T15:30:00",
    "opinion": "Excelente evento, muy bien organizado",
    "calidad": "excelente"
  }
]
```

### GET - Obtener comentario por ID
```
GET /api/comentarios/{id}
```

### POST - Crear comentario
```
POST /api/comentarios
```
**Body:**
```json
{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "opinion": "Muy buen evento, recomendado",
  "calidad": "bueno"
}
```

**Respuesta (201 CREATED):**
```json
{
  "idComentario": 2,
  "usuarioApp": {
    "idUsuarioApp": 1,
    "nombre": "Juan Pérez"
  },
  "evento": {
    "idEvento": 1,
    "nombreEvento": "Festival de Música"
  },
  "fecha": "2026-06-17T16:00:00",
  "opinion": "Muy buen evento, recomendado",
  "calidad": "bueno"
}
```

### PUT - Actualizar comentario
```
PUT /api/comentarios/{id}
```
**Body:**
```json
{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "opinion": "Excelente evento, superó mis expectativas",
  "calidad": "excelente"
}
```

### DELETE - Eliminar comentario
```
DELETE /api/comentarios/{id}
```

---

## 11. ASISTENCIA A EVENTOS ✅

### GET - Obtener todas las asistencias
```
GET /api/asistencia-eventos
```

**Respuesta (200 OK):**
```json
[
  {
    "idAsistenciaEvento": 1,
    "usuarioApp": {
      "idUsuarioApp": 1,
      "nombre": "Juan Pérez",
      "correo": "juan@example.com"
    },
    "evento": {
      "idEvento": 1,
      "nombreEvento": "Festival de Música"
    },
    "fechaRegistro": "2026-06-17T10:00:00",
    "estado": true
  }
]
```

### GET - Obtener asistencia por ID
```
GET /api/asistencia-eventos/{id}
```

### POST - Crear asistencia
```
POST /api/asistencia-eventos
```
**Body:**
```json
{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "estado": true
}
```

**Respuesta (201 CREATED):**
```json
{
  "idAsistenciaEvento": 2,
  "usuarioApp": {
    "idUsuarioApp": 1,
    "nombre": "Juan Pérez"
  },
  "evento": {
    "idEvento": 1,
    "nombreEvento": "Festival de Música"
  },
  "fechaRegistro": "2026-06-17T11:00:00",
  "estado": true
}
```

### PUT - Actualizar asistencia
```
PUT /api/asistencia-eventos/{id}
```
**Body:**
```json
{
  "idUsuarioApp": 1,
  "idEvento": 1,
  "estado": false
}
```

### DELETE - Eliminar asistencia
```
DELETE /api/asistencia-eventos/{id}
```

---

## 🚨 CÓDIGOS DE RESPUESTA

| Código | Significado | Descripción |
|--------|-------------|-------------|
| **200** | OK | Solicitud exitosa |
| **201** | CREATED | Recurso creado exitosamente |
| **204** | NO CONTENT | Eliminación exitosa |
| **400** | BAD REQUEST | Error en validación de datos |
| **404** | NOT FOUND | Recurso no encontrado |
| **500** | SERVER ERROR | Error interno del servidor |

---

## ⚠️ ERRORES COMUNES

### 400 - Datos inválidos
```json
{
  "timestamp": "2026-06-17T20:00:00",
  "status": 400,
  "error": "Validation Error",
  "message": "El nombre es requerido",
  "path": "/api/provincias"
}
```

### 404 - No encontrado
```json
{
  "timestamp": "2026-06-17T20:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Provincia no encontrada",
  "path": "/api/provincias/999"
}
```

---

## 📝 NOTAS IMPORTANTES

1. **Autenticación:** Actualmente sin autenticación (próxima fase)
2. **CORS:** Configurado solo para `http://localhost:4200`
3. **Validaciones:** Todos los campos requeridos son validados en el servidor
4. **Relaciones:** Algunos endpoints devuelven objetos anidados con datos relacionados
5. **Timestamps:** Las fechas se generan automáticamente en el servidor

---

**Última actualización:** 17 de Junio 2026
