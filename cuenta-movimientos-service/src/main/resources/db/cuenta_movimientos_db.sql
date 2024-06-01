-- Crear la tabla cuenta
CREATE TABLE cuenta (
    numerocuenta SERIAL PRIMARY KEY,
    tipocuenta VARCHAR(50) NOT NULL,
    saldoinicial DECIMAL(10, 2) NOT NULL,
    estado BOOLEAN NOT NULL,
    clienteid INT NOT NULL
);

-- Insertar datos en la tabla cuenta
INSERT INTO cuenta (tipocuenta, saldoinicial, estado, clienteid)
VALUES
    ('Ahorro', 2000, TRUE, 1), -- Jose Lema
    ('Corriente', 100, TRUE, 2), -- Marianela Montalvo
    ('Ahorros', 0, TRUE, 3), -- Juan Osorio
    ('Ahorros', 540, TRUE, 2), -- Marianela Montalvo
    ('Corriente', 1000, TRUE, 1); -- Nueva cuenta para Jose Lema

-- Crear la tabla movimientos
CREATE TABLE movimientos (
    id SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    tipomovimiento VARCHAR(50) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
    numerocuenta INT NOT NULL
);

-- Insertar datos en la tabla movimientos
INSERT INTO movimientos (fecha, tipomovimiento, valor, saldo, numerocuenta)
VALUES
    ('2022-02-10', 'Retiro', -575, 1425, 1), -- Cuenta de Jose Lema
    ('2022-02-08', 'Deposito', 600, 700, 2), -- Cuenta de Marianela Montalvo
    ('2022-02-08', 'Deposito', 150, 150, 3), -- Cuenta de Juan Osorio
    ('2022-02-08', 'Retiro', -540, 0, 4); -- Cuenta de Marianela Montalvo