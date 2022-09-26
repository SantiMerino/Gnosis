use dbGnosis;
go

INSERT INTO tbModulos
VALUES ('Diseños de sistemas informáticos'),
('Programación de componentes de bases de datos'),
('Desarrollo de programación orientada objetos'),
('Diseño e instalación de redes LAN'),
('Diseño de planes de negocio en asociativa cooperativa'),
('Proyecto innovador de desarrollo de portales web'),
('Diseño de arquitectura de software'),
('Conversación en inglés sobre arquitectura de software y base de datos')

INSERT INTO tbMaterias
VALUES ('Lenguaje y literatura'),
('Matemática'),
('Ciencias Naturales'),
('Estudios Sociales y Cívica'),
('Idioma Extranjero: Inglés'),
('Formación Cristiana'),
('Orientación Para la Vida'),
('Moral, Urbanidad y Cívica')
--('Educacion Física')

INSERT INTO tbSeccionAca
VALUES 
('A'),
('B'),
('C'),
('D')

INSERT INTO tbEspecialidades
VALUES ('Desarrollo de Software'),
('Diseño grafico'),
('Administrativo Contable'),
('Arquitectura'),
('Electrónica'),
('Electromecánica'),
('Mantenimiento Automotriz')

select * from tbGrados
select * from tbEspecialidades

select * from tbGrupos
select * from tbSeccionAca

