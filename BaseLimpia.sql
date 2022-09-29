USE [master]
GO
/****** Object:  Database [dbGnosis]    Script Date: 28/09/2022 16:41:42 ******/
CREATE DATABASE [dbGnosis]
GO
USE [dbGnosis]
GO

CREATE TABLE [dbo].[tbAlumnos](
	[idalumno] [int] IDENTITY(1,1) NOT NULL,
	[apellidos_alumno] [varchar](50) NULL,
	[nombres_alumno] [varchar](50) NULL,
	[idgenero] [int] NOT NULL,
	[idgrado] [int] NOT NULL,
	[correo] [varchar](150) NULL,
	[direccion] [varchar](200) NULL,
	[contacto] [varchar](15) NULL,
	[dui] [varchar](15) NULL,
	[fecha_nac] [date] NULL,
	[codigocarnet] [varchar](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[idalumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbGrados]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbGrados](
	[idgrado] [int] IDENTITY(1,1) NOT NULL,
	[grado] [varchar](30) NULL,
	[idseccionAca] [int] NOT NULL,
	[idespecialidad] [int] NULL,
	[idgrupo] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idgrado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbEspecialidades]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEspecialidades](
	[idespecialidad] [int] IDENTITY(1,1) NOT NULL,
	[especialidad] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idespecialidad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbSeccionAca]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbSeccionAca](
	[idseccionAca] [int] IDENTITY(1,1) NOT NULL,
	[seccionAca] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[idseccionAca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbGrupos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbGrupos](
	[idgrupo] [int] IDENTITY(1,1) NOT NULL,
	[grupo] [varchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[idgrupo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbDocentes]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbDocentes](
	[iddocente] [int] IDENTITY(1,1) NOT NULL,
	[apellidos_docente] [varchar](50) NULL,
	[nombres_docente] [varchar](50) NULL,
	[direccion] [varchar](200) NULL,
	[dui] [varchar](15) NULL,
	[correo] [varchar](100) NULL,
	[fecha_nac] [date] NULL,
	[idgrado] [int] NULL,
	[idgenero] [int] NULL,
	[contacto] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[iddocente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbMateriaDocentes]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbMateriaDocentes](
	[idmateriadocente] [int] IDENTITY(1,1) NOT NULL,
	[idmateria] [int] NULL,
	[idmodulo] [int] NULL,
	[iddocente] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idmateriadocente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbMaterias]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbMaterias](
	[idmateria] [int] IDENTITY(1,1) NOT NULL,
	[materia] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idmateria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbModulos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbModulos](
	[idmodulo] [int] IDENTITY(1,1) NOT NULL,
	[modulo] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[idmodulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbPortafolio]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPortafolio](
	[idportafolio] [int] IDENTITY(1,1) NOT NULL,
	[contenido] [varchar](max) NULL,
	[idcategoriaPort] [int] NOT NULL,
	[idalumno] [int] NOT NULL,
	[idmateriadocente] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idportafolio] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbPortafolioCategoria]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPortafolioCategoria](
	[idcategoriaPort] [int] IDENTITY(1,1) NOT NULL,
	[categoriaPort] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[idcategoriaPort] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewPortafolios]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewPortafolios]
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
/****** Object:  Table [dbo].[tbEventos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEventos](
	[idevento] [int] IDENTITY(1,1) NOT NULL,
	[nombreevento] [varchar](50) NOT NULL,
	[fechaevento] [date] NULL,
	[horainicioevento] [varchar](20) NOT NULL,
	[fechafinalevento] [date] NULL,
	[horafinalizarevento] [varchar](20) NOT NULL,
	[idtipoevento] [int] NOT NULL,
	[idgrado] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idevento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbTipoEventos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTipoEventos](
	[idtipoevento] [int] IDENTITY(1,1) NOT NULL,
	[tipoevento] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idtipoevento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewEventos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewEventos]
AS
SELECT a.nombreevento, b.tipoevento, c.grado, a.fechaevento, a.fechafinalevento
FROM tbEventos a, tbTipoEventos b, tbGrados c
WHERE a.idtipoevento = b.idtipoevento
AND a.idgrado = c.idgrado 
GO
/****** Object:  Table [dbo].[tbBiblioteca]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbBiblioteca](
	[idbiblioteca] [int] IDENTITY(1,1) NOT NULL,
	[nombrerecurso] [varchar](50) NULL,
	[idtiporecurso] [int] NULL,
	[idclasificacion] [int] NULL,
	[link] [varchar](1000) NULL,
	[pdf] [varchar](max) NULL,
	[idalumno] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idbiblioteca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbTipoRecursos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTipoRecursos](
	[idtiporecurso] [int] IDENTITY(1,1) NOT NULL,
	[tiporecurso] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idtiporecurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbClasificaciones]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbClasificaciones](
	[idclasificacion] [int] IDENTITY(1,1) NOT NULL,
	[clasificacion] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idclasificacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewBiblioteca]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewBiblioteca]
AS
SELECT a.nombrerecurso,b.tiporecurso, c.clasificacion, a.link, a.pdf, a.idalumno
FROM tbBiblioteca a, tbTipoRecursos b, tbClasificaciones c
WHERE a.idtiporecurso = b.idtiporecurso
AND a.idclasificacion = c.idclasificacion
GO
/****** Object:  Table [dbo].[tbPerfiles]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPerfiles](
	[idperfil] [int] IDENTITY(1,1) NOT NULL,
	[nombreperfil] [varchar](100) NULL,
	[descripcion] [varchar](300) NULL,
	[porcentajeValoracion] [numeric](4, 2) NULL,
	[fechainicio] [date] NULL,
	[fechavencimiento] [date] NULL,
	[idestadoperfil] [int] NULL,
	[idtipoperfil] [int] NULL,
	[idfase] [int] NULL,
	[idmateriadocente] [int] NULL,
	[idgrados] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idperfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbEstadoPerfiles]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEstadoPerfiles](
	[idestadoperfil] [int] IDENTITY(1,1) NOT NULL,
	[estadoperfil] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[idestadoperfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbTipoPerfiles]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTipoPerfiles](
	[idtipoperfil] [int] IDENTITY(1,1) NOT NULL,
	[tipoperfil] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idtipoperfil] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewPerfiles]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewPerfiles]
AS SELECT a.idperfil,a.nombreperfil, a.descripcion, a.porcentajeValoracion, a.fechainicio, a.fechavencimiento, d.estadoperfil, b.tipoperfil, c.grado
FROM tbPerfiles a, tbTipoPerfiles b, tbGrados c, tbEstadoPerfiles d
WHERE a.idtipoperfil = b.idtipoperfil AND a.idgrados = c.idgrado AND a.idestadoperfil = d.idestadoperfil; 
GO
/****** Object:  Table [dbo].[tbTareas]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTareas](
	[idtarea] [int] IDENTITY(1,1) NOT NULL,
	[nombretarea] [varchar](100) NULL,
	[fechadeinicio] [date] NULL,
	[fechavencimiento] [date] NULL,
	[idperfil] [int] NULL,
	[rubrica] [varchar](max) NULL,
	[idtipotarea] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idtarea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewTareasDocentes]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewTareasDocentes]
AS
SELECT a.nombretarea as [Tarea], a.fechadeinicio as [Fecha I.], a.fechavencimiento as [Fecha V.], CONCAT(e.materia,' ',f.modulo) as [Materia/Modulo], CONCAT (d.nombres_docente,' ', d.apellidos_docente) AS [Docente], g.estadoperfil AS [Estado], a.rubrica AS [Rúbrica], b.porcentajeValoracion AS [%], h.tipoperfil AS [Tipo Perfil], a.idtarea, d.iddocente
FROM tbTareas a, tbPerfiles b, tbMateriaDocentes c, tbDocentes d, tbMaterias e, tbModulos f, tbEstadoPerfiles g, tbTipoPerfiles h
WHERE a.idperfil = b.idperfil 
	AND b.idmateriadocente = c.idmateriadocente
	AND c.iddocente = d.iddocente
	AND c.idmateria = e.idmateria
	AND c.idmodulo = f.idmodulo
	AND b.idestadoperfil = g.idestadoperfil
	AND b.idtipoperfil = h.idtipoperfil
GO
/****** Object:  View [dbo].[viewTareas]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewTareas]
AS 
SELECT a.nombretarea as [Tarea], a.fechadeinicio as [Fecha I.], a.fechavencimiento as [Fecha V.], CONCAT(e.materia,' ',f.modulo) as [Materia/Modulo], CONCAT (d.nombres_docente,' ', d.apellidos_docente) AS [Docente], g.estadoperfil AS [Estado], a.rubrica AS [Rúbrica], b.porcentajeValoracion AS [%], h.tipoperfil AS [Tipo Perfil], a.idtarea, i.grado AS [Grado]
FROM tbTareas a, tbPerfiles b, tbMateriaDocentes c, tbDocentes d, tbMaterias e, tbModulos f, tbEstadoPerfiles g, tbTipoPerfiles h, tbGrados i
WHERE a.idperfil = b.idperfil 
	AND b.idmateriadocente = c.idmateriadocente
	AND c.iddocente = d.iddocente
	AND c.idmateria = e.idmateria
	AND c.idmodulo = f.idmodulo
	AND b.idestadoperfil = g.idestadoperfil
	AND b.idtipoperfil = h.idtipoperfil
	AND b.idgrados = i.idgrado
GO
/****** Object:  Table [dbo].[tbGeneros]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbGeneros](
	[idgenero] [int] IDENTITY(1,1) NOT NULL,
	[genero] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idgenero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[viewAlumnos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewAlumnos]
AS SELECT a.idalumno, a.apellidos_alumno, a.nombres_alumno, b.genero, c.grado, d.especialidad, f.seccionAca, h.grupo , a.correo, a.direccion, a.contacto, a.dui, a.fecha_nac, a.codigocarnet
FROM tbAlumnos a, tbGeneros b, tbGrados c, tbEspecialidades d, tbSeccionAca f, tbGrupos h
WHERE a.idgenero = b.idgenero AND a.idgrado = c.idgrado AND c.idespecialidad = d.idespecialidad AND c.idgrupo = h.idgrupo AND c.idseccionAca = f.idseccionAca
GO
/****** Object:  Table [dbo].[tbEnfoque]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEnfoque](
	[idenfoque] [int] IDENTITY(1,1) NOT NULL,
	[enfoque] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idenfoque] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbEstadisticasEnfoque]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEstadisticasEnfoque](
	[idestadistica] [int] IDENTITY(1,1) NOT NULL,
	[timepoenfoque] [time](7) NULL,
	[idenfoque] [int] NULL,
	[idmateria] [int] NULL,
	[idalumno] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idestadistica] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbEstadoUsuarios]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbEstadoUsuarios](
	[idestadousuario] [int] IDENTITY(1,1) NOT NULL,
	[estadousuario] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idestadousuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbFases]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbFases](
	[idfase] [int] IDENTITY(1,1) NOT NULL,
	[fase] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idfase] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbNivelUsuarios]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbNivelUsuarios](
	[idnivelusuario] [int] IDENTITY(1,1) NOT NULL,
	[nivelusuario] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idnivelusuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbTareasAlumnos]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTareasAlumnos](
	[idtareaalumno] [int] IDENTITY(1,1) NOT NULL,
	[idtarea] [int] NOT NULL,
	[idalumno] [int] NOT NULL,
	[archivo] [varchar](max) NULL,
	[link] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[idtareaalumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbTipoTarea]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbTipoTarea](
	[idtipotarea] [int] IDENTITY(1,1) NOT NULL,
	[tipotarea] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[idtipotarea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbUsuario]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbUsuario](
	[idusuario] [int] IDENTITY(1,1) NOT NULL,
	[idnivelusuario] [int] NOT NULL,
	[username] [varchar](100) NULL,
	[clave] [varchar](100) NULL,
	[pin] [int] NULL,
	[idestadousuario] [int] NOT NULL,
	[idalumno] [int] NULL,
	[iddocente] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idusuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tbAlumnos]  WITH CHECK ADD  CONSTRAINT [fk_alumnogenero] FOREIGN KEY([idgenero])
REFERENCES [dbo].[tbGeneros] ([idgenero])
GO
ALTER TABLE [dbo].[tbAlumnos] CHECK CONSTRAINT [fk_alumnogenero]
GO
ALTER TABLE [dbo].[tbAlumnos]  WITH CHECK ADD  CONSTRAINT [fk_alumnogrado] FOREIGN KEY([idgrado])
REFERENCES [dbo].[tbGrados] ([idgrado])
GO
ALTER TABLE [dbo].[tbAlumnos] CHECK CONSTRAINT [fk_alumnogrado]
GO
ALTER TABLE [dbo].[tbBiblioteca]  WITH CHECK ADD  CONSTRAINT [fk_bibliotecaalumno] FOREIGN KEY([idalumno])
REFERENCES [dbo].[tbAlumnos] ([idalumno])
GO
ALTER TABLE [dbo].[tbBiblioteca] CHECK CONSTRAINT [fk_bibliotecaalumno]
GO
ALTER TABLE [dbo].[tbBiblioteca]  WITH CHECK ADD  CONSTRAINT [fk_bibliotecaclasificacion] FOREIGN KEY([idclasificacion])
REFERENCES [dbo].[tbClasificaciones] ([idclasificacion])
GO
ALTER TABLE [dbo].[tbBiblioteca] CHECK CONSTRAINT [fk_bibliotecaclasificacion]
GO
ALTER TABLE [dbo].[tbBiblioteca]  WITH CHECK ADD  CONSTRAINT [fk_bibliotecatiporecurso] FOREIGN KEY([idtiporecurso])
REFERENCES [dbo].[tbTipoRecursos] ([idtiporecurso])
GO
ALTER TABLE [dbo].[tbBiblioteca] CHECK CONSTRAINT [fk_bibliotecatiporecurso]
GO
ALTER TABLE [dbo].[tbDocentes]  WITH CHECK ADD  CONSTRAINT [fk_docentegenero] FOREIGN KEY([idgenero])
REFERENCES [dbo].[tbGeneros] ([idgenero])
GO
ALTER TABLE [dbo].[tbDocentes] CHECK CONSTRAINT [fk_docentegenero]
GO
ALTER TABLE [dbo].[tbDocentes]  WITH CHECK ADD  CONSTRAINT [fk_docentegrado] FOREIGN KEY([idgrado])
REFERENCES [dbo].[tbGrados] ([idgrado])
GO
ALTER TABLE [dbo].[tbDocentes] CHECK CONSTRAINT [fk_docentegrado]
GO
ALTER TABLE [dbo].[tbEstadisticasEnfoque]  WITH CHECK ADD  CONSTRAINT [fk_estadisticaalumno] FOREIGN KEY([idalumno])
REFERENCES [dbo].[tbAlumnos] ([idalumno])
GO
ALTER TABLE [dbo].[tbEstadisticasEnfoque] CHECK CONSTRAINT [fk_estadisticaalumno]
GO
ALTER TABLE [dbo].[tbEstadisticasEnfoque]  WITH CHECK ADD  CONSTRAINT [fk_estadisticaenfoquemateria] FOREIGN KEY([idmateria])
REFERENCES [dbo].[tbMaterias] ([idmateria])
GO
ALTER TABLE [dbo].[tbEstadisticasEnfoque] CHECK CONSTRAINT [fk_estadisticaenfoquemateria]
GO
ALTER TABLE [dbo].[tbEstadisticasEnfoque]  WITH CHECK ADD  CONSTRAINT [fk_estadisticasenfoque] FOREIGN KEY([idenfoque])
REFERENCES [dbo].[tbEnfoque] ([idenfoque])
GO
ALTER TABLE [dbo].[tbEstadisticasEnfoque] CHECK CONSTRAINT [fk_estadisticasenfoque]
GO
ALTER TABLE [dbo].[tbEventos]  WITH CHECK ADD  CONSTRAINT [fk_eventogrados] FOREIGN KEY([idgrado])
REFERENCES [dbo].[tbGrados] ([idgrado])
GO
ALTER TABLE [dbo].[tbEventos] CHECK CONSTRAINT [fk_eventogrados]
GO
ALTER TABLE [dbo].[tbEventos]  WITH CHECK ADD  CONSTRAINT [fk_eventotipoevento] FOREIGN KEY([idtipoevento])
REFERENCES [dbo].[tbTipoEventos] ([idtipoevento])
GO
ALTER TABLE [dbo].[tbEventos] CHECK CONSTRAINT [fk_eventotipoevento]
GO
ALTER TABLE [dbo].[tbGrados]  WITH CHECK ADD  CONSTRAINT [fk_gradosespecialidad] FOREIGN KEY([idespecialidad])
REFERENCES [dbo].[tbEspecialidades] ([idespecialidad])
GO
ALTER TABLE [dbo].[tbGrados] CHECK CONSTRAINT [fk_gradosespecialidad]
GO
ALTER TABLE [dbo].[tbGrados]  WITH CHECK ADD  CONSTRAINT [fk_gradosgrupos] FOREIGN KEY([idgrupo])
REFERENCES [dbo].[tbGrupos] ([idgrupo])
GO
ALTER TABLE [dbo].[tbGrados] CHECK CONSTRAINT [fk_gradosgrupos]
GO
ALTER TABLE [dbo].[tbGrados]  WITH CHECK ADD  CONSTRAINT [fk_gradosseccionaca] FOREIGN KEY([idseccionAca])
REFERENCES [dbo].[tbSeccionAca] ([idseccionAca])
GO
ALTER TABLE [dbo].[tbGrados] CHECK CONSTRAINT [fk_gradosseccionaca]
GO
ALTER TABLE [dbo].[tbMateriaDocentes]  WITH CHECK ADD  CONSTRAINT [fk_materiadocentedocente] FOREIGN KEY([iddocente])
REFERENCES [dbo].[tbDocentes] ([iddocente])
GO
ALTER TABLE [dbo].[tbMateriaDocentes] CHECK CONSTRAINT [fk_materiadocentedocente]
GO
ALTER TABLE [dbo].[tbMateriaDocentes]  WITH CHECK ADD  CONSTRAINT [fk_materiadocentemateria] FOREIGN KEY([idmateria])
REFERENCES [dbo].[tbMaterias] ([idmateria])
GO
ALTER TABLE [dbo].[tbMateriaDocentes] CHECK CONSTRAINT [fk_materiadocentemateria]
GO
ALTER TABLE [dbo].[tbMateriaDocentes]  WITH CHECK ADD  CONSTRAINT [fk_materiadocentemodulo] FOREIGN KEY([idmodulo])
REFERENCES [dbo].[tbModulos] ([idmodulo])
GO
ALTER TABLE [dbo].[tbMateriaDocentes] CHECK CONSTRAINT [fk_materiadocentemodulo]
GO
ALTER TABLE [dbo].[tbPerfiles]  WITH CHECK ADD  CONSTRAINT [fk_perfilestado] FOREIGN KEY([idestadoperfil])
REFERENCES [dbo].[tbEstadoPerfiles] ([idestadoperfil])
GO
ALTER TABLE [dbo].[tbPerfiles] CHECK CONSTRAINT [fk_perfilestado]
GO
ALTER TABLE [dbo].[tbPerfiles]  WITH CHECK ADD  CONSTRAINT [fk_perfilestipo] FOREIGN KEY([idtipoperfil])
REFERENCES [dbo].[tbTipoPerfiles] ([idtipoperfil])
GO
ALTER TABLE [dbo].[tbPerfiles] CHECK CONSTRAINT [fk_perfilestipo]
GO
ALTER TABLE [dbo].[tbPerfiles]  WITH CHECK ADD  CONSTRAINT [fk_perfilfase] FOREIGN KEY([idfase])
REFERENCES [dbo].[tbFases] ([idfase])
GO
ALTER TABLE [dbo].[tbPerfiles] CHECK CONSTRAINT [fk_perfilfase]
GO
ALTER TABLE [dbo].[tbPerfiles]  WITH CHECK ADD  CONSTRAINT [fk_perfilgrados] FOREIGN KEY([idgrados])
REFERENCES [dbo].[tbGrados] ([idgrado])
GO
ALTER TABLE [dbo].[tbPerfiles] CHECK CONSTRAINT [fk_perfilgrados]
GO
ALTER TABLE [dbo].[tbPerfiles]  WITH CHECK ADD  CONSTRAINT [fk_perfilmateriadocente] FOREIGN KEY([idmateriadocente])
REFERENCES [dbo].[tbMateriaDocentes] ([idmateriadocente])
GO
ALTER TABLE [dbo].[tbPerfiles] CHECK CONSTRAINT [fk_perfilmateriadocente]
GO
ALTER TABLE [dbo].[tbPortafolio]  WITH CHECK ADD  CONSTRAINT [fk_portafolioalumno] FOREIGN KEY([idalumno])
REFERENCES [dbo].[tbAlumnos] ([idalumno])
GO
ALTER TABLE [dbo].[tbPortafolio] CHECK CONSTRAINT [fk_portafolioalumno]
GO
ALTER TABLE [dbo].[tbPortafolio]  WITH CHECK ADD  CONSTRAINT [fk_portafoliocategoria] FOREIGN KEY([idcategoriaPort])
REFERENCES [dbo].[tbPortafolioCategoria] ([idcategoriaPort])
GO
ALTER TABLE [dbo].[tbPortafolio] CHECK CONSTRAINT [fk_portafoliocategoria]
GO
ALTER TABLE [dbo].[tbPortafolio]  WITH CHECK ADD  CONSTRAINT [fk_portafoliomateriadocente] FOREIGN KEY([idmateriadocente])
REFERENCES [dbo].[tbMateriaDocentes] ([idmateriadocente])
GO
ALTER TABLE [dbo].[tbPortafolio] CHECK CONSTRAINT [fk_portafoliomateriadocente]
GO
ALTER TABLE [dbo].[tbTareas]  WITH CHECK ADD  CONSTRAINT [fk_tareasperfiles] FOREIGN KEY([idperfil])
REFERENCES [dbo].[tbPerfiles] ([idperfil])
GO
ALTER TABLE [dbo].[tbTareas] CHECK CONSTRAINT [fk_tareasperfiles]
GO
ALTER TABLE [dbo].[tbTareas]  WITH CHECK ADD  CONSTRAINT [fk_tareastipo] FOREIGN KEY([idtipotarea])
REFERENCES [dbo].[tbTipoTarea] ([idtipotarea])
GO
ALTER TABLE [dbo].[tbTareas] CHECK CONSTRAINT [fk_tareastipo]
GO
ALTER TABLE [dbo].[tbTareasAlumnos]  WITH CHECK ADD  CONSTRAINT [fk_tareaalumnos_alumno] FOREIGN KEY([idalumno])
REFERENCES [dbo].[tbAlumnos] ([idalumno])
GO
ALTER TABLE [dbo].[tbTareasAlumnos] CHECK CONSTRAINT [fk_tareaalumnos_alumno]
GO
ALTER TABLE [dbo].[tbTareasAlumnos]  WITH CHECK ADD  CONSTRAINT [fk_tareaalumnos_tarea] FOREIGN KEY([idtarea])
REFERENCES [dbo].[tbTareas] ([idtarea])
GO
ALTER TABLE [dbo].[tbTareasAlumnos] CHECK CONSTRAINT [fk_tareaalumnos_tarea]
GO
ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [fk_usuarioalumno] FOREIGN KEY([idalumno])
REFERENCES [dbo].[tbAlumnos] ([idalumno])
GO
ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [fk_usuarioalumno]
GO
ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [fk_usuariodocente] FOREIGN KEY([iddocente])
REFERENCES [dbo].[tbDocentes] ([iddocente])
GO
ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [fk_usuariodocente]
GO
ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [fk_usuarioestado] FOREIGN KEY([idestadousuario])
REFERENCES [dbo].[tbEstadoUsuarios] ([idestadousuario])
GO
ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [fk_usuarioestado]
GO
ALTER TABLE [dbo].[tbUsuario]  WITH CHECK ADD  CONSTRAINT [fk_usuarionivelusuario] FOREIGN KEY([idnivelusuario])
REFERENCES [dbo].[tbNivelUsuarios] ([idnivelusuario])
GO
ALTER TABLE [dbo].[tbUsuario] CHECK CONSTRAINT [fk_usuarionivelusuario]
GO
/****** Object:  StoredProcedure [dbo].[crearUsuarioDocente]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[crearUsuarioDocente]
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
/****** Object:  StoredProcedure [dbo].[crearUsuarioEstudiante]    Script Date: 28/09/2022 16:41:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[crearUsuarioEstudiante]
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
USE [master]
GO
ALTER DATABASE [dbGnosis] SET  READ_WRITE 
GO

use dbGnosis

INSERT INTO tbGeneros VALUES ('Masculino'),('Femenino'); --

INSERT INTO tbEstadoUsuarios VALUES ('Activo') ,('Inactivo')

INSERT INTO tbEstadoPerfiles VALUES ('Completado'),('Calificado'), ('No entregado'), ('En proceso'), ('Urgente'), ('No disponible')

INSERT INTO tbTipoTarea VALUES ('Evaludada'), ('No Evaluada')

INSERT INTO tbTipoEventos VALUES  ('Tareas'), ('Clases'), ('Defensa'), ('Personal'), ('Eventos salesianos')

INSERT INTO tbFases VALUES  ('Fase de preparación'), ('Fase de ejecución'),('Fase de valoración')

INSERT INTO tbTipoRecursos VALUES  ('PDF'), ('Link')

INSERT INTO tbTipoPerfiles VALUES ('Cotidianas'), ('Proyecto Formativo'), ('Recuperacion')

INSERT INTO tbGrupos VALUES ('1'), ('2')

INSERT INTO tbNivelUsuarios VALUES ('Estudiante'), ('Docente'), ('Admin')

INSERT INTO tbPortafolioCategoria VALUES ('Clases'), ('Examenes'), ('Tareas')

INSERT INTO tbClasificaciones VALUES ('Libro'), ('Presentación'), ('Clase')

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
('Moral, Urbanidad y Cívica'),
('Ninguno')

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
('Mantenimiento Automotriz'),
('Ninguno')

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

select * from tbDocentes;

INSERT INTO tbDocentes
VALUES('Contreras García', 'Juan Eliseo', 'Colonia Escalón, San Salvador', '59378712-1', 'juancontreras@gmail.com', '1990-04-01', 1, 1, '7776-7981'),
('Valle Flores', 'Oscar Martín', 'Blvd Venezuela Colonia Roma, San Salvador', '36294325-5', 'oscarmartin@gmail.com', '1991-12-03', 2, 1, '8826-2031'),
('Beltran Lopéz', 'Carolina Madai', 'Carretera Troncal del Norte km5, San Salvador', '72274092-4', 'carolinabeltran@gmail.com', '1980-05-12', 3, 2, '7858-7895'),
('Portillo Mendez', 'Ernesto Francisco', 'Colonia San Benito, San Salvador', '73752214-9', 'ernestoportillo@gmail.com', '1987-07-17', 4, 1, '7989-3276'),
('Peréz Sosa', 'Lucia Abigail', 'Colonia San Antonio Abad, San Salvador', '82022414-4', 'luciaperez@gmail.com', '1993-05-30', 5, 2, '8559-9693'),
('Tobar Lopéz', 'Michael Valeria', 'Colonia Escalon, San Salvador', '59185711-3', 'michaeltobar@gmail.com', '1990-11-24', 6, 2, '7047-3016'),
('Alvárez Espinoza', 'Guadalupe Del Rosario', 'Colonia José Mariano Mendez, Santa Ana', '44471145-3', 'guadalupealvarez@gmail.com', '1995-08-06', 3, 2, '9522-9873'),
('Nelson Vladimir', 'Pineda Peña', 'San Sebastian, Santa Ana', '34485118-4', 'pinedavladimir@gmail.com', '1994-01-03', 7, 1, '7741-1194'),
('Paz Valencia', 'Roberto Javier', 'Blvd del Ejercito, Soyapango', '67355031-5', 'robertopaz@gmail.com', '1997-07-11', 39, 1, '6077-4794'),
('Torres Frías', 'Daniel Andrés', 'Reparto San Fernando, Soyapango', '15421401-6', 'danieltorres@gmail.com', '1998-02-26', 83, 1, '8453-8136'),
('Gómez Sáez', 'Andrés Felipe', 'Residencial Santa Teresa', '78373797-6', 'andresgomez@gmail.com', '1990-03-11', 63, 1, '7647-1914'),
('Ramírez Tovar', 'José María', 'Avenida Manuel Gallardo', '53813448-8', 'joseramirez@gmail.com', '1985-05-27', 35, 1, '7723-0483'),
('Diaz Beltrán', 'Fabian Andrés', 'Residencial Las Colinas', '75340525-7', 'fabiandiaz@gmail.com', '1983-07-13', 48, 1, '7342-8013'),
('Herrera Moreno', 'Diego Alejandro', 'Colonia Cuscatlan, Cojutepeque', '24465732-9', 'diegoherrera@gmail.com', '1987-04-19', 7, 1, '7143-1983'),
('García Beltrán', 'Gabriel Antonio', 'Bulevard Concepcion, Cojutepeque', '74721606-2', 'gabrielgarcia@gmail.com', '1999-07-29', 35, 1, '9859-9082'),
('Castro Escobar', 'Laura Camila', 'Santa Lucia, Cojutepeque', '87592449-3', 'lauracastro@gmail.com', '1996-03-24', 63, 2, '9529-5073'),
('Romero Jiménez', 'Julián José', 'Alemada Juan Pablo II, San Salvador', '70406972-7', 'julianromero@gmail.com', '1994-11-25', 75, 1, '5022-6223'),
('Ramírez Jiménez', 'José Guillermo', 'Colonia Escalon, San Salvador', '65766043-3', 'joseramirez@gmail.com', '1992-07-23', 59, 1, '5402-3163'),
('Escobar Fuentes', 'Stefani Margarita', 'Carretera Troncal del Norte, Apopa', '79370323-9', 'stefaniescobar@gmail.com', '1999-01-01', 79, 2, '7001-2691')

select * from tbModulos
select * from tbMateriaDocentes

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
(8,2,16),
(8,3,16)