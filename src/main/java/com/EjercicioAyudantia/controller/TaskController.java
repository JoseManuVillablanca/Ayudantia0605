package com.EjercicioAyudantia.controller;

import com.EjercicioAyudantia.model.CreateTaskRequest;
import com.EjercicioAyudantia.model.Tarea;
import com.EjercicioAyudantia.repository.TareaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TareaRepository repository;
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TaskController(TareaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Tarea> createTask(@RequestBody CreateTaskRequest request) {
        long id = idGenerator.getAndIncrement();
        Tarea nuevaTarea = new Tarea(
                id,
                request.titulo(),
                request.prioridad(),
                request.fechaLimite(),
                false
        );
        repository.findAll().add(nuevaTarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }
}
