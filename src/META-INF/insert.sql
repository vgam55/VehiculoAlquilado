INSERT INTO clientes (idCliente,nombre,apellidos,ciudad) VALUES (1000,'Víctor Manuel', 'Gamarra Rodríguez', 'Santurtzi');
INSERT INTO clientes (idCliente,nombre,apellidos,ciudad) VALUES (1001,'Sonia', 'Sierra Matilla', 'León');
INSERT INTO clientes (idCliente,nombre,apellidos,ciudad) VALUES (1002, 'Lucía', 'Bilbao Montejo', 'Castro');
INSERT INTO vehiculos(idVehiculo,marca,modelo) VALUES (20000,'Seat', 'Audi');
INSERT INTO vehiculos(idVehiculo,marca,modelo) VALUES (20001,'Renault', 'Clio');
INSERT INTO vehiculos(idVehiculo,marca,modelo) VALUES (20002, 'Citroen', 'C6');
INSERT INTO alquileres(idAlquiler,idVehiculo,idCliente,matricula,kilometros) VALUES (1,20000,1000,'BI0001LB',14000);
INSERT INTO alquileres(idAlquiler,idVehiculo,idCliente,matricula,kilometros) VALUES (2,20000,1001,'BI0001LB',14500);
INSERT INTO alquileres(idAlquiler,idVehiculo,idCliente,matricula,kilometros) VALUES (3,20001,1002,'LE01234ON', 1);