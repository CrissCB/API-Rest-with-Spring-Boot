# 🛍️ Products API

REST API para la gestión de productos, desarrollada con **Spring Boot** y conectada a una base de datos **PostgreSQL**.

---

## 🛠️ Tecnologías utilizadas

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL driver
- Validation
- Dev Tools
- Lombok
- PostgreSQL
- Maven

---

## ⚙️ Configuración de la base de datos

En el archivo `src/main/resources/application.properties`, configura tu conexión a PostgreSQL:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_de_tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

> Asegúrate de tener PostgreSQL instalado y corriendo antes de iniciar la aplicación.

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
```bash
git clone https://github.com/CrissCB/API-Rest-with-Spring-Boot.git
```

2. Entra a la carpeta del proyecto:
```bash
cd tu-repositorio
```

3. Ejecuta el proyecto con Maven:
```bash
./mvnw spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

---

## 📦 Endpoints

La URL base de todos los endpoints es:
```
http://localhost:8080/api/products
```

---

### ➕ Crear un producto
**POST** `/api/products`

**Body (JSON):**
```json
{
    "name": "Laptop Lenovo",
    "description": "Laptop para desarrollo",
    "price": 1500.00,
    "stock": 10
}
```

**Respuesta exitosa — HTTP 201 Created:**
```json
{
    "id": 1,
    "name": "Laptop Lenovo",
    "description": "Laptop para desarrollo",
    "price": 1500.00,
    "stock": 10,
    "createdAt": "2025-03-04T12:00:00Z"
}
```

---

### 📋 Listar todos los productos
**GET** `/api/products`

No requiere body.

**Respuesta exitosa — HTTP 200 OK:**
```json
[
    {
        "id": 1,
        "name": "Laptop Lenovo",
        "description": "Laptop para desarrollo",
        "price": 1500.00,
        "stock": 10,
        "createdAt": "2025-03-04T12:00:00Z"
    }
]
```

---

### 🔍 Obtener un producto por ID
**GET** `/api/products/{id}`

No requiere body.

**Respuesta exitosa — HTTP 200 OK:**
```json
{
    "id": 1,
    "name": "Laptop Lenovo",
    "description": "Laptop para desarrollo",
    "price": 1500.00,
    "stock": 10,
    "createdAt": "2025-03-04T12:00:00Z"
}
```

**Producto no encontrado — HTTP 404 Not Found:**
```json
{
    "code": "NOT_FOUND",
    "message": "Product 1 not found",
    "timestamp": "2025-03-04T12:00:00Z",
    "path": "/api/products/1"
}
```

---

### ✏️ Actualizar un producto
**PUT** `/api/products/{id}`

**Body (JSON):**
```json
{
    "name": "Laptop Lenovo actualizada",
    "description": "Nueva descripción",
    "price": 1800.00,
    "stock": 5
}
```

**Respuesta exitosa — HTTP 200 OK:**
```json
{
    "id": 1,
    "name": "Laptop Lenovo actualizada",
    "description": "Nueva descripción",
    "price": 1800.00,
    "stock": 5,
    "createdAt": "2025-03-04T12:00:00Z"
}
```

---

### 🗑️ Eliminar un producto
**DELETE** `/api/products/{id}`

No requiere body.

**Respuesta exitosa — HTTP 204 No Content** — Sin cuerpo en la respuesta.

**Producto no encontrado — HTTP 404 Not Found:**
```json
{
    "code": "NOT_FOUND",
    "message": "Product 1 not found",
    "timestamp": "2025-03-04T12:00:00Z",
    "path": "/api/products/1"
}
```

---

## ❌ Manejo de errores

### Error de validación — HTTP 400 Bad Request
```json
{
    "code": "VALIDATION_ERROR",
    "message": "Request validation failed",
    "timestamp": "2025-03-04T12:00:00Z",
    "path": "/api/products",
    "fields": {
        "name": "name is required",
        "price": "must be greater than 0.0"
    }
}
```

### Recurso no encontrado — HTTP 404 Not Found
```json
{
    "code": "NOT_FOUND",
    "message": "Product 99 not found",
    "timestamp": "2025-03-04T12:00:00Z",
    "path": "/api/products/99"
}
```

---

## 📐 Validaciones del modelo

| Campo | Regla |
|---|---|
| `name` | Obligatorio, máximo 150 caracteres |
| `description` | Opcional, máximo 2000 caracteres |
| `price` | Obligatorio, debe ser mayor a 0.0 |
| `stock` | Opcional, debe ser mayor o igual a 0 |

---

## 🧪 Pruebas con Postman

1. Abre Postman y crea una nueva petición.
2. Selecciona el método HTTP (GET, POST, PUT, DELETE).
3. Ingresa la URL del endpoint.
4. Para peticiones con body (POST y PUT):
   - Ve a la pestaña **Body**
   - Selecciona **raw**
   - Elige **JSON** en el desplegable
   - Escribe el JSON correspondiente
5. Haz clic en **Send**.
