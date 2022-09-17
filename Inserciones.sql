CREATE DATABASE dbGnosis
GO

USE dbGnosis
GO

CREATE TABLE tbAlumnos (
	idalumno int not null primary key identity (1,1),
	apellidos_alumno varchar (50),
	nombres_alumno varchar (50),
	idgenero int not null,
	idgrado  int not null,
	correo varchar (150),
	direccion varchar (200),
	contacto varchar (15),
	dui varchar (15),
	fecha_nac date,
	idusuario int,
	codigocarnet varchar(8)
)

--
CREATE TABLE tbGrados (
	idgrado int not null primary key identity(1,1),
	grado varchar (30), -- 2ndo Año Bachillerato -- 9 grado
	idseccionAca int not null , -- A -- B
	idespecialidad int , -- D.Software -- null
 	idgrupo int not null,			--1 -- 1
	idseccionTec  int -- A -- null
)

CREATE TABLE tbEspecialidades (
	idespecialidad int not null primary key identity (1,1),
	especialidad varchar (30)
)

CREATE TABLE tbSeccionTec (
	idseccionTec int not null primary key identity (1,1),
	seccionTec varchar (1)
)

CREATE TABLE tbSeccionAca (
	idseccionAca int not null primary key identity (1,1),
	seccionAca varchar (1)
)

CREATE TABLE tbGrupos (
	idgrupo int not null primary key identity (1,1),
	grupo varchar (1)
)

CREATE TABLE tbGeneros (
	idgenero int not null primary key identity (1,1),
	genero varchar (30)
)

--Llaves foraneas de la tabla alumnos
ALTER TABLE tbAlumnos
ADD CONSTRAINT	fk_alumnogenero	
FOREIGN KEY (idgenero)
REFERENCES tbGeneros (idgenero)

ALTER TABLE tbAlumnos
ADD CONSTRAINT fk_alumnogrado
FOREIGN KEY (idgrado)
REFERENCES tbGrados (idgrado)

ALTER TABLE tbGrados
ADD CONSTRAINT fk_gradosseccionaca
FOREIGN KEY (idseccionAca)
REFERENCES tbSeccionAca (idseccionAca)

ALTER TABLE tbGrados
ADD CONSTRAINT fk_gradosseeciontec
FOREIGN KEY (idseccionTec) 
REFERENCES tbSeccionTec (idseccionTec)

ALTER TABLE tbGrados
ADD CONSTRAINT fk_gradosgrupos
FOREIGN KEY (idgrupo)
REFERENCES tbGrupos (idgrupo)

ALTER TABLE tbGrados
ADD CONSTRAINT fk_gradosespecialidad
FOREIGN KEY (idespecialidad)
REFERENCES tbEspecialidades (idespecialidad)

CREATE TABLE tbDocentes (
	iddocente int not null primary key identity (1,1),
	apellidos_docente varchar (50),
	nombres_docente varchar (50),
	direccion varchar (200),
	dui varchar (15),
	correo varchar (100),
	fecha_nac date, 
	idgrado int,
	idgenero int,
	contacto varchar (15),
	idusuario int
)

ALTER TABLE tbDocentes
ADD CONSTRAINT fk_docentegrado
FOREIGN KEY (idgrado)
REFERENCES tbGrados (idgrado)

ALTER TABLE tbDocentes
ADD CONSTRAINT fk_docentegenero
FOREIGN KEY (idgenero)
REFERENCES tbGeneros (idgenero)


CREATE TABLE tbMateriaDocentes (
	idmateriadocente int not null primary key identity (1,1),
	idmateria int,
	idmodulo int,
	iddocente int
)

CREATE TABLE tbMaterias (
	idmateria int not null primary key identity (1,1),
	materia varchar (50)
)

CREATE TABLE tbModulos (
	idmodulo int not null primary key identity (1,1),
	modulo varchar (50)
)

ALTER TABLE tbMateriaDocentes
ADD CONSTRAINT fk_materiadocentemateria
FOREIGN KEY (idmateria)
REFERENCES tbMaterias (idmateria)

ALTER TABLE tbMateriaDocentes
ADD CONSTRAINT fk_materiadocentemodulo
FOREIGN KEY (idmodulo)
REFERENCES tbModulos (idmodulo)

ALTER TABLE tbMateriaDocentes
ADD CONSTRAINT fk_materiadocentedocente
FOREIGN KEY (iddocente)
REFERENCES tbDocentes(iddocente)

CREATE TABLE tbPortafolio (
	idportafolio int not null primary key identity(1,1),
	contenido varchar(MAX),
	idcategoriaPort int not null,
	idalumno int not null,
	idmateriadocente int not null
)
 
CREATE TABLE tbPortafolioCategoria ( --Esta es la tabla para ver si es el portafolio de clases, tareas o evaluaciones
	idcategoriaPort  int not null primary key identity(1,1),
	categoriaPort varchar (15)
)

ALTER TABLE tbPortafolio 
ADD CONSTRAINT fk_portafoliocategoria
FOREIGN KEY (idcategoriaPort)
REFERENCES tbPortafolioCategoria(idcategoriaPort)

ALTER TABLE tbPortafolio
ADD CONSTRAINT fk_portafolioalumno
FOREIGN KEY (idalumno)
REFERENCES tbAlumnos (idalumno)

ALTER TABLE tbPortafolio
ADD CONSTRAINT fk_portafoliomateriadocente
FOREIGN KEY (idmateriadocente)
REFERENCES tbMateriaDocentes (idmateriadocente)

CREATE TABLE tbBiblioteca (
	idbiblioteca int not null primary key identity (1,1),
	nombrerecurso varchar (50),
	idtiporecurso int,
	idclasificacion int,
	link varchar (1000),
	pdf varchar(MAX)
)

CREATE TABLE tbTipoRecursos (
	idtiporecurso int not null primary key identity (1,1),
	tiporecurso varchar (50)
)

CREATE TABLE tbClasificaciones (
	idclasificacion int not null primary key identity (1,1),
	clasificacion varchar (50)
)

ALTER TABLE tbBiblioteca
ADD CONSTRAINT fk_bibliotecatiporecurso
FOREIGN KEY (idtiporecurso)
REFERENCES tbTipoRecursos (idtiporecurso)

ALTER TABLE tbBiblioteca
ADD CONSTRAINT fk_bibliotecaclasificacion
FOREIGN KEY (idclasificacion)
REFERENCES tbClasificaciones (idclasificacion)

CREATE TABLE tbUsuario (
	idusuario int not null primary key identity (1,1),
	idnivelusuario int not null,
	username varchar (100),
	clave varchar (100), --es la pinche contraseña :P
	pin int,
	idestadousuario int not null
)

CREATE TABLE tbNivelUsuarios (
	idnivelusuario int not null primary key identity(1,1),
	nivelusuario varchar (30)
)

CREATE TABLE tbEstadoUsuarios (
	idestadousuario int not null primary key identity(1,1),
	estadousuario varchar (50)
)

ALTER TABLE tbUsuario 
ADD CONSTRAINT fk_usuarionivelusuario
FOREIGN KEY (idnivelusuario)
REFERENCES tbNivelUsuarios (idnivelusuario)

ALTER TABLE tbUsuario
ADD CONSTRAINT fk_usuarioestado
FOREIGN KEY (idestadousuario)
REFERENCES tbEstadoUsuarios (idestadousuario)


CREATE TABLE tbEnfoque (
	idenfoque int not null primary key identity (1,1),
	enfoque varchar (50)
)

CREATE TABLE tbEstadisticasEnfoque(
	idestadistica int not null primary key identity (1,1),
	timepoenfoque time,
	idenfoque int, 
	idmateria int
) 

ALTER TABLE tbEstadisticasEnfoque
ADD CONSTRAINT fk_estadisticasenfoque
FOREIGN KEY (idenfoque)
REFERENCES tbEnfoque (idenfoque)

ALTER TABLE tbEstadisticasEnfoque
ADD CONSTRAINT fk_estadisticaenfoquemateria
FOREIGN KEY (idmateria)
REFERENCES tbMaterias (idmateria)

CREATE TABLE tbRegistroNotas (
	idnota int not null primary key identity (1,1),
	idperfil int not null,
	idalumno int not null
)

CREATE TABLE tbPerfiles (
	idperfil int not null primary key identity (1,1),
	nombreperfil varchar (100),
	descripcion varchar (300),
	porcentajeValoracion numeric (4,2),
	fechainicio date,
	fechavencimiento date,
	idestadoperfil int, 
	nota numeric (4,2),
	idtipoperfil int, --tipo perifl sería si es cotidiana, integradora, prueba objetiva
	idfase int, --si es proyecto formativo esto es la fase de preparación,etc
	idmateriadocente int,
	idgrados int
)

ALTER TABLE tbRegistroNotas
ADD CONSTRAINT fk_registronotasperfil
FOREIGN KEY (idperfil)
REFERENCES tbPerfiles (idperfil)

ALTER TABLE tbRegistroNotas
ADD CONSTRAINT fk_registronotasalumno
FOREIGN KEY (idalumno)
REFERENCES tbAlumnos (idalumno)

CREATE TABLE tbEstadoPerfiles (
	idestadoperfil int not null primary key identity (1,1),
	estadoperfil varchar (40)
)

CREATE TABLE tbTipoPerfiles (
	idtipoperfil int not null primary key identity (1,1),
	tipoperfil varchar (50)
)

ALTER TABLE tbPerfiles
ADD CONSTRAINT fk_perfilestado
FOREIGN KEY (idestadoperfil)
REFERENCES tbEstadoPerfiles (idestadoperfil)

ALTER TABLE tbPerfiles
ADD CONSTRAINT fk_perfilestipo
FOREIGN KEY (idtipoperfil)
REFERENCES tbTipoPerfiles (idtipoperfil)

CREATE TABLE tbTareas (
	idtarea int not null primary key identity (1,1),
	nombretarea varchar (100),
	fechadeinicio date,
	fechavencimiento date,
	idperfil int, --con esto se consigue el docente, materia, 
	rubrica varchar (MAX),
	idtipotarea int --evaluada o no evaluada
)

CREATE TABLE tbTipoTarea(
	idtipotarea int not null primary key identity (1,1),
	tipotarea varchar (30)
)

ALTER TABLE tbTareas
ADD CONSTRAINT fk_tareastipo
FOREIGN KEY (idtipotarea)
REFERENCES tbTipoTarea (idtipotarea)

ALTER TABLE tbAlumnos
ADD CONSTRAINT fk_alumnousuario 
FOREIGN KEY (idusuario)
REFERENCES tbUsuario (idusuario)

ALTER TABLE tbDocentes
ADD CONSTRAINT fk_docenteusuario
FOREIGN KEY (idusuario)
REFERENCES tbUsuario (idusuario)

ALTER TABLE tbBiblioteca 
ADD idalumno int

ALTER TABLE tbBiblioteca 
ADD CONSTRAINT fk_bibliotecaalumno
FOREIGN KEY (idalumno)
REFERENCES tbAlumnos (idalumno)


ALTER TABLE tbPerfiles
ADD CONSTRAINT fk_perfilmateriadocente
FOREIGN KEY (idmateriadocente)
REFERENCES tbMateriaDocentes (idmateriadocente)

CREATE TABLE tbFases(
	idfase int not null primary key identity (1,1),
	fase varchar (30)
)

ALTER TABLE tbPerfiles
ADD CONSTRAINT fk_perfilfase
FOREIGN KEY (idfase)
REFERENCES tbFases (idfase)

ALTER TABLE tbPerfiles
ADD CONSTRAINT fk_perfilgrados
FOREIGN KEY (idgrados)
REFERENCES tbGrados (idgrado)

ALTER TABLE tbEstadisticasEnfoque
ADD idalumno int

ALTER TABLE tbEstadisticasEnfoque
ADD CONSTRAINT fk_estadisticaalumno
FOREIGN KEY (idalumno)
REFERENCES tbAlumnos (idalumno)

ALTER TABLE tbUsuario
ADD idalumno int

ALTER TABLE tbUsuario
ADD CONSTRAINT fk_usuarioalumno
FOREIGN KEY (idalumno)
REFERENCES tbAlumnos (idalumno)

ALTER TABLE tbDocentes
DROP CONSTRAINT fk_docenteusuario

ALTER TABLE tbUsuario
ADD iddocente int

ALTER TABLE tbUsuario
ADD CONSTRAINT fk_usuariodocente
FOREIGN KEY (iddocente)
REFERENCES tbDocentes(iddocente)
ALTER TABLE tbAlumnos
DROP CONSTRAINT fk_alumnousuario

ALTER TABLE tbAlumnos
DROP COLUMN idusuario


use dbGnosis
go

GO
CREATE PROCEDURE crearUsuarioEstudiante
@nivel int,
@correo varchar (150),
@clavedefault varchar (20),
@b int, --12345
@c int, --2
@id int
AS
BEGIN
INSERT INTO tbUsuario(idnivelusuario,username, clave, pin, idestadousuario, idalumno)
VALUES  (@nivel, @correo, @clavedefault, @b , @c, @id);
END
GO

GO
CREATE PROCEDURE crearUsuarioDocente
@nivel int,
@correo varchar (150),
@clavedefault varchar (20),
@b int, --12345
@c int, --2
@id int
AS
BEGIN
INSERT INTO tbUsuario(idnivelusuario,username, clave, pin, idestadousuario, iddocente)
VALUES  (@nivel, @correo, @clavedefault, @b , @c, @id);
END
GO

CREATE VIEW viewPerfiles
AS SELECT a.idperfil,a.nombreperfil, a.descripcion, a.porcentajeValoracion, a.fechainicio, a.fechavencimiento, b.tipoperfil, c.grado
FROM tbPerfiles a, tbTipoPerfiles b, tbGrados c
WHERE a.idtipoperfil = b.idtipoperfil AND a.idgrados = c.idgrado; 
Go


ALTER TABLE tbTareas
ADD CONSTRAINT fk_tareasperfiles
FOREIGN KEY (idperfil)
REFERENCES tbPerfiles (idperfil)



CREATE TABLE tbEventos(
    idevento int not null primary key identity (1,1),
    nombreevento varchar(50) not null,
    fechaevento date null,
    horainicioevento varchar(20) not null,
    fechafinalevento date null,
    horafinalizarevento varchar(20) not null,
    idtipoevento int not null,
    idgrado int not null
);



CREATE TABLE tbTipoEventos(
    idtipoevento int not null primary key identity (1,1),
    tipoevento varchar(50) not null
);



--CREATE TABLE tbGrado(
--    idgrado int not null primary key identity (1,1),
--    grado varchar(50) not null
--);




ALTER TABLE tbEventos
ADD CONSTRAINT fk_eventotipoevento
FOREIGN KEY (idtipoevento)
REFERENCES tbTipoEventos (idtipoevento)



ALTER TABLE tbEventos
ADD CONSTRAINT fk_eventogrados
FOREIGN KEY (idgrado)
REFERENCES tbGrados (idgrado)

INSERT INTO tbGeneros VALUES ('Masculino'),('Femenino'); --

INSERT INTO tbSeccionAca VALUES ('A'), ('B')

INSERT INTO tbSeccionTec VALUES ('A'), ('B')

INSERT INTO tbEstadoUsuarios VALUES ('Activo') ,('Inactivo')

INSERT INTO tbEstadoPerfiles VALUES ('Completad'),('Calificado'), ('No entregado'), ('En proceso'), ('Urgente'), ('No disponible')

INSERT INTO tbTipoTarea VALUES ('Evaludada'), ('No Evaluada')

INSERT INTO tbTipoEventos VALUES  ('Tareas'), ('Clases'), ('Defensa'), ('Personal'), ('Eventos salesianos')

INSERT INTO tbFases VALUES  ('Fase de preparación'), ('Fase de ejecución'),('Fase de valoración')

INSERT INTO tbTipoRecursos VALUES  ('PDF'), ('Link')

INSERT INTO tbTipoPerfiles VALUES ('Cotidianas'), ('Proyecto Formativo'), ('Recuperacion')

INSERT INTO tbEspecialidades VALUES ('Desarrollo de software'), ('Electronica'), ('Electromecanica'), ('Contaduria'), ('Automotriz'), ('Arquitectura')

INSERT INTO tbGrupos VALUES ('1'), ('2')

INSERT INTO tbGrados VALUES ('Septimo',1,null, 1, 1), ('Octavo',1,null, 1, 1), ('Noveno',1,null, 1, 1), ('Primer Año',1,1, 1, 1), ('Segundo Año',1,1, 1, 1), ('Tercer Año',1,1, 1, 1)

INSERT INTO tbMaterias VALUES ('Matematicas'), ('Sociales'), ('Ciencias'), ('Lenguaje'), ('Formacion Cristiana'), ('Orientacion para la vida')

INSERT INTO tbNivelUsuarios VALUES ('Estudiante'), ('Docente'), ('Admin')

INSERT INTO tbPortafolioCategoria VALUES ('Clases'), ('Examenes'), ('Tareas')

INSERT INTO tbClasificaciones VALUES ('Libro'), ('Presentación'), ('Clase')

CREATE VIEW viewAlumnos
AS SELECT a.apellidos_alumno, a.nombres_alumno, b.genero, c.grado, d.especialidad, f.seccionAca, h.grupo ,g.seccionTec, a.correo, a.direccion, a.contacto, a.dui, a.fecha_nac, a.codigocarnet
FROM tbAlumnos a, tbGeneros b, tbGrados c, tbEspecialidades d, tbSeccionAca f, tbSeccionTec g, tbGrupos h
WHERE a.idgenero = b.idgenero AND a.idgrado = c.idgrado AND c.idespecialidad = d.idespecialidad AND c.idgrupo = h.idgrupo AND c.idseccionAca = f.idseccionAca AND c.idseccionTec = g.idseccionTec

--Inserciones en la tabla tbUsuario
INSERT INTO tbAlumnos VALUES ('Merino Herrera', 'José Santiago', 1, 1, 'jose@gmail.com', 'Colonia la zacamil', '34540987', '123213', '2004-08-15', '20190016'),
('Gonzales Castillo', 'Jose Ernesto', 1, 1, 'josecas@gmail.com', 'Apopa', '09124567', '213412', '2004-12-03', '20210590'),
('Castillo Monterrosa', 'Luis Alfredo', 1, 2, 'luisalfredo@gmail.com', 'San Marcos', '76099812', '213141', '2003-11-09', '20210680'),
('Melendez Altano', 'Alexandra Fernanda', 2, 3, 'Alexaa@gmail.com', 'Final Colonia escalon', '78674456', '12345', '2003-08-16', '20180067'),
('Trujillo Aleman', 'Andrea Melisa', 2, 4, 'Andreaalemaan@gmail.com', 'Soyapango colonia las margaritas', '6783-0943', '45242', '2003-05-10', '20201345') 

INSERT INTO tbDocentes VALUES ('Guinea Henriquez', 'Josue Alberto', 'Final calle el algodon', '09891231', 'josue_guinea@gmail.com', '1990-09-12', 3, 1, '7708-6545', 1),
('Sanchez Sanchez', 'Alexander Armando', 'Final calle motrocros', '98765430', 'alexander_sanchez@gmail.com', '1992-10-07', 2, 1, '8076-4564', 2),
('Hernandez Henriquez', 'Pablo José', 'Colonia los almendros, San Salvador', '5463780 ', 'hernandez_jose@gmail.com', '1989-07-15', 1, 1, '7612-0989', 3),
('Castillo Campos', 'Luis Armando', 'Final colonia miralvalle', '34758911', 'castillo_armando@gmail.com', '1995-09-12', 1, 1, '7705-1231', 3),
('Flores Molina', 'Pedro Orlando', 'Calle los granados', '12436401', 'flores_pedro@gmail.com', '1999-10-03', 1, 2, '7906-6898', 1)

INSERT INTO tbUsuario VALUES(3, 'root', 'c6f00988430dbc8e83a7bc7ab5256346', '123', 1, 1, 1),
(2, 'Luis Castillo', '81dc9bdb52d04dc20036dbd8313ed055', '123', 1, 2, 4),
(1, 'Jose Gonzalez', 'd93591bdf7860e1e4ee2fca799911215', '123', 1, 2, 2)

INSERT INTO tbModulos VALUES ('Programacion orientada a objetos'),
('Introduccion al diseño grafico'),
('Bases de arquitectura'),
('Diseño de circuitos'),
('Arte semirealista')

INSERT INTO tbMateriaDocentes VALUES (1, 1, 1),
(2, 3, 2),
(3, 2, 3),
(4, 4, 4),
(5, 5, 5)

INSERT INTO tbPortafolio VALUES ('Investigacion de los numeros pares e impares', 1, 2, 1),
('Clase informativa sobre la segunda guerra mundial' , 1, 2, 2),
('Tarea investigativa sobre los genes humanos', 2, 3, 3),
('Tarea de ingestigacion sobre el barroco', 3, 3, 4),
('Clase de la vida de Don Bosco', 1, 4, 5)

INSERT INTO tbPerfiles VALUES ('Prueba teorica', 'Prueba teorica de unidad 5 de matematicas', 30.00 , '2022-08-08', '2022-08-10', 1, 10.00 , 1, 1, 1, 1),
            ('Perfil 1', 'Crear una infografia', 35.00 , '2022-08-15', '2022-08-20', 2, 10.00 , 2, 2, 2, 2),
            ('Practica de laboratorio', 'Hacer un experimento con agua', 35.00 , '2022-08-21', '2022-08-24', 3, 10.00 , 3, 3, 3, 3),
            ('Prueba objetiva', 'Prueba sobre el surrealismo clasico', 30.00 , '2022-08-25', '2022-08-25', 1, 10.00 , 3, 3, 4, 4),
            ('Guia practica', 'Guia sobre la ingenieria en sistemas xD', 15.00 , '2022-08-30', '2022-08-31', 2, 10.00 , 3, 3, 5, 5)

INSERT INTO tbClasificaciones VALUES ('Libro'),
('Presentacion'),
('Clase')

--Inserciones en la tabla Biblioteca.
INSERT INTO tbBiblioteca VALUES('Revista de clases sociles', 1, 1, 'www.canva.com', 'No disponible', 1),
('Clase N3', 2, 3, 'www.canva.com', 'No disponible', 2),
('Presentacion de clase matematicas', 1, 3, 'No disponible', 'PtNumero1.pdf', 3),
('Unidades de poder', 1, 1, 'No disponible', 'UnidadesDePoder.pdf', 4),
('Collage flores', 2, 2, 'https://www.canva.com/design/DAFJcOoa_JM/N7lqEgjv7qf9D5tXDxj2Sg/edit', 'No disponible', 4)

--Inserciones en la tabla eventos
INSERT INTO tbEventos VALUES('Pausa pedagogica', '2021-05-26','00:00 am', '2021-05-31','23:59 pm', 4, 4),
('Defensa expo', '2022-08-14', '00:00 am', '2022-08-19', '16:00 am', 3, 5),
('Entrega tarea', '2022-08-01', '07:00 am', '2022-08-19', '19:00 am', 1,2),
('Ausencia por consulta', '2022-03-17', '00:00 am', '2022-03-17', '23:59 pm', 4, 1),
('Reunion expo', '2022-06-15', '17:00 pm', '2022-06-15', '21:00 pm', 4, 2)

--Inserciones en la tabla Tareas
INSERT INTO tbTareas VALUES('Campos magneticos', '2022-03-07', '2022-03-11', 2, 'No disponible',1),
('Actividades cotidianas', '2022-05-07', '2022-05-10', 5, 'No disponible', 1),
('Quizz', '2022-04-04', '2022-04-04', 4, 'No disponible', 2),
('Examen de periodo', '2022-08-16', '2022-08-16', 4, 'No disponible', 1),
('Album de fotografias', '2022-05-16', '2022-05-20', 1, 'No disponible', 1)

--Vamo gente
--Se pudo

CREATE VIEW viewTareas
AS 
SELECT a.nombretarea as [Tarea], a.fechadeinicio as [Fecha I.], a.fechavencimiento as [Fecha V.], CONCAT(e.materia,' ',f.modulo) as [Materia/Modulo], CONCAT (d.nombres_docente,' ', d.apellidos_docente) AS [Docente], g.estadoperfil AS [Estado]
FROM tbTareas a, tbPerfiles b, tbMateriaDocentes c, tbDocentes d, tbMaterias e, tbModulos f, tbEstadoPerfiles g
WHERE a.idperfil = b.idperfil 
	AND b.idmateriadocente = c.idmateriadocente
	AND c.iddocente = d.iddocente
	AND c.idmateria = e.idmateria
	AND c.idmodulo = f.idmodulo
	AND b.idestadoperfil = g.idestadoperfil
GO

use dbGnosis

select * from viewTareas

--hacer vista de la tabla materia docente
-- hacer vista de los recursos
-- hacer vista de los docentes
-- hacer vista de alumnos

