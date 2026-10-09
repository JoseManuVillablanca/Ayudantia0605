package com.EjercicioAyudantia.controller;

import com.EjercicioAyudantia.model.CreateTaskRequest;
import com.EjercicioAyudantia.model.Tarea;
import com.EjercicioAyudantia.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Tarea> createTask(@RequestBody CreateTaskRequest request) {
        Tarea nuevaTarea = taskService.createTask(
                request.titulo(),
                request.prioridad(),
                request.fechaLimite()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }
}
