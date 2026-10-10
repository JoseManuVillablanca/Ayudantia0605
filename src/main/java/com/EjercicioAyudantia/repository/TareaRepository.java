package com.EjercicioAyudantia.repository;

import com.EjercicioAyudantia.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas = new ArrayList<>();

    public List<Tarea> findAll() {
        return tareas;
    }
}
