DROP TABLE IF EXISTS product;
CREATE TABLE product (
                         id          INT PRIMARY KEY,
                         titre       VARCHAR(255) NOT NULL,
                         description VARCHAR(255) NOT NULL,
                         image       VARCHAR(255) NOT NULL,
                         prix        INT NOT NULL
);

INSERT INTO product (id, titre, description, image, prix)
VALUES
    (1, 'Produit 1', 'Description du produit 1', 'image1.jpg', 50),
    (2, 'Produit 2', 'Description du produit 2', 'image2.jpg', 30),
    (3, 'Produit 3', 'Description du produit 3', 'image3.jpg', 70),
    (4, 'Produit 4', 'Description du produit 4', 'image4.jpg', 90),
    (5, 'Produit 5', 'Description du produit 5', 'image5.jpg', 40),
    (6, 'Produit 6', 'Description du produit 6', 'image6.jpg', 60),
    (7, 'Produit 7', 'Description du produit 7', 'image7.jpg', 55),
    (8, 'Produit 8', 'Description du produit 8', 'image8.jpg', 85),
    (9, 'Produit 9', 'Description du produit 9', 'image9.jpg', 75),
    (10, 'Produit 10', 'Description du produit 10', 'image10.jpg', 65),
    (11, 'Produit 11', 'Description du produit 11', 'image11.jpg', 20),
    (12, 'Produit 12', 'Description du produit 12', 'image12.jpg', 100);


DROP TABLE IF EXISTS commande;
CREATE TABLE commande (
                          id          INT AUTO_INCREMENT PRIMARY KEY,
                          description VARCHAR(255),
                          quantite    DOUBLE,
                          date        VARCHAR(255),
                          montant     DOUBLE,
                          product_id  INT,
                          FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO commande (description, quantite, date, montant, product_id)
VALUES
    ('Product A', 10, '2023-12-01', 100.00, 1),
    ('Product B', 5, '2023-12-02', 50.00, 2),
    ('Product C', 3, '2023-12-03', 30.00, 3),
    ('Product D', 8, '2023-12-04', 80.00, 4),
    ('Product E', 2, '2023-12-05', 20.00, 5),
    ('Product F', 6, '2023-12-06', 60.00, 6),
    ('Product G', 4, '2023-12-07', 40.00, 7),
    ('Product H', 7, '2023-12-08', 70.00, 8),
    ('Product I', 9, '2023-12-09', 90.00, 9),
    ('Product J', 1, '2023-12-10', 10.00, 10),
    ('Product K', 6, '2023-12-11', 60.00, 11),
    ('Product L', 3, '2023-12-12', 30.00, 12);
