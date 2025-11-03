CREATE DATABASE student_management
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE student_management.students (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NULL,
    dateOfBirth DATE NULL,
    PRIMARY KEY (id)
);