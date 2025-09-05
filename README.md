# Gestor Bazar

Aplicación de gestión de inventario y ventas para bazares, desarrollada con **Spring Boot** y **MySQL**.  
Permite administrar clientes, productos y ventas, con operaciones CRUD y reportes simples.

---

## Tech Stack

- **Backend**: Spring Boot  
- **Base de datos**: MySQL  
- **Testing**: Postman para probar los endpoints

---

## Endpoints

### Clientes

| Método | Endpoint                  | Descripción                     |
|--------|---------------------------|---------------------------------|
| POST   | `/cliente/crear`          | Crear un cliente               |
| GET    | `/clientes/traer`         | Listar todos los clientes      |
| GET    | `/cliente/{id_cliente}`   | Obtener cliente por ID        |
| PUT    | `/editar/{id_cliente}`    | Editar cliente por ID         |
| DELETE | `/cliente/eliminar/{id_cliente}` | Eliminar cliente por ID |

---

### Productos

| Método | Endpoint                         | Descripción                   |
|--------|---------------------------------|-------------------------------|
| POST   | `/producto/crear`                | Crear un producto             |
| GET    | `/productos/traer`               | Listar todos los productos    |
| GET    | `/producto/{codigo_producto}`    | Obtener producto por ID       |
| PUT    | `/producto/editar/{codigo_producto}` | Editar producto por ID |
| DELETE | `/producto/eliminar/{codigo_producto}` | Eliminar producto por ID |

---

### Ventas

| Método | Endpoint                        | Descripción                       |
|--------|---------------------------------|-----------------------------------|
| POST   | `/venta/crear`                  | Crear una venta                   |
| GET    | `/venta/traer`                  | Listar todas las ventas           |
| GET    | `/venta/{codigo_venta}`         | Obtener venta por código          |
| PUT    | `/venta/editar/{codigo_venta}`  | Editar venta por código           |
| DELETE | `/venta/eliminar/{codigo_venta}` | Eliminar venta por código        |
| GET    | `/ventas/mayor_venta`           | Obtener la venta  (`VentaMayorDTO`) |
| GET    | `/ventaSimple/resumen`          | Resumen de ventas simples (`VentaSimpleDTO`) |

---

## DTOs importantes

### VentaMayorDTO
### VentaMenor

---

## Cosas a mejorar

1. Implementar autenticación y roles de usuario
2. Agregar reportes avanzados y filtros
3. Implementar pruebas unitarias e integración
