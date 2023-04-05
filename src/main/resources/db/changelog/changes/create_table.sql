-- CREATE TABLE
DROP TABLE IF EXISTS persons;
CREATE TABLE persons (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    birth DATE,
    motherName VARCHAR,
    tajId NUMERIC(9),
    taxId NUMERIC(11),
    email VARCHAR,
    address VARCHAR,
    phone VARCHAR
);


