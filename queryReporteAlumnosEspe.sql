SELECT
     tbAlumnos."apellidos_alumno" AS tbAlumnos_apellidos_alumno,
     tbAlumnos."nombres_alumno" AS tbAlumnos_nombres_alumno,
     tbAlumnos."correo" AS tbAlumnos_correo,
     tbAlumnos."direccion" AS tbAlumnos_direccion,
     tbAlumnos."contacto" AS tbAlumnos_contacto,
     tbAlumnos."dui" AS tbAlumnos_dui,
     tbAlumnos."fecha_nac" AS tbAlumnos_fecha_nac,
     tbAlumnos."codigocarnet" AS tbAlumnos_codigocarnet,
     tbGrados."grado" AS tbGrados_grado,
     tbEspecialidades."especialidad" AS tbEspecialidades_especialidad,
     tbSeccionTec."seccionTec" AS tbSeccionTec_seccionTec,
     tbSeccionAca."seccionAca" AS tbSeccionAca_seccionAca,
     tbGrupos."grupo" AS tbGrupos_grupo
FROM
     "dbo"."tbGrados" tbGrados INNER JOIN "dbo"."tbAlumnos" tbAlumnos ON tbGrados."idgrado" = tbAlumnos."idgrado"
     AND tbAlumnos."idgrado" = tbGrados."idgrado"
     INNER JOIN "dbo"."tbEspecialidades" tbEspecialidades ON tbGrados."idespecialidad" = tbEspecialidades."idespecialidad"
     INNER JOIN "dbo"."tbSeccionTec" tbSeccionTec ON tbGrados."idseccionTec" = tbSeccionTec."idseccionTec"
     INNER JOIN "dbo"."tbSeccionAca" tbSeccionAca ON tbGrados."idseccionAca" = tbSeccionAca."idseccionAca"
     INNER JOIN "dbo"."tbGrupos" tbGrupos ON tbGrados."idgrupo" = tbGrupos."idgrupo"
WHERE
     tbAlumnos."codigocarnet" = $P{pcodigocarnet}
 AND tbAlumnos."idgrado" = tbGrados."idgrado"
 AND tbGrados."idespecialidad" = tbEspecialidades."idespecialidad"
 AND tbGrados."idgrupo" = tbGrupos."idgrupo"
 AND tbGrados."idseccionTec" = tbSeccionTec."idseccionTec"
 AND tbGrados."idseccionAca" = tbSeccionAca."idseccionAca"