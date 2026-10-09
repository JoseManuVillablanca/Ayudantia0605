package com.EjercicioAyudantia.model;

public record CreateTaskRequest(
    String titulo,
    String prioridad,
    String fechaLimite
) {}
