CREATE TABLE persona (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(255),
  genero VARCHAR(255),
  edad INT,
  identificacion VARCHAR(255),
  direccion VARCHAR(255),
  telefono VARCHAR(255)
);

CREATE TABLE cliente (
  id SERIAL PRIMARY KEY,
  clienteid VARCHAR(255) UNIQUE,
  contraseña VARCHAR(255),
  estado BOOLEAN,
  persona_id INT,
  FOREIGN KEY (persona_id) REFERENCES persona (id)
);