INSERT INTO tbGrados
VALUES ('Septimo Grado', 1, 8 , 1),
('Septimo Grado', 2, 8, 1),
('Octavo Grado', 1, 8 , 1),
('Octavo Grado', 2, 8, 1),
('Noveno Grado', 1, 8 , 1),
('Noveno Grado', 2, 8, 1),
('Primer Año de Bachillerato', 1, 1, 1), --Desarrollo de Software
('Primer Año de Bachillerato', 1, 1, 2),
('Primer Año de Bachillerato', 2, 1, 1),
('Primer Año de Bachillerato', 2, 1, 2),  --Aqui finaliza Software
('Primer Año de Bachillerato', 1, 2, 1), --Electrónica
('Primer Año de Bachillerato', 1, 2, 2),
('Primer Año de Bachillerato', 2, 2, 1),
('Primer Año de Bachillerato', 2, 2, 2), --Aqui finaliza Electrónica
('Primer Año de Bachillerato', 1, 3, 1), --Electromecánica
('Primer Año de Bachillerato', 1, 3, 2),
('Primer Año de Bachillerato', 2, 3, 1),
('Primer Año de Bachillerato', 2, 3, 2), --Aqui finazila Electromecánica
('Primer Año de Bachillerato', 1, 4, 1), --Administrativo Contable
('Primer Año de Bachillerato', 1, 4, 2),
('Primer Año de Bachillerato', 2, 4, 1),
('Primer Año de Bachillerato', 2, 4, 2), --Aqui finaliza Conta
('Primer Año de Bachillerato', 1, 5, 1), --Mantenimiento Automotriz
('Primer Año de Bachillerato', 1, 5, 2),
('Primer Año de Bachillerato', 2, 5, 1),
('Primer Año de Bachillerato', 2, 5, 2), --Aqui finazila Mantenimiento Automotriz
('Primer Año de Bachillerato', 1, 6, 1), --Arquitectura
('Primer Año de Bachillerato', 1, 6, 2),
('Primer Año de Bachillerato', 2, 6, 1),
('Primer Año de Bachillerato', 2, 6, 2), --Aqui finazila Arquitectura
('Primer Año de Bachillerato', 1, 7, 1), --Diseño Grafico
('Primer Año de Bachillerato', 1, 7, 2),
('Primer Año de Bachillerato', 2, 7, 1),
('Primer Año de Bachillerato', 2, 7, 2), --Aqui finazila Diseño Grafico
('Segundo Año de Bachillerato', 1, 1, 1), --Segundo Desarrollo de Software
('Segundo Año de Bachillerato', 1, 1, 2),
('Segundo Año de Bachillerato', 2, 1, 1),
('Segundo Año de Bachillerato', 2, 1, 2),  --Aqui finaliza Software
('Segundo Año de Bachillerato', 1, 2, 1), --Segundo Electrónica
('Segundo Año de Bachillerato', 1, 2, 2),
('Segundo Año de Bachillerato', 2, 2, 1),
('Segundo Año de Bachillerato', 2, 2, 2), --Aqui finaliza Electrónica
('Segundo Año de Bachillerato', 1, 3, 1), --Segundo Electromecánica
('Segundo Año de Bachillerato', 1, 3, 2),
('Segundo Año de Bachillerato', 2, 3, 1),
('Segundo Año de Bachillerato', 2, 3, 2), --Aqui finazila Electromecánica
('Segundo Año de Bachillerato', 1, 4, 1), --Segundo Administrativo Contable
('Segundo Año de Bachillerato', 1, 4, 2),
('Segundo Año de Bachillerato', 2, 4, 1),
('Segundo Año de Bachillerato', 2, 4, 2), --Aqui finaliza Conta
('Segundo Año de Bachillerato', 1, 5, 1), --Segundo Mantenimiento Automotriz
('Segundo Año de Bachillerato', 1, 5, 2),
('Segundo Año de Bachillerato', 2, 5, 1),
('Segundo Año de Bachillerato', 2, 5, 2), --Aqui finazila Mantenimiento Automotriz
('Segundo Año de Bachillerato', 1, 6, 1), --Segundo Arquitectura
('Segundo Año de Bachillerato', 1, 6, 2),
('Segundo Año de Bachillerato', 2, 6, 1),
('Segundo Año de Bachillerato', 2, 6, 2), --Aqui finazila Arquitectura
('Segundo Año de Bachillerato', 1, 7, 1), --Segundo Diseño Grafico
('Segundo Año de Bachillerato', 1, 7, 2),
('Segundo Año de Bachillerato', 2, 7, 1),
('Segundo Año de Bachillerato', 2, 7, 2), --Aqui finazila Diseño Grafico
('Tercer Año de Bachillerato', 1, 1, 1), --Tercer Desarrollo de Software
('Tercer Año de Bachillerato', 1, 1, 2),
('Tercer Año de Bachillerato', 2, 1, 1),
('Tercer Año de Bachillerato', 2, 1, 2),  --Aqui finaliza Software
('Tercer Año de Bachillerato', 1, 2, 1), --Tercer Electrónica
('Tercer Año de Bachillerato', 1, 2, 2),
('Tercer Año de Bachillerato', 2, 2, 1),
('Tercer Año de Bachillerato', 2, 2, 2), --Aqui finaliza Electrónica
('Tercer Año de Bachillerato', 1, 3, 1), --Tercer Electromecánica
('Tercer Año de Bachillerato', 1, 3, 2),
('Tercer Año de Bachillerato', 2, 3, 1),
('Tercer Año de Bachillerato', 2, 3, 2), --Aqui finazila Electromecánica
('Tercer Año de Bachillerato', 1, 4, 1), --Tercer Administrativo Contable
('Tercer Año de Bachillerato', 1, 4, 2),
('Tercer Año de Bachillerato', 2, 4, 1),
('Tercer Año de Bachillerato', 2, 4, 2), --Aqui finaliza Conta
('Tercer Año de Bachillerato', 1, 5, 1), --Tercer Mantenimiento Automotriz
('Tercer Año de Bachillerato', 1, 5, 2),
('Tercer Año de Bachillerato', 2, 5, 1),
('Tercer Año de Bachillerato', 2, 5, 2), --Aqui finazila Mantenimiento Automotriz
('Tercer Año de Bachillerato', 1, 6, 1), --Tercer Arquitectura
('Tercer Año de Bachillerato', 1, 6, 2),
('Tercer Año de Bachillerato', 2, 6, 1),
('Tercer Año de Bachillerato', 2, 6, 2), --Aqui finazila Arquitectura
('Tercer Año de Bachillerato', 1, 7, 1), --Tercer Diseño Grafico
('Tercer Año de Bachillerato', 1, 7, 2),
('Tercer Año de Bachillerato', 2, 7, 1),
('Tercer Año de Bachillerato', 2, 7, 2) --Aqui finazila Diseño Grafico

select * from tbDocentes
select * from tbGeneros

