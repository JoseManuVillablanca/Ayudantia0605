package com.EjercicioAyudantia.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
GET /tasks
Retorna la lista de tareas. Soporta filtros opcionales por query params. Retorna 200 OK.

Query param	Tipo	Ejemplo	Comportamiento
prioridad	String	?prioridad=ALTA	Filtra por nivel de prioridad
titulo	String	?titulo=doc	Filtra tareas cuyo título contenga el valor (insensible a mayúsculas)
fechaLimite	String	?fechaLimite=2025-06-30	Filtra tareas con esa fecha límite exacta
Los filtros son acumulables: GET /tasks?prioridad=ALTA&titulo=doc retorna tareas de alta prioridad cuyo título contenga "doc".

Si no se pasan filtros, retorna todas las tareas.
*/

@RestController
public class TaskGetService {
    @GetMapping(path="tasks")
    public getTask(@RequestParam String prioridad, @RequestParam String titulo, @RequestParam )
}
