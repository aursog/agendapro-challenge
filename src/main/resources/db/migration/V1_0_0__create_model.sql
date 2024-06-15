CREATE TABLE users (
  uuid UUID PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  password VARCHAR(200) NOT NULL,
  created_at timestamp with time zone NOT NULL,
  updated_at timestamp with time zone,
  access_date timestamp with time zone,
  is_active boolean,
  roles VARCHAR(500)
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