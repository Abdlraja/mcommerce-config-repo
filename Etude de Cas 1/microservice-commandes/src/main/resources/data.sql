DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);
INSERT INTO employees (first_name, last_name, mail, password) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');


DROP TABLE IF EXISTS commande;
CREATE TABLE COMMANDE (
        id INT AUTO_INCREMENT PRIMARY KEY,
        description VARCHAR(255),
        quantite DOUBLE,
        date VARCHAR(255),
        montant DOUBLE
);
INSERT INTO COMMANDE (description, quantite, date, montant)
VALUES
    ('Product A', 10, '2023-12-01', 100.00),
    ('Product B', 5, '2023-12-02', 50.00),
    ('Product C', 3, '2023-12-03', 30.00),
    ('Product D', 8, '2023-12-04', 80.00),
    ('Product E', 2, '2023-12-05', 20.00),
    ('Product F', 6, '2023-12-06', 60.00),
    ('Product G', 4, '2023-12-07', 40.00),
    ('Product H', 7, '2023-12-08', 70.00),
    ('Product I', 9, '2023-12-09', 90.00),
    ('Product J', 1, '2023-12-10', 10.00),
    ('Product K', 6, '2023-12-11', 60.00),
    ('Product L', 3, '2023-12-12', 30.00);


