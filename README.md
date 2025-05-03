# Product Manager REST API

A Java-based RESTful API for product management using JAX-RS (Jersey). This API supports full CRUD (Create, Read, Update, Delete) operations.

---

## Table of Contents

- [API Endpoints](#api-endpoints)
- [Request/Response Examples](#requestresponse-examples)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Deployment](#deployment)
- [Testing](#testing)
- [Notes](#notes)

---

## API Endpoints

### Base URL
```
http://localhost:8081/product_manager_war/api/product-manager
```

### Endpoints

| Method | Endpoint                | Description              | Request Body Example                                          |
|--------|-------------------------|--------------------------|---------------------------------------------------------------|
| POST   | `/add-product`          | Add a new product        | `{"id":1,"name":"Laptop","price":999.99,"quantity":10}`       |
| GET    | `/get-product/{id}`     | Get a product by ID      | -                                                             |
| GET    | `/get-all-products`     | Get all products         | -                                                             |
| PUT    | `/update-product/{id}`  | Update a product by ID   | `{"id":1,"name":"Updated Laptop","price":1099.99,"quantity":5}`|
| DELETE | `/delete-product?id={id}`| Delete a product by ID  | -                                                             |

---

## Request/Response Examples

### 1. Add Product

**Request:**
```http
POST /api/product-manager/add-product
Content-Type: application/json

{
    "id": 101,
    "name": "Smartphone",
    "price": 599.99,
    "quantity": 25
}
```

**Response:**
```json
"Product with ID 101 added successfully."
```

---

### 2. Get Product

**Request:**
```http
GET /api/product-manager/get-product/101
```

**Response:**
```json
{
    "id": 101,
    "name": "Smartphone",
    "price": 599.99,
    "quantity": 25
}
```

---

### 3. Get All Products

**Request:**
```http
GET /api/product-manager/get-all-products
```

**Response:**
```json
[
    {
        "id": 101,
        "name": "Smartphone",
        "price": 599.99,
        "quantity": 25
    }
]
```

---

## Project Structure

```
src/
└── main/
    └── java/
        └── com/
            └── fawry/
                └── product_manager/
                    ├── HelloApplication.java          # JAX-RS application configuration
                    ├── Product.java                   # Product model
                    ├── ProductResource.java           # REST endpoints
                    ├── ProductService.java            # Business logic
                    └── ProductServiceInterface.java   # Service interface
```

---

## Prerequisites

- Java 11 or higher  
- Jakarta EE 9+ compatible server (e.g., Payara, TomEE, WildFly)  
- Maven

---

## Deployment

1. **Build the project:**
   ```bash
   mvn clean package
   ```

2. **Deploy the generated WAR file to your application server.**

---

## Testing

You can test the API using tools like Postman, cURL, or any HTTP client.

### Example using cURL:

```bash
# Add a product
curl -X POST http://localhost:8081/product_manager_war/api/product-manager/add-product \
-H "Content-Type: application/json" \
-d '{"id":102,"name":"Tablet","price":299.99,"quantity":15}'

# Get all products
curl http://localhost:8081/product_manager_war/api/product-manager/get-all-products
```

---

## Notes

- All endpoints accept and return JSON.
- Product ID must be a positive integer.
- Price must be a positive number.
- Quantity cannot be negative.

---

**Enjoy building with JAX-RS!**
