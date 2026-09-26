# PARCIAL 1 - RentCar

## Pensamiento computacional: abstracción

### ¿Qué se solicita finalmente?

RentCar administra clientes, vehículos, modalidades de alquiler, reservas y servicios adicionales mediante registros manuales. Esto dificulta mantener organizada la información y hacer seguimiento de los servicios contratados.

Se solicita desarrollar una aplicación que apoye la administración de esa información y de las operaciones de alquiler. Cada reserva debe permitir relacionar al cliente, el vehículo asignado y la modalidad contratada. También debe registrar los servicios adicionales asociados y calcular el valor del alquiler según la modalidad, la duración, los servicios incluidos y los posibles descuentos establecidos por la empresa.

Además, el sistema debe permitir buscar un cliente por su número de teléfono y determinar si ese número es perfecto, es decir, si la suma de sus divisores propios es igual al número. También debe calcular los ingresos generados por las reservas realizadas dentro de un periodo consultado, acumulando el valor de esas reservas.

La solución se implementará en Java, con interfaz gráfica JavaFX y arquitectura MVC. El diseño debe representarse mediante un diagrama de clases con clases, atributos, métodos, relaciones, roles y multiplicidades. La implementación debe aplicar principios SOLID y patrones creacionales.

### ¿Qué información es relevante?

Para resolver el problema se consideran los datos que intervienen en el registro, la consulta y el cálculo de los alquileres:

- **Empresa:** nombre comercial, NIT, dirección, teléfono, correo electrónico y página web.
- **Clientes:** nombre completo, documento de identidad, teléfono, correo electrónico, edad y fecha de registro. Un cliente puede realizar varios alquileres.
- **Vehículos:** placa, marca, modelo, año, tipo y tarifa diaria. Un vehículo puede ser asignado a distintos clientes en periodos diferentes.
- **Modalidades de alquiler:** código, nombre, descripción, duración mínima en días, valor diario y estado (Disponible, Suspendida o Finalizada). Las modalidades ofrecidas son Económica, Ejecutiva y Premium; pueden incluir beneficios como kilometraje, seguro básico o asistencia en carretera. Premium requiere además tipo de cobertura, cantidad de conductores adicionales permitidos y características especiales.
- **Servicios adicionales:** código, nombre, descripción, precio y disponibilidad. Entre los ejemplos del enunciado están GPS, silla para bebé, conductor adicional y seguro complementario. Los servicios utilizados deben quedar asociados a la reserva correspondiente.
- **Reservas o alquileres:** información que relaciona al cliente, el vehículo y la modalidad, junto con el periodo, los servicios adicionales y el valor generado. Estos datos permiten identificar las reservas realizadas dentro de un periodo y sumar sus valores.
- **Cálculo del alquiler:** depende de la modalidad seleccionada, la duración contratada, los servicios adicionales y los posibles descuentos definidos por la empresa.

El enunciado no detalla las reglas concretas para aplicar descuentos ni especifica si el cálculo de ingresos debe excluir algún estado de reserva. Esas reglas tendrían que definirse como decisiones de diseño si la solución las necesita.

### ¿Cómo se agrupa la información?

La información puede organizarse en los siguientes grupos del dominio:

1. **Datos de la empresa:** información general de RentCar.
2. **Personas y recursos:** clientes y vehículos disponibles para los alquileres.
3. **Oferta de alquiler:** modalidades, sus beneficios y los servicios adicionales disponibles.
4. **Operaciones:** reservas que relacionan a los clientes con vehículos y modalidades, y que registran servicios adicionales y valores.
5. **Consultas y cálculos:** búsqueda de clientes por teléfono, comprobación del número perfecto y acumulación de ingresos por periodo.
6. **Aplicación:** interfaz en JavaFX, organizada con MVC, y lógica implementada en Java con principios SOLID y patrones creacionales.

### ¿Qué funcionalidades se solicitan?

- Registrar y consultar los datos de clientes.
- Registrar y consultar vehículos, sus características y tarifas.
- Gestionar las modalidades de alquiler, sus estados, beneficios y datos adicionales de Premium.
- Registrar los servicios adicionales, su precio y disponibilidad.
- Crear reservas que relacionen al cliente, el vehículo y la modalidad, y asociar los servicios solicitados.
- Calcular el valor del alquiler considerando modalidad, duración, servicios y posibles descuentos.
- Buscar un cliente por su número de teléfono y determinar si dicho número es perfecto.
- Consultar los ingresos de un periodo sumando el valor de las reservas realizadas dentro de ese periodo.
- Ofrecer estas operaciones mediante una interfaz gráfica JavaFX organizada con MVC.

