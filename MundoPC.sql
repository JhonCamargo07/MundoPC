CREATE DATABASE mundo_pc;
USE mundo_pc;

CREATE TABLE dispositivo_entrada(
    id_dispositivo int primary key not null auto_increment,
    tipo_entrada varchar(30) not null,
    marca_dispositivo varchar(30) not null
);

CREATE TABLE raton(
    id_raton int primary key not null auto_increment,
    id_dispositivo int not null
);

CREATE TABLE teclado(
    id_teclado int primary key not null auto_increment,
    id_dispositivo int not null
);

CREATE TABLE monitor(
    id_monitor int primary key not null auto_increment,
    marca varchar(30) not null,
    size double not null
);

CREATE TABLE computador(
    id_computador int primary key not null auto_increment,
    nombre varchar(30) not null,
    id_monitor int not null,
    id_teclado int not null,
    id_raton int not null
);

CREATE TABLE orden(
    id_orden int primary key not null auto_increment,
    max_computador int not null,
    id_computador int not null
);


-- =============================================
-- =============== ALTERACIONES =================
-- =============================================

ALTER TABLE raton
ADD CONSTRAINT raton_dispositivo_entrada
FOREIGN KEY (id_dispositivo)
REFERENCES dispositivo_entrada(id_dispositivo) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE teclado
ADD CONSTRAINT teclado_dispositivo_entrada
FOREIGN KEY (id_dispositivo)
REFERENCES dispositivo_entrada(id_dispositivo) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE computador
ADD CONSTRAINT computador_monitor FOREIGN KEY (id_monitor) REFERENCES monitor(id_monitor) ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT computador_raton FOREIGN KEY (id_raton) REFERENCES raton(id_raton) ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT computador_teclado FOREIGN KEY (id_teclado) REFERENCES teclado(id_teclado) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE orden
ADD CONSTRAINT orden_computador
FOREIGN KEY (id_computador)
REFERENCES computador(id_computador) ON UPDATE CASCADE ON DELETE CASCADE;
