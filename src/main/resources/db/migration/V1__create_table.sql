CREATE TABLE product (
  guid VARCHAR(36) NOT NULL PRIMARY KEY,
  product_category VARCHAR(255),
  product_name VARCHAR(255),
  price DECIMAL(10, 2),
  description TEXT,
  brand VARCHAR(255),
  main_image_url TEXT
);
