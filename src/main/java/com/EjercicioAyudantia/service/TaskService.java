package com.EjercicioAyudantia.service;

import com.EjercicioAyudantia.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Tarea> tasks = new CopyOnWriteArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Tarea createTask(String titulo, String prioridad, String fechaLimite) {
        long id = idGenerator.getAndIncrement();
        Tarea nuevaTarea = new Tarea(id, titulo, prioridad, fechaLimite, false);
        tasks.add(nuevaTarea);
        return nuevaTarea;
    }
}
