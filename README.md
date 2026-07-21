# springboot-relationship

Este repositorio está dedicado al aprendizaje y práctica de las **asociaciones y relaciones entre entidades** en **Spring Boot 3** y **JPA / Hibernate**.

El objetivo principal es comprender el funcionamiento interno de las bases de datos relacionales desde Java, aplicando mejores prácticas de mapeo y optimización de consultas.

---

### 📌 Conceptos y Anotaciones Implementadas

* **Relaciones MuchosaUno / UnoaMuchos:** Uso de `@ManyToOne` y `@OneToMany`.
* **Mapeo Bidireccional:** Configuración de relaciones bidireccionales con el atributo `mappedBy`.
* **Gestión de Claves Foráneas:** Personalización con `@JoinColumn`.
* **Cascada y Eliminación:** Control de operaciones en cadena con `cascade` y eliminación de huérfanos con `orphanRemoval = true`.
* **Carga de Datos (Fetch Strategy):** Manejo de estrategias de carga `LAZY` (perezosa) y `EAGER` (ansiosa) para evitar problemas de rendimiento.

---

### 🛠️ Tecnologías Utilizadas

* **Java**
* **Spring Boot 3**
* **Spring Data JPA / Hibernate**
* **Base de Datos (MySQL)**
* **Maven**