INSERT INTO tbDocentes
VALUES('Contreras García', 'Juan Eliseo', 'Colonia Escalón, San Salvador', '59378712-1', 'juancontreras@gmail.com', '1990-04-01', 1, 1, '7776-7981', null),
('Valle Flores', 'Oscar Martín', 'Blvd Venezuela Colonia Roma, San Salvador', '36294325-5', 'oscarmartin@gmail.com', '1991-12-03', 2, 1, '8826-2031', null),
('Beltran Lopéz', 'Carolina Madai', 'Carretera Troncal del Norte km5, San Salvador', '72274092-4', 'carolinabeltran@gmail.com', '1980-05-12', 3, 2, '7858-7895', null),
('Portillo Mendez', 'Ernesto Francisco', 'Colonia San Benito, San Salvador', '73752214-9', 'ernestoportillo@gmail.com', '1987-07-17', 4, 1, '7989-3276', null),
('Peréz Sosa', 'Lucia Abigail', 'Colonia San Antonio Abad, San Salvador', '82022414-4', 'luciaperez@gmail.com', '1993-05-30', 5, 2, '8559-9693', null),
('Tobar Lopéz', 'Michael Valeria', 'Colonia Escalon, San Salvador', '59185711-3', 'michaeltobar@gmail.com', '1990-11-24', 6, 2, '7047-3016', null),
('Alvárez Espinoza', 'Guadalupe Del Rosario', 'Colonia José Mariano Mendez, Santa Ana', '44471145-3', 'guadalupealvarez@gmail.com', '1995-08-06', 3, 2, '9522-9873', null),
('Nelson Vladimir', 'Pineda Peña', 'San Sebastian, Santa Ana', '34485118-4', 'pinedavladimir@gmail.com', '1994-01-03', 7, 1, '7741-1194', null),
('Paz Valencia', 'Roberto Javier', 'Blvd del Ejercito, Soyapango', '67355031-5', 'robertopaz@gmail.com', '1997-07-11', 39, 1, '6077-4794', null),
('Torres Frías', 'Daniel Andrés', 'Reparto San Fernando, Soyapango', '15421401-6', 'danieltorres@gmail.com', '1998-02-26', 83, 1, '8453-8136', null),
('Gómez Sáez', 'Andrés Felipe', 'Residencial Santa Teresa', '78373797-6', 'andresgomez@gmail.com', '1990-03-11', 63, 1, '7647-1914', null),
('Ramírez Tovar', 'José María', 'Avenida Manuel Gallardo', '53813448-8', 'joseramirez@gmail.com', '1985-05-27', 35, 1, '7723-0483', null),
('Diaz Beltrán', 'Fabian Andrés', 'Residencial Las Colinas', '75340525-7', 'fabiandiaz@gmail.com', '1983-07-13', 48, 1, '7342-8013', null),
('Herrera Moreno', 'Diego Alejandro', 'Colonia Cuscatlan, Cojutepeque', '24465732-9', 'diegoherrera@gmail.com', '1987-04-19', 7, 1, '7143-1983', null),
('García Beltrán', 'Gabriel Antonio', 'Bulevard Concepcion, Cojutepeque', '74721606-2', 'gabrielgarcia@gmail.com', '1999-07-29', 35, 1, '9859-9082', null),
('Castro Escobar', 'Laura Camila', 'Santa Lucia, Cojutepeque', '87592449-3', 'lauracastro@gmail.com', '1996-03-24', 63, 2, '9529-5073', null),
('Romero Jiménez', 'Julián José', 'Alemada Juan Pablo II, San Salvador', '70406972-7', 'julianromero@gmail.com', '1994-11-25', 75, 1, '5022-6223', null),
('Ramírez Jiménez', 'José Guillermo', 'Colonia Escalon, San Salvador', '65766043-3', 'joseramirez@gmail.com', '1992-07-23', 59, 1, '5402-3163', null),
('Escobar Fuentes', 'Stefani Margarita', 'Carretera Troncal del Norte, Apopa', '79370323-9', 'stefaniescobar@gmail.com', '1999-01-01', 79, 2, '7001-2691', null)

select * from tbMateriaDocentes
select * from tbModulos

INSERT INTO tbMateriaDocentes
VALUES(1,8,1),
(2,8,2),
(3,8,3),
(4,8,4),
(5,8,5),
(6,8,6),
(3,8,7),
(8,1,8),
(8,2,8),
(8,3,12),
(8,4,12),
(8,5,11),
(8,6,11),
(8,7,15),
(8,8,15),
(8,9,16),
(8,10,16)