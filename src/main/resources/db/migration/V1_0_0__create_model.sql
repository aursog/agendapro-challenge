CREATE TABLE users (
  uuid UUID PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  password VARCHAR(200) NOT NULL,
  created_at timestamp with time zone NOT NULL,
  updated_at timestamp with time zone,
  access_date timestamp with time zone,
  is_active boolean,
  role VARCHAR(50) NOT NULL
);

CREATE INDEX idx_email on users(email);
CREATE INDEX idx_name on users(name);

CREATE TABLE phones (
  uuid UUID PRIMARY KEY,
  phone_number VARCHAR(50) NOT NULL,
  citycode VARCHAR(10) NOT NULL,
  countrycode VARCHAR(10) NOT NULL,
  user_uuid UUID NOT NULL,
  created_at timestamp with time zone NOT NULL,
  updated_at timestamp with time zone
);

ALTER TABLE phones
  ADD CONSTRAINT fk_phone_user
  FOREIGN KEY (user_uuid)
  REFERENCES users(uuid);

CREATE TABLE unidad(
  uuid UUID PRIMARY KEY,
  descripcion VARCHAR(200) NOT NULL,
  created_at timestamp with time zone NOT NULL,
  updated_at timestamp with time zone
);

CREATE TABLE category(
  uuid UUID PRIMARY KEY,
  descripcion VARCHAR(200) NOT NULL,
  created_at timestamp with time zone NOT NULL,
  updated_at timestamp with time zone
);

CREATE TABLE product (
  uuid UUID PRIMARY KEY,
  sku VARCHAR(100) NOT NULL,
  descripcion VARCHAR(200) NOT NULL,
  category_uuid UUID NOT NULL,
  version VARCHAR(200) NOT NULL,
  unidad_uuid UUID NOT NULL,
  loteable boolean NOT NULL,
  imagen_url VARCHAR(200),
  comentario VARCHAR(200),
  created_at timestamp with time zone NOT NULL,
  updated_at timestamp with time zone
);

CREATE INDEX idx_sku on product(sku);
CREATE INDEX idx_name ON product(descripcion);

ALTER TABLE product
  ADD CONSTRAINT fk_product_unidad
  FOREIGN KEY (unidad_uuid)
  REFERENCES unidad(uuid);

ALTER TABLE product
  ADD CONSTRAINT fk_product_category
  FOREIGN KEY (category_uuid)
  REFERENCES category(uuid);