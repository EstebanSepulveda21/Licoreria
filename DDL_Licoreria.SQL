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

CREATE TABLE pais_envios
(
    codigo NUMERIC(5,0) NOT null,
    nombre VARCHAR(150) NOT null,

    CONSTRAINT pk_pais_envios PRIMARY KEY(codigo)
);

CREATE TABLE ciudades_ubicacion
(
    codigo NUMERIC(10,0) NOT null,
    nombre VARCHAR(85) NOT null,

    CONSTRAINT pk_ciudades_ubicacion PRIMARY KEY(codigo),
    CONSTRAINT uk_ciudades_ubicacion_nombre UNIQUE(nombre)
);

CREATE TABLE bodegas
(
    --FK
    ciudades_ubicacion NUMERIC(10,0),

    codigo NUMERIC(5,0) NOT null,
    capacidad_metros_cubicos NUMERIC(10,0) NOT null,

    CONSTRAINT pk_bodegas PRIMARY KEY(codigo),
    --CONSTRAINS FK
    CONSTRAINT fk_bodegas_tipos_ciudades_ubicacion
        FOREIGN KEY(ciudades_ubicacion)
            REFERENCES ciudades_ubicacion(codigo)
);

CREATE TABLE productos
(
    --Fk
    tipos_productos_codigo NUMERIC(10,0) NOT null,
    marcas_codigo NUMERIC(10,0) NOT null,
    pais_envios_codigo NUMERIC(5,0) NOT null,
    bodegas_codigo NUMERIC(5,0) NOT null,
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

    CONSTRAINT fk_productos_paies_envios
        FOREIGN KEY(pais_envios_codigo)
            REFERENCES pais_envios(codigo),

    CONSTRAINT fk_productos_bodegas
        FOREIGN KEY(bodegas_codigo)
            REFERENCES bodegas(codigo),

    --CONTRAINS PK
    CONSTRAINT pk_productos PRIMARY KEY(codigo)

);