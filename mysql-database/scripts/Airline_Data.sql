CREATE TABLE airline (
  id INT NOT NULL AUTO_INCREMENT,
  city VARCHAR (100),
  destiny_city VARCHAR (100),
  departure_time VARCHAR (100),
  arrival_time VARCHAR (100),
  PRIMARY KEY(id)
);



INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Delhi','Mumbai','10:40','12:15');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Delhi','Bangalore','11:00','19:30');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Mumbai','Delhi','09:15','18:25');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Mumbai','Bangalore','11:00','16:30');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Mumbai','Chennai','11:30','15:30');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Mumbai','Kolkata','11:15','16:55');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Chennai','Mumbai','01:40','05:30');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Bangalore','Chennai','10:00','19:00');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Bangalore','Mumbai','23:30','08:20');

INSERT INTO airline (city, destiny_city, departure_time, arrival_time)
VALUES ('Bangalore','Kolkata','07:15','18:30');