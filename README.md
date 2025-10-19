# ScreenTime 

## Descripción del Proyecto

**ScreenTime** es una aplicación de utilidades para Android, desarrollada con **Jetpack Compose** y **Kotlin**, con funcionalidades de bienestar digital. Permite al usuario visualizar estadísticas detalladas sobre el uso de aplicaciones, notificaciones y lanzamientos, además de configurar límites de tiempo y horarios de bloqueo.

El proyecto se centra en ofrecer una interfaz de usuario limpia y moderna, utilizando componentes modulares de Compose para la visualización de datos y la gestión de límites.

---

## Características Principales

## 1. Módulo de Inicialización y Autenticación

Este módulo gestiona la experiencia del usuario desde el primer contacto con la aplicación hasta el acceso al panel de control principal, garantizando el cumplimiento de términos legales y la autenticación.

| Componente | Descripción |
| :--- | :--- |
| **PANTALLA DE INICIO** | Pantalla de bienvenida estática, utilizada para presentar la marca y cargar recursos esenciales antes de iniciar el flujo de configuración. |
| **PANTALLA DE INDICACIONES** | Serie de pantallas informativas (onboarding) que guían al usuario a través de las funcionalidades clave y los permisos requeridos por el sistema operativo. |
| **TÉRMINOS DE SERVICIO** | Presentación de los acuerdos legales y políticas de privacidad. Requiere la aceptación explícita del usuario antes de continuar con el uso de la aplicación. |
| **INICIO DE SESIÓN LOCAL** | Proceso de autenticación a través de credenciales locales (PIN, patrón o datos biométricos) para asegurar que solo el usuario autorizado pueda modificar los límites de uso y acceder a las estadísticas. |
| **PANTALLA BIENVENIDA** | Pantalla final del proceso de configuración inicial, confirmando el acceso al panel de control principal de la aplicación. |

---

## 2. Módulo de Navegación y Usabilidad

Este módulo comprende los elementos transversales de la interfaz que permiten la interacción, búsqueda, y acceso a las configuraciones principales de la aplicación.

| Componente | Descripción |
| :--- | :--- |
| **MENU** | Componente de navegación lateral o superior que proporciona acceso directo a las secciones principales (Estadísticas, Límites, Reportes, Configuraciones). |
| **BUSQUEDAS** | Funcionalidad de búsqueda integrada, típicamente usada para encontrar rápidamente aplicaciones dentro de las listas de límites o estadísticas. |
| **NOTIFICACIONES DE USO** | Sistema de alertas in-app que informa al usuario cuando se acerca o se excede un límite de tiempo de aplicación configurado. |
| **NOTIFICACIONES POR SEMANA** | Vista estadística que detalla la cantidad de notificaciones recibidas por día o por aplicación durante el período semanal. |

---

## 3. Módulo de Bienestar Digital y Control de Límites

Este es el módulo central de la aplicación, dedicado a la visualización de datos de uso y a la configuración granular de las restricciones de tiempo y acceso a las aplicaciones.

| Componente | Descripción |
| :--- | :--- |
| **ESTADÍSTICAS** | Panel principal que resume el tiempo total de uso y la actividad de las aplicaciones, sirviendo como punto de partida para análisis más detallados. |
| **LANZAMIENTOS DE APLICACIONES** | Vista especializada que cuantifica el número de veces que cada aplicación ha sido abierta (lanzada) en un período de tiempo determinado, usualmente diaria o semanal. |
| **LIMITAR APPs** | Interfaz para seleccionar las aplicaciones específicas sobre las cuales se aplicarán las restricciones de tiempo o bloqueo. |
| **OPCIONES DE LIMITACIÓN** | Menú que presenta los distintos modos para restringir el uso de una aplicación, incluyendo: bloqueo permanente, límite de uso diario, o bloqueo por horario. |
| **ESTABLECER LIMITES** | Formulario detallado (`LimitesUso.kt`) para configurar la duración máxima de uso en horas y minutos que una aplicación tendrá permitida por día. |
| **SEGÚN HORARIO** | Formulario detallado (`Horarios.kt`) para definir días específicos y un rango de tiempo de inicio/fin durante el cual el acceso a una aplicación estará totalmente bloqueado. |
| **REPORTES Y EXPORTACIÓN** | Funcionalidad (`Reportes.kt`) que permite generar y exportar los datos históricos de uso del dispositivo en formato CSV, además de incluir la opción de restablecer todas las estadísticas. |
---

## Tecnologías Utilizadas

* **Lenguaje:** Kotlin
* **UI Toolkit:** Jetpack Compose
* **Patrón de Diseño:** Composable Functions
* **Iconografía:** Material Icons (Icons.Filled y Icons.AutoMirrored)
