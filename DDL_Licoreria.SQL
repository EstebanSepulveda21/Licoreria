CREATE TABLE marcas
(
	codigo NUMERIC(10,0) NOT null,
	nombre VARCHAR(80) NOT null,
	
	CONSTRAINT pk_marcas PRIMARY KEY(codigo),
	CONSTRAINT uk_marcas_nombre UNIQUE(nombre)
);

CREATE TABLE tipos_productos
(
	codigo NUMERIC(10,0) NOT null,
	tipo VARCHAR(50) NOT null,
	
	CONSTRAINT pk_tipos_productos PRIMARY KEY(codigo),
	CONSTRAINT uk_tipos_productos_tipo UNIQUE(tipo)
);

CREATE TABLE cabecera_facturas
(
	numero_factura NUMERIC(10,0) NOT null,
	fecha TIMESTAMP NOT null,
	nombre_cliente VARCHAR(80) NOT null,
	
	CONSTRAINT pk_cabecera_facturas PRIMARY KEY(numero_factura)
);

CREATE TABLE productos
(
	--Fk
	tipos_productos_codigo NUMERIC(10,0) NOT null,
	marcas_codigo NUMERIC(10,0) NOT null,
	--PK
	codigo NUMERIC(10,0) NOT null,
	--Otros
	nombre 	VARCHAR(150) NOT null,
	
	
	--CONSTRAINS FK
	CONSTRAINT fk_productos_tipos_productos
	FOREIGN KEY(tipos_productos_codigo)
	REFERENCES tipos_productos(codigo),
	
	CONSTRAINT fk_productos_marcas
	FOREIGN KEY(marcas_codigo)
	REFERENCES marcas(codigo),
	
	--CONTRAINS PK
	CONSTRAINT pk_productos PRIMARY KEY(codigo)
	
	
);

CREATE TABLE detalles_facturas
(
	--Fk y PK
	cabecera_facturas_numero_factura NUMERIC(10,0) NOT null,
	productos_codigo NUMERIC(10,0) NOT null,
	
	--Otros
	cantidad_producto SMALLINT NOT null,
	valor_unitario_producto NUMERIC(10,2) NOT null,
	
	--CONSTRAINS FK
	CONSTRAINT fk_detalles_facturas_cabecera_facturas
	FOREIGN KEY(cabecera_facturas_numero_factura)
	REFERENCES cabecera_facturas(numero_factura),
	
	CONSTRAINT fk_detalles_facturas_productos
	FOREIGN KEY(productos_codigo)
	REFERENCES productos(codigo),
	
	--CONTRAINS PK
	CONSTRAINT pk_detalles_facturas PRIMARY KEY(cabecera_facturas_numero_factura, productos_codigo)
	
);