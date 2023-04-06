-- CREATE TABLE
DROP TABLE IF EXISTS persons;
CREATE TABLE persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    birth DATE,
    mother VARCHAR,
    taj NUMERIC(9),
    tax NUMERIC(11),
    email VARCHAR,
    address VARCHAR,
    phone VARCHAR
);


