# 🛒 Carrito de la compra

Este proyecto es una aplicación web de arquitectura de 3 capas (Cliente - Servidor) desarrollada como práctica para el 2º curso de Desarrollo de Aplicaciones Web (DAW). Simula el funcionamiento básico del carrito de la compra de una tienda online.

## 🚀 Tecnologías utilizadas

El proyecto está dividido en dos partes principales, utilizando un enfoque de *Monorepo*:

* **Frontend (Cliente):**
  * React (inicializado con Vite)
  * JavaScript / JSX
  * CSS
  * Fetch API para el consumo de datos

* **Backend (Servidor):**
  * Java 17+
  * Spring Boot (API REST)
  * Maven (gestor de dependencias)

## ✨ Funcionalidades principales

* **Catálogo de productos:** Visualización de artículos disponibles.
* **Añadir al carrito:** Comunicación asíncrona mediante peticiones `POST` para agregar items.
* **Cálculo dinámico:** El backend calcula automáticamente los subtotales según la cantidad y el total global de la compra.
* **Vaciar carrito:** Funcionalidad para eliminar todos los productos almacenados en la memoria del servidor mediante una petición `DELETE`.
* **Configuración CORS:** Implementación de políticas de seguridad en el servidor para permitir la comunicación con el cliente web.

## 📸 Demostración visual

![Captura del catálogo y carrito vacío](https://i.imgur.com/4I5H6rI.png)
![Captura del carrito con productos](https://i.imgur.com/5EfyCa7.png)

## ⚙️ Cómo ejecutar este proyecto localmente

Para probar la aplicación en tu propio equipo, necesitas ejecutar tanto el servidor backend como el cliente frontend.

### 1. Levantar el Backend (Java)
1. Abre la carpeta `backend` en el IDE.
2. Deja que Maven descargue las dependencias configuradas en el archivo `pom.xml`.
3. Ejecuta la clase principal `DemoApplication.java`.
4. El servidor se iniciará en `http://localhost:8080`.

### 2. Levantar el Frontend (React)
1. Abre una terminal y navega hasta la carpeta `frontend`.
2. Instala las dependencias de Node ejecutando:
   ```bash
   npm install