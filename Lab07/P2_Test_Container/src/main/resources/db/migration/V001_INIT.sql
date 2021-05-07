CREATE TABLE students
(
    nmec BIGSERIAL PRIMARY KEY,
    name varchar(255) not null
);

INSERT INTO students (name) VALUES ('Joao Vasconcelos');