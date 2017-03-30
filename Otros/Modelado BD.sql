CREATE DATABASE AA_Software;
use AA_Software;

-- SE CREAN LAS TABLAS
DROP TABLE IF EXISTS t_informacion_empresa;
CREATE TABLE t_informacion_empresa (
  id int NOT NULL AUTO_INCREMENT,
  identificacion int not null,
  razon_social varchar(100) not null,
  representante varchar(100) not null,
  regimen varchar(20) not null,
  url_logo varchar(50) not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

INSERT INTO t_informacion_empresa(identificacion,razon_social,representante,regimen,url_logo) VALUES ('999999999','prueba','prueba','prueba','url');

DROP TABLE IF EXISTS t_usuarios;
CREATE TABLE t_usuarios (
  id int NOT NULL AUTO_INCREMENT,
  nombre varchar(100) not null,
  usuario varchar(20) not null,
  contrasena varchar(20) not null,
  estado int not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;

INSERT INTO t_usuarios(nombre,usuario,contrasena,estado) VALUES ('administrador','admin','123456','1');

DROP TABLE IF EXISTS t_clientes;
CREATE TABLE t_clientes (
  id int NOT NULL AUTO_INCREMENT,
  identificacion int not null,
  nombre varchar(200) not null,
  correo varchar(50) not null,
  telefono varchar(30) not null,
  estado int not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_proveedores;
CREATE TABLE t_proveedores (
  id int NOT NULL AUTO_INCREMENT,
  identificacion int not null,
  nombre varchar(100) not null,
  correo varchar(50) not null,
  telefono varchar(30) not null,
  estado int not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_almacenes;
CREATE TABLE t_almacenes (
  id int NOT NULL AUTO_INCREMENT,
  descripcion int not null,
  estado int not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_clase_productos;
CREATE TABLE t_clase_productos (
  id int NOT NULL AUTO_INCREMENT,
  descripcion int not null,
  estado int not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_productos;
CREATE TABLE t_productos (
  id int NOT NULL AUTO_INCREMENT,
  codigo varchar(50) not null,
  descripcion varchar(100) not null,
  ultimo_costo int not null,
  id_clase int not null,
  estado int not null,
  PRIMARY KEY (`id`),
  KEY `fk_id_clase` (`id_clase`),
  CONSTRAINT `fk_id_clase` FOREIGN KEY (`id_clase`) REFERENCES `t_clase_productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_lista_precios;
CREATE TABLE t_lista_precio (
  id_producto int not null,
  margen_venta double(4,2) not null,
  precio_venta int not null,
  KEY `fk_id_producto_lista_precio` (`id_producto`),
  CONSTRAINT `fk_id_producto_lista_precio` FOREIGN KEY (`id_producto`) REFERENCES `t_productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_factura_ventas;
CREATE TABLE t_factura_ventas(
  id int NOT NULL AUTO_INCREMENT,
  id_cliente int not null,
  fecha date not null,
  subtotal int not null,
  descuento int not null,
  total int not null,
  observacion text(200) not null,
  estado int not null,
  PRIMARY KEY (`id`),
  KEY `fk_id_cliente` (`id_cliente`),
  CONSTRAINT `fk_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `t_clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_detalle_factura_ventas;
CREATE TABLE t_detalle_factura_ventas(
  id_factura_venta int not null,
  id_producto int not null,
  descripcion_producto varchar(200) not null,
  cantidad int not null,
  precio_unitario int not null,
  descuento double(4,2) not null,
  KEY `fk_id_factura_venta` (`id_factura_venta`),
  KEY `fk_id_producto_factura_venta` (`id_producto`),
  CONSTRAINT `fk_id_factura_venta` FOREIGN KEY (`id_factura_venta`) REFERENCES `t_factura_ventas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_producto_factura_venta` FOREIGN KEY (`id_producto`) REFERENCES `t_productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_factura_compras;
CREATE TABLE t_factura_compras(
  id int NOT NULL AUTO_INCREMENT,
  id_proveedor int not null,
  fecha date not null,
  total int not null,
  observacion text(200) not null,
  estado int not null,
  PRIMARY KEY (`id`),
  KEY `fk_id_proveedor` (`id_proveedor`),
  CONSTRAINT `fk_id_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `t_proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;


DROP TABLE IF EXISTS t_detalle_factura_compras;
CREATE TABLE t_detalle_factura_compras(
  id_factura_compra int not null,
  id_producto int not null,
  descripcion_producto varchar(200) not null,
  cantidad int not null,
  precio_unitario int not null,
  KEY `fk_id_factura_compra` (`id_factura_compra`),
  KEY `fk_id_producto_factura_compra` (`id_producto`),
  CONSTRAINT `fk_id_factura_compra` FOREIGN KEY (`id_factura_compra`) REFERENCES `t_factura_compras` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_id_producto_factura_compra` FOREIGN KEY (`id_producto`) REFERENCES `t_productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB;