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



EXECUTE crearUsuarioEstudiante 1, 'santiago.merino2004', 'gnosis123', 12345, 2, 1;

Go
CREATE VIEW viewPerfiles
AS SELECT a.idperfil,a.nombreperfil, a.descripcion, a.porcentajeValoracion, a.fechainicio, a.fechavencimiento, b.tipoperfil, c.grado
FROM tbPerfiles a, tbTipoPerfiles b, tbGrados c
WHERE a.idtipoperfil = b.idtipoperfil AND a.idgrados = c.idgrado; 
Go

SELECT * FROM viewPerfiles;

ALTER TABLE tbTareas
ADD CONSTRAINT fk_tareasperfiles
FOREIGN KEY (idperfil)
REFERENCES tbPerfiles (idperfil)


USE dbGnosis
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

INSERT INTO tbGeneros VALUES ('Masculino'),('Femenino'),('Genere'); --

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

INSERT INTO tbGrupos VALUES (1), (2)

INSERT INTO tbGrados VALUES ('Septimo',1,null, 1, 1), ('Octavo',1,null, 1, 1), ('Noveno',1,null, 1, 1), ('Primer Año',1,1, 1, 1), ('Segundo Año',1,1, 1, 1), ('Tercer Año',1,1, 1, 1)

INSERT INTO tbMaterias VALUES ('Matematicas'), ('Sociales'), ('Ciencias'), ('Lenguaje'), ('Formacion Cristiana'), ('Orientacion para la vida')

INSERT INTO tbNivelUsuarios VALUES ('Estudiante'), ('Docente'), ('Admin')

INSERT INTO tbPortafolioCategoria VALUES ('Clases'), ('Examenes'), ('Tareas')