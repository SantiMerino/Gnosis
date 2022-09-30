use dbGnosis
go

select nombres_docente, grado from viewDatosPerfil where iddocente = 1; 

CREATE VIEW [dbo].[viewPerfiles]
AS SELECT a.idperfil,a.nombreperfil, a.descripcion, a.porcentajeValoracion, a.fechainicio, a.fechavencimiento, d.estadoperfil, b.tipoperfil, c.grado
FROM tbPerfiles a, tbTipoPerfiles b, tbGrados c, tbEstadoPerfiles d
WHERE a.idtipoperfil = b.idtipoperfil AND a.idgrados = c.idgrado AND a.idestadoperfil = d.idestadoperfil; 
GO

CREATE VIEW viewDatosPerfil
AS SELECT a.iddocente, a.nombres_docente, b.grado
FROM tbDocentes a, tbGrados b
WHERE a.idgrado = b.idgrado;
go

select * from viewDatosPerfil

select * from tbDocentes;

alter table tbPerfiles 
add constraint fk_perfilgrado
foreign key(idgrados)
references tbGrados(idgrado);

drop table tbPerfiles;
