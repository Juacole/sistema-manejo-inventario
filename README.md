# 📦 Sistema de Manejo de Inventario

Este repositorio contiene el ecosistema completo (Backend y Frontend) de una aplicación web diseñada para la gestión integral de un inventario de productos.

El proyecto está estructurado como un **Monorepo**, dividiendo claramente la lógica de negocio y persistencia de datos (API REST) de la interfaz de usuario (Cliente Web), demostrando buenas prácticas en el desarrollo Full-Stack.

---

## 🛠️ Stack Tecnológico

El proyecto utiliza un stack moderno y robusto, separando las responsabilidades en dos entornos diferenciados:

### Backend (API REST)
- **Java:** Lenguaje principal de la lógica de servidor.
- **Spring Boot:** Framework para la creación ágil de la API y configuración de la inyección de dependencias.
- **Spring Data JPA / Hibernate:** Mapeo objeto-relacional (ORM) para la comunicación con la base de datos.
- **Maven:** Herramienta de gestión de dependencias y construcción del proyecto.

### Frontend (Cliente Web)
- **Angular:** Framework principal para la construcción de la Single Page Application (SPA).
- **TypeScript:** Superconjunto de JavaScript que aporta tipado estático al frontend.
- **Tailwind CSS:** Framework de utilidades CSS para un diseño a medida, rápido y totalmente responsivo.
- **HTML5 & Node.js:** Base estructural y entorno de ejecución para las herramientas de desarrollo del cliente.

---

## 🗂️ Estructura del Monorepo

El código está organizado en dos carpetas principales que funcionan de forma independiente:

- **`backend/`:** Contiene todo el código fuente de Spring Boot, modelos, controladores REST, repositorios y configuración de acceso a datos.
- **`frontend/`:** Contiene el proyecto de Angular, componentes visuales, servicios de conexión a la API y configuración de estilos con Tailwind.

---

## 🚀 Cómo ejecutar el proyecto localmente

Para probar la aplicación en tu máquina, necesitarás levantar ambos servicios. Sigue estos pasos:

### 1. Levantar el Backend (Spring Boot)

Asegúrate de tener **Java** instalado y tu gestor de base de datos local configurado (según los parámetros de tu `application.properties`). Abre una terminal y navega a la carpeta del backend:

```bash
cd backend
```

**En Windows:**
```bash
.\mvnw.cmd spring-boot:run
```

**En macOS / Linux:**
```bash
.\mvnw spring-boot:run
```
El servidor backend iniciará y expondrá los endpoints de la API REST (generalmente en el puerto 8080).

### 2. Levantar el Frontend (Angular)

Abre una nueva pestaña o ventana en tu terminal (manteniendo el backend en ejecución), asegúrate de tener Node.js instalado y navega a la carpeta del frontend:
```bash
cd frontend
```

Instala las dependencias del proyecto (solo la primera vez):
```bash
npm install
```

Inicia el servidor de desarrollo de Angular:
```bash
npm start
```

(O si tienes el CLI de Angular instalado globalmente: ng serve)

Una vez compilado, abre tu navegador web y dirígete a http://localhost:4200 para interactuar con la aplicación.