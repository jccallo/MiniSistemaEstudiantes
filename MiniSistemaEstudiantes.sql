-- creamos la base de datos
create database MiniSistemaEstudiantes;

-- elegimos la base de datos
use MiniSistemaEstudiantes;

-- tabla estudiante
CREATE TABLE estudiante (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  apellido VARCHAR(45) NULL,
  dni VARCHAR(45) NULL,
  email VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL,
  CONSTRAINT pk_estudiante PRIMARY KEY (id),
  CONSTRAINT uc_estudiante UNIQUE (dni, email, telefono)
);

-- obtener todos los registros
SELECT * FROM estudiante

-- insertar un registro
INSERT INTO estudiante 
  (nombre, apellido, dni, email, telefono) 
VALUES 
  ("Admin", "Manager", "12345678", "amanager@correo.com", "987654321")

-- actualizar un registro
-- UPDATE estudiante SET email = "jperez@gmail.com", telefono = "999999999" 
-- WHERE id = 1;

-- borrar un registro
-- DELETE FROM persona 
-- WHERE id = 3;