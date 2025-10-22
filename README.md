# 🛒 Sistema CRUD de Productos y Categorías (Java)

Este proyecto es una aplicación de consola en **Java** que permite gestionar **productos** y **categorías** mediante operaciones CRUD (*Crear, Leer, Actualizar, Eliminar y Reactivar*).  
Está diseñado con una arquitectura **orientada a objetos**, modular y extensible.

---

## 📋 Características principales

- **Gestión completa de Productos y Categorías**
  - Crear, listar, actualizar, eliminar y reactivar elementos.
- **Soporte para dos tipos de productos:**
  - 🧩 **Artículos:** Asociados a una categoría.
  - 🔧 **Servicios:** Con duración en horas.
- **Control de estado (activo/inactivo)** para productos y categorías.
- **Validaciones seguras** en la entrada de datos usando `Scanner`.
- **Interfaz de consola interactiva**, con menús anidados y opciones CRUD.
- **Filtrado inteligente:** Los productos listan solo si su categoría está activa.

---

## 🧱 Estructura del proyecto


```text
📦 ProyectoCRUD
┣ 📜 Main.java
┣ 📜 CrudConsola.java
┣ 📜 CrudProductos.java
┣ 📜 CrudCategorias.java
┣ 📜 Producto.java
┣ 📜 Articulo.java
┣ 📜 Servicio.java
┣ 📜 Categoria.java
┣ 📜 Vendible.java
┗ 📜 README.md

---

## ⚙️ Clases principales

### 🧩 `Producto` (Abstracta)
Representa un producto genérico del sistema.  
**Atributos:**
- `int id`
- `String nombre`
- `double precio`
- `boolean activo`

**Métodos:**
- Getters y setters
- `toString()` con formato legible
- Métodos de activación/desactivación

Implementa la interfaz `Vendible`.

---

### 🧺 `Articulo`
Subclase de `Producto`.  
**Atributos adicionales:**
- `Categoria categoria`

**Comportamiento:**
- Solo puede mostrarse si su categoría está activa.
- Puede cambiar de categoría o desactivarse según estado del catálogo.

---

### 🔧 `Servicio`
Subclase de `Producto`.  
**Atributos adicionales:**
- `int duracionHoras`

**Comportamiento:**
- Se muestra su duración al listar productos.
- Puede actualizarse igual que un artículo.

---

### 🏷️ `Categoria`
Clase que representa una categoría general.  
**Atributos:**
- `int id`
- `String nombreCategoria`
- `boolean activo`

**Funciones:**
- Crear nuevas categorías
- Activar/desactivar
- Listar categorías activas o inactivas

---

### ⚙️ `CrudConsola<T>`
Clase abstracta base para los CRUDs.  
Define los métodos genéricos que deben implementar sus subclases:
- `crear()`
- `listar()`
- `actualizar()`
- `eliminar()`

**Utilidades internas:**
- Lectura de texto (`leerTexto`)
- Lectura de números (`leerEntero`, `leerDouble`)
- Menús y validaciones de entrada

---

### 📦 `CrudProductos`
Gestiona los productos (Artículos y Servicios).  
**Funciones principales:**
- Crear nuevos productos.
- Listar productos con filtro de categoría activa.
- Actualizar precio, nombre o estado.
- Eliminar o reactivar productos.
- Crear una nueva categoría sin salir del flujo de creación.

---

### 🏷️ `CrudCategorias`
Gestiona las categorías disponibles.  
**Funciones:**
- Crear nueva categoría.
- Listar categorías activas/inactivas.
- Cambiar nombre de una categoría.
- Eliminar (desactivar) o reactivar categorías.

---

### 🖥️ `Main`
Clase principal con el **menú de navegación principal**:

╔══════════════════════════════╗
║        MENÚ PRINCIPAL        ║
╠══════════════════════════════╣
║ 1) CRUD de Productos         ║
║ 2) CRUD de Categorías        ║
║ 0) Salir                     ║
╚══════════════════════════════╝

**Flujo:**
1️⃣ Elegir CRUD de productos o categorías  
2️⃣ Operar sobre la lista correspondiente  
3️⃣ Volver al menú principal o salir

---

### 📦 Requisitos
- **Java 17 o superior**
- Consola o terminal compatible con UTF-8 (para mostrar bordes y caracteres especiales correctamente)

📚 Ejemplo de uso
╔══════════════════════════════╗
║     CREAR PRODUCTO NUEVO     ║
╠══════════════════════════════╣
║ 1) Crear Artículo            ║
║ 2) Crear Servicio            ║
╚══════════════════════════════╝

Elegí una opción: 1
Nombre del artículo: Teclado Gamer
Precio del artículo: 18000

Categorías activas disponibles:
1) Electrónica
2) Ropa
3) Servicios Técnicos
0) Crear nueva categoría

Elegí ID de la categoría o 0 para crear nueva: 1
✅ Artículo creado exitosamente:
→ [ID: 4] Teclado Gamer ($18000.0) [Activo] Categoría: ELECTRÓNICA

🧠 Conceptos aplicados

Programación Orientada a Objetos (POO)

Abstracción, herencia y polimorfismo

Uso de interfaces (Vendible)

Colecciones genéricas (ArrayList)

Validaciones de entrada

Separación de responsabilidades entre clases

Reutilización de código con CrudConsola<T>

✨ Mejoras futuras

Guardar y cargar datos desde archivo (.txt, .csv) o base de datos (MySQL o SQLite).

Implementar persistencia de objetos con serialización.

Filtros avanzados de productos (por precio, categoría o estado).

Menú visual con librerías como Lanterna para una interfaz más moderna.

Exportar listados a formato .csv o .json.

👨‍💻 Autor

Max Rodríguez
Proyecto educativo en Java para práctica de POO y gestión de datos por consola.
Desarrollado como ejercicio de estructura CRUD con entidades relacionadas.
