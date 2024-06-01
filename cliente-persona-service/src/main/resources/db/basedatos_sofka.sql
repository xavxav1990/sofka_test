-- Borrar tablas existentes si es necesario
DROP TABLE IF EXISTS persona;

-- Crear la tabla persona con la columna tipo y todas las columnas necesarias
CREATE TABLE persona (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(10) NOT NULL,
    edad INT NOT NULL,
    identificacion VARCHAR(20) UNIQUE NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- Añadir esta columna
    contrasenia VARCHAR(255),  -- Añadir esta columna para Cliente
    estado BOOLEAN             -- Añadir esta columna para Cliente
);

-- Insertar datos en la tabla persona
INSERT INTO persona (nombre, genero, edad, identificacion, direccion, telefono, tipo, contrasenia, estado)
VALUES
    ('Jose Lema', 'Masculino', 30, 'ID123456', 'Otavalo sn y principal', '098254785', 'CLIENTE', '1234', TRUE),
    ('Marianela Montalvo', 'Femenino', 28, 'ID654321', 'Amazonas y NNUU', '097548965', 'CLIENTE', '5678', TRUE),
    ('Juan Osorio', 'Masculino', 35, 'ID789012', '13 junio y Equinoccial', '098874587', 'CLIENTE', '1245', TRUE);
-- Crear la tabla cliente
CREATE TABLE cliente (
    clienteid SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(10) NOT NULL,
    edad INT NOT NULL,
    identificacion VARCHAR(20) UNIQUE NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    contrasenia VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL
);

-- Insertar datos en la tabla cliente
INSERT INTO cliente (nombre, genero, edad, identificacion, direccion, telefono, contrasenia, estado)
VALUES
    ('Jose Lema', 'Masculino', 30, 'ID123456', 'Otavalo sn y principal', '098254785', '1234', TRUE),
    ('Marianela Montalvo', 'Femenino', 28, 'ID654321', 'Amazonas y NNUU', '097548965', '5678', TRUE),
    ('Juan Osorio', 'Masculino', 35, 'ID789012', '13 junio y Equinoccial', '098874587', '1245', TRUE);