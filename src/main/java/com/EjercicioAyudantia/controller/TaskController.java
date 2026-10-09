package com.EjercicioAyudantia.controller;

import com.EjercicioAyudantia.model.CreateTaskRequest;
import com.EjercicioAyudantia.model.Tarea;
import com.EjercicioAyudantia.repository.TareaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Tarea> completeTask(@PathVariable Long id) {
        // Buscamos la tarea dentro de la lista en memoria usando '=='
        Tarea tareaActual = repository.findAll().stream()
                .filter(t -> t.id() == id)
                .findFirst()
                .orElse(null);

        if (tareaActual == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Creamos la tarea actualizada cambiando 'completada' a true
        Tarea tareaActualizada = new Tarea(
                tareaActual.id(),
                tareaActual.titulo(),
                tareaActual.prioridad(),
                tareaActual.fechaLimite(),
                true
        );

        // Reemplazamos la tarea anterior por la actualizada en la lista
        for (int i = 0; i < repository.findAll().size(); i++) {
            if (repository.findAll().get(i).id() == id) {
                repository.findAll().set(i, tareaActualizada);
                break;
            }
        }

        return ResponseEntity.ok(tareaActualizada);
    }
}