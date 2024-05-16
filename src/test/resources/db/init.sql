CREATE DATABASE IF NOT EXISTS Human_Resources;

USE Human_Resources;

CREATE TABLE
    IF NOT EXISTS Department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL,
    department_location VARCHAR(100) NOT NULL
);

CREATE TABLE
    IF NOT EXISTS Position(
    job_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    job_description VARCHAR(500) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

CREATE TABLE
    IF NOT EXISTS Benefit (
    benefit_id INT AUTO_INCREMENT PRIMARY KEY,
    benefit_description VARCHAR(500) NOT NULL
);

CREATE TABLE
    IF NOT EXISTS Employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    hire_date DATE NOT NULL,
    department_id INT NOT NULL,
    position_id INT NOT NULL,
    CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES Department (department_id),
    CONSTRAINT fk_position FOREIGN KEY (position_id) REFERENCES Position(job_id)
);

CREATE TABLE
    IF NOT EXISTS EmployeeBenefits (
    employee_benefit_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    benefit_id INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT fk_employee FOREIGN KEY (employee_id) REFERENCES Employee (employee_id),
    CONSTRAINT fk_benefit FOREIGN KEY (benefit_id) REFERENCES Benefit (benefit_id)
);

SELECT 'Success!' AS message;