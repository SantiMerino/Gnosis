USE [master]
GO
/****** Object:  Database [dbGnosisPrueba]    Script Date: 10/9/2022 21:52:59 ******/
CREATE DATABASE [dbGnosisPrueba]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbGnosisPrueba', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\dbGnosis.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'dbGnosisPrueba_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\dbGnosis_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [dbGnosisPrueba] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbGnosisPrueba].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbGnosisPrueba] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbGnosisPrueba] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbGnosisPrueba] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET  ENABLE_BROKER 
GO
ALTER DATABASE [dbGnosisPrueba] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbGnosisPrueba] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET RECOVERY FULL 
GO
ALTER DATABASE [dbGnosis] SET  MULTI_USER 
GO
ALTER DATABASE [dbGnosisPrueba] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbGnosisPrueba] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbGnosisPrueba] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbGnosisPrueba] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [dbGnosisPrueba] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [dbGnosisPrueba] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'dbGnosisPrueba', N'ON'
GO
ALTER DATABASE [dbGnosisPrueba] SET QUERY_STORE = OFF
GO
USE [dbGnosisPrueba]
GO
/****** Object:  Table [dbo].[tbAlumnos]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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
/****** Object:  Table [dbo].[tbGrados]    Script Date: 10/9/2022 21:53:00 ******/
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
	[idseccionTec] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idgrado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbEspecialidades]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbSeccionAca]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbGrupos]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbGeneros]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  View [dbo].[viewAlumnos]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewAlumnos]
AS SELECT a.apellidos_alumno, a.nombres_alumno, b.genero, c.grado, d.especialidad, f.seccionAca, h.grupo ,g.seccionTec, a.correo, a.direccion, a.contacto, a.dui, a.fecha_nac, a.codigocarnet
FROM tbAlumnos a, tbGeneros b, tbGrados c, tbEspecialidades d, tbSeccionAca f, tbSeccionTec g, tbGrupos h
WHERE a.idgenero = b.idgenero AND a.idgrado = c.idgrado AND c.idespecialidad = d.idespecialidad AND c.idgrupo = h.idgrupo AND c.idseccionAca = f.idseccionAca AND c.idseccionTec = g.idseccionTec
GO
/****** Object:  Table [dbo].[tbDocentes]    Script Date: 10/9/2022 21:53:00 ******/
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
	[idusuario] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[iddocente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbMateriaDocentes]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbMaterias]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbModulos]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbModulos](
	[idmodulo] [int] IDENTITY(1,1) NOT NULL,
	[modulo] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idmodulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbPerfiles]    Script Date: 10/9/2022 21:53:00 ******/
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
	[nota] [numeric](4, 2) NULL,
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
/****** Object:  Table [dbo].[tbEstadoPerfiles]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbTareas]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  View [dbo].[viewTareas]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewTareas]
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
/****** Object:  View [dbo].[viewPortafolios]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewPortafolios]
AS
SELECT CONCAT (b.nombres_docente, ' ', b.apellidos_docente) AS [Docente],CONCAT(e.grado,' ', f.seccionAca) AS [Grado] ,CONCAT(c.materia, ' ', d.modulo) AS [Materia]
FROM tbMateriaDocentes a, tbDocentes b, tbMaterias c, tbModulos d, tbGrados e, tbSeccionAca f
WHERE a.iddocente = b.iddocente AND a.idmateria = c.idmateria AND a.idmodulo = d.idmodulo  AND b.idgrado = e.idgrado AND e.idseccionAca = f.idseccionAca 
GO
/****** Object:  Table [dbo].[tbTipoPerfiles]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  View [dbo].[viewPerfiles]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[viewPerfiles]
AS SELECT a.idperfil,a.nombreperfil, a.descripcion, a.porcentajeValoracion, a.fechainicio, a.fechavencimiento, b.tipoperfil, c.grado
FROM tbPerfiles a, tbTipoPerfiles b, tbGrados c
WHERE a.idtipoperfil = b.idtipoperfil AND a.idgrados = c.idgrado; 
GO
/****** Object:  Table [dbo].[tbBiblioteca]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbClasificaciones]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbEnfoque]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbEstadisticasEnfoque]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbEstadoUsuarios]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbEventos]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbFases]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbNivelUsuarios]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbPortafolio]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbPortafolioCategoria]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbRegistroNotas]    Script Date: 10/9/2022 21:53:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbRegistroNotas](
	[idnota] [int] IDENTITY(1,1) NOT NULL,
	[idperfil] [int] NOT NULL,
	[idalumno] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idnota] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbTipoEventos]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbTipoRecursos]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbTipoTarea]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  Table [dbo].[tbUsuario]    Script Date: 10/9/2022 21:53:00 ******/
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
ALTER TABLE [dbo].[tbRegistroNotas]  WITH CHECK ADD  CONSTRAINT [fk_registronotasalumno] FOREIGN KEY([idalumno])
REFERENCES [dbo].[tbAlumnos] ([idalumno])
GO
ALTER TABLE [dbo].[tbRegistroNotas] CHECK CONSTRAINT [fk_registronotasalumno]
GO
ALTER TABLE [dbo].[tbRegistroNotas]  WITH CHECK ADD  CONSTRAINT [fk_registronotasperfil] FOREIGN KEY([idperfil])
REFERENCES [dbo].[tbPerfiles] ([idperfil])
GO
ALTER TABLE [dbo].[tbRegistroNotas] CHECK CONSTRAINT [fk_registronotasperfil]
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
/****** Object:  StoredProcedure [dbo].[crearUsuarioDocente]    Script Date: 10/9/2022 21:53:00 ******/
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
/****** Object:  StoredProcedure [dbo].[crearUsuarioEstudiante]    Script Date: 10/9/2022 21:53:00 ******/
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
ALTER DATABASE [dbGnosisPrueba] SET  READ_WRITE 
GO
