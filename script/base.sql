CREATE DATABASE IF NOT EXISTS deathStar;
USE deathStar;

CREATE TABLE planetas(id int NOT NULL, nombre varchar(100), sector varchar(100), poblacion bigint, diametro double, nivel_recursos int, destruido int, PRIMARY KEY (id));

CREATE TABLE soldados(
	identificador varchar(20) NOT NULL,
    estado varchar(20),
    tiempoActivo int NOT NULL,
    tipo varchar(20),
    habilidadDeDisparo double, 
    personalCargo int, 
    horasDeVuelo double,
    
    PRIMARY KEY(identificador)
);

INSERT INTO planetas (id, nombre, sector, poblacion, diametro, nivel_recursos, destruido) VALUES
(6, 'Kashyyyk', 'Borde Medio', 45000000, 12765.0, 7, 0),
(7, 'Mustafar', 'Borde Exterior', 20000, 4200.0, 9, 0),
(8, 'Geonosis', 'Borde Exterior', 100000000, 11370.0, 6, 1),
(9, 'Kamino', 'Espacio Salvaje', 1000000, 19720.0, 8, 0),
(10, 'Aenima', 'Sector Espiral', 4600000, 10200.5, 5, 0),
(11, 'Lateralus', 'Sector Espiral', 9000000, 11235.8, 8, 0),
(12, 'Minerva', 'Sector Koi', 3000000, 9800.0, 6, 0),
(13, 'Arch-V', 'Núcleo Base', 150000, 6400.0, 9, 0),
(14, 'Leyndell', 'Tierras Intermedias', 800000, 10500.0, 10, 0),
(15, 'Redstone Prime', 'Sector Técnico', 25000, 5000.0, 9, 0),
(16, 'Netheria', 'Sector Técnico', 10000, 4000.0, 7, 1),
(17, 'Scranton', 'Borde Medio', 120000, 6000.0, 4, 0),
(18, 'Pasadena-4', 'Núcleo', 150000, 7000.0, 8, 0),
(19, 'Madre Linda', 'Colonias', 50000, 5500.0, 7, 0),
(20, 'Naboo', 'Borde Medio', 4500000000, 12120.0, 8, 0),
(21, 'Bespin', 'Borde Exterior', 6000000, 118000.0, 9, 0),
(22, 'Dagobah', 'Borde Exterior', 0, 14410.0, 1, 0),
(23, 'Mandalore', 'Borde Exterior', 4000000, 9200.0, 6, 1),
(24, 'Dantooine', 'Borde Exterior', 300000, 9830.0, 5, 0),
(25, 'Lothal', 'Borde Exterior', 2000000, 8200.0, 4, 0),
(26, 'Jakku', 'Regiones Desconocidas', 15000, 6400.0, 2, 0),
(27, 'Endor', 'Borde Exterior', 30000000, 4900.0, 3, 0),
(28, 'Farum Azula', 'Tierras Intermedias', 1000, 3200.0, 5, 1),
(29, 'Opiate Minor', 'Sector Espiral', 50000, 4100.0, 4, 0),
(30, 'Koinoyokan', 'Sector Koi', 2500000, 8700.0, 7, 0),
(31, 'Yavin IV', 'Borde Exterior', 1000, 10200.0, 3, 0),
(32, 'Hoth', 'Borde Exterior', 500, 7200.5, 2, 0);

INSERT INTO soldados (identificador, estado, tiempoActivo, tipo, habilidadDeDisparo, personalCargo, horasDeVuelo) VALUES
	('TK-114', 'Activo', 3, 'Stormtrooper', 6.5, NULL, NULL),
    ('TK-208', 'Activo', 5, 'Stormtrooper', 7.2, NULL, NULL),
    ('TK-332', 'Retirado', 8, 'Stormtrooper', 4.0, NULL, NULL),
    ('TK-421', 'Activo', 2, 'Stormtrooper', 5.5, NULL, NULL),
    ('TK-509', 'Desertor', 6, 'Stormtrooper', 6.8, NULL, NULL),
    ('TK-612', 'Activo', 4, 'Stormtrooper', 8.1, NULL, NULL),
    ('TK-718', 'Retirado', 15, 'Stormtrooper', 5.0, NULL, NULL),
    ('TK-802', 'Activo', 1, 'Stormtrooper', 7.9, NULL, NULL),
    ('TK-155', 'Activo', 7, 'Stormtrooper', 6.2, NULL, NULL),
    ('TK-290', 'Retirado', 3, 'Stormtrooper', 5.8, NULL, NULL),
    ('TK-375', 'Activo', 9, 'Stormtrooper', 7.0, NULL, NULL),
    ('TK-482', 'Activo', 5, 'Stormtrooper', 8.3, NULL, NULL),
    ('TK-555', 'Retirado', 12, 'Stormtrooper', 4.5, NULL, NULL),
    ('TK-661', 'Activo', 6, 'Stormtrooper', 7.6, NULL, NULL),
    ('TK-777', 'Activo', 2, 'Stormtrooper', 6.9, NULL, NULL),
    ('DS-61-1', 'Activo', 5, 'Piloto', NULL, NULL, 150.5),
    ('DS-61-2', 'Activo', 7, 'Piloto', NULL, NULL, 280.0),
    ('DS-61-3', 'Desertor', 2, 'Piloto', NULL, NULL, 42.1),
    ('DS-61-4', 'Activo', 9, 'Piloto', NULL, NULL, 450.2),
    ('DS-61-5', 'Retirado', 14, 'Piloto', NULL, NULL, 920.0),
    ('DS-61-6', 'Activo', 4, 'Piloto', NULL, NULL, 110.6),
    ('DS-61-7', 'Retirado', 6, 'Piloto', NULL, NULL, 195.3),
    ('DS-61-8', 'Activo', 8, 'Piloto', NULL, NULL, 320.8),
    ('DS-61-9', 'Activo', 3, 'Piloto', NULL, NULL, 85.0),
    ('Code-21', 'Activo', 20, 'Almirante', NULL, 450, NULL),
    ('Code-42', 'Activo', 25, 'Almirante', NULL, 1100, NULL),
    ('Code-88', 'Retirado', 35, 'Almirante', NULL, 3000, NULL),
    ('Code-13', 'Activo', 15, 'Almirante', NULL, 280, NULL),
    ('Code-57', 'Retirado', 18, 'Almirante', NULL, 650, NULL),
    ('Code-99', 'Activo', 12, 'Almirante', NULL, 190, NULL);
    
    SELECT * FROM planetas;
    SELECT * FROM soldados;