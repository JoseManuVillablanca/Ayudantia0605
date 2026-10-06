package com.EjercicioAyudantia.model;

/*
Cada tarea tiene los siguientes atributos:
Campo 	Tipo 	Requerido 	Descripción
id 	Long 	Sí 	Identificador único, auto-incremental
titulo 	String 	Sí 	Título descriptivo de la tarea
prioridad 	String 	Sí 	Uno de: ALTA, MEDIA, BAJA
fechaLimite 	String 	No 	Fecha en formato YYYY-MM-DD; puede ser null
completada 	boolean 	Sí 	false por defecto al crear

El estado de las tareas se mantendrá en memoria durante la ejecución de la aplicación. No se requiere base de datos.
*/

public record Tarea(long id, String titulo, String prioridad, String fechaLimite, boolean completada){}
