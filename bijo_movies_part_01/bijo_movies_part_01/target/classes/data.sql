DROP TABLE IF EXISTS movies;


CREATE TABLE movies (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    image VARCHAR(300),
    "year" INT
);

INSERT INTO movies (title, image, "year") VALUES ('System', './img/movies/system.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Piraci z Krzemowej Doliny', './img/movies/pirates.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Kontrola absolutna', './img/movies/control.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Kod nieśmiertelności', './img/movies/sourcecode.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Ex Machina', './img/movies/exmachina.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Hakerzy', './img/movies/hackers.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Tron', './img/movies/tronclassic.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Tron: Dziedzictwo', './img/movies/tron.jpg', 2023);
INSERT INTO movies (title, image, "year") VALUES ('Ja, robot', './img/movies/robot.jpg', 2023);