--Vista de portafolios
GO
CREATE VIEW viewPortafolios
AS
SELECT CONCAT (b.nombres_docente, ' ', b.apellidos_docente) AS [Docente],CONCAT(e.grado,' ', f.seccionAca) AS [Grado] ,CONCAT(c.materia, ' ', d.modulo) AS [Materia]
FROM tbMateriaDocentes a, tbDocentes b, tbMaterias c, tbModulos d, tbGrados e, tbSeccionAca f
WHERE a.iddocente = b.iddocente AND a.idmateria = c.idmateria AND a.idmodulo = d.idmodulo  AND b.idgrado = e.idgrado AND e.idseccionAca = f.idseccionAca 
GO

SELECT * FROM viewPortafolios;

--query para seleccionar los eventos.
GO
CREATE VIEW viewEventos
AS
SELECT a.nombreevento, b.tipoevento, c.grado, a.fechaevento, a.fechafinalevento
FROM tbEventos a, tbTipoEventos b, tbGrados c
WHERE a.idtipoevento = b.idtipoevento
AND a.idgrado = c.idgrado 
--AND a.fechaevento between '2022/05/01'AND '2022/05/31' AND a.fechafinalevento between '2022/05/01'AND '2022/05/31'
GO

SELECT * FROM viewEventos WHERE fechaevento between '2022/05/01'AND '2022/05/31' AND fechafinalevento between '2022/05/01'AND '2022/05/31'

--Vista de profesores - materia - grado
SELECT CONCAT(b.nombres_docente, ' ', b.apellidos_docente) AS [Docente], CONCAT(c.materia, ' ', d.modulo) AS [Materia], e.grado AS [Grado]
FROM tbMateriaDocentes a, tbDocentes b, tbMaterias c, tbModulos d, tbGrados e
WHERE a.iddocente = b.iddocente AND a.idmateria = c.idmateria AND a.idmodulo = d.idmodulo AND b.idgrado = e.idgrado

USE dbGnosis;

--Vista de portafolios 
GO
CREATE VIEW viewPortafolios
AS
SELECT a.contenido AS [Contenido], b.categoriaPort AS [Categoria], CONCAT(c.grado,' ' ,e.seccionAca,'-', k.grupo) AS [Grado], CONCAT(d.nombres_alumno, ' ', d.apellidos_alumno) AS [Alumno], CONCAT(h.nombres_docente, ' ', h.apellidos_docente) AS [Docente], CONCAT(i.materia, ' ', j.modulo) AS [Materia]
FROM tbPortafolio a, tbPortafolioCategoria b, tbGrados c, tbAlumnos d, tbSeccionAca e, tbEspecialidades f, tbMateriaDocentes g, tbDocentes h, tbMaterias i, tbModulos j, tbGrupos k
WHERE a.idalumno = d.idalumno
AND a.idcategoriaPort = b.idcategoriaPort
AND a.idmateriadocente = g.idmateriadocente
AND g.iddocente = h.iddocente
AND c.idespecialidad = f.idespecialidad
AND c.idgrado = h.idgrado
AND c.idseccionAca = e.idseccionAca
AND g.idmateria = i.idmateria
AND g.idmodulo = j.idmodulo
AND c.idgrupo = k.idgrupo
GO

SELECT a.contenido AS [Contenido], b.categoriaPort AS [Categoria], CONCAT(c.grado,' ' ,e.seccionAca,'-', k.grupo) AS [Grado], CONCAT(d.nombres_alumno, ' ', d.apellidos_alumno) AS [Alumno], CONCAT(h.nombres_docente, ' ', h.apellidos_docente) AS [Docente], CONCAT(i.materia, ' ', j.modulo) AS [Materia]
FROM tbPortafolio a, tbPortafolioCategoria b, tbGrados c, tbAlumnos d, tbSeccionAca e, tbEspecialidades f, tbMateriaDocentes g, tbDocentes h, tbMaterias i, tbModulos j, tbGrupos k
WHERE a.idalumno = d.idalumno
AND a.idcategoriaPort = b.idcategoriaPort
AND a.idmateriadocente = g.idmateriadocente
AND g.iddocente = h.iddocente
AND c.idespecialidad = f.idespecialidad
AND c.idgrado = h.idgrado
AND c.idseccionAca = e.idseccionAca
AND g.idmateria = i.idmateria
AND g.idmodulo = j.idmodulo
AND c.idgrupo = k.idgrupo
--para consultar y abrir el portafolio especifico tengo que pasar estos dos parametros de más en el select pero nose de donde sacar el idmateriadocente
AND a.idalumno = 2
AND a.idmateriadocente = 1;


select * from tbUsuario