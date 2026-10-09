package com.EjercicioAyudantia.service;

import com.EjercicioAyudantia.model.Tarea;
import com.EjercicioAyudantia.repository.TareaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskGetService {
    private final TareaRepository repository;

    public TaskGetService(TareaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<Tarea> getTasks(@RequestParam(required = false) String prioridad,
                                @RequestParam(required = false) String titulo,
                                @RequestParam(required = false) String fechaLimite) {
        return repository.findAll().stream()
                .filter(t -> prioridad == null || prioridad.equalsIgnoreCase(t.prioridad()))
                .filter(t -> titulo == null || t.titulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(t -> fechaLimite == null || fechaLimite.equals(t.fechaLimite()))
                .toList();
    }
}
