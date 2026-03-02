package com.eb.atividadegerenciamento.controllers;

import com.eb.atividadegerenciamento.models.EstudanteModel;
import com.eb.atividadegerenciamento.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public List<EstudanteModel> getEstudantes() {
        return estudanteService.acharTodos();
    }

    @GetMapping("/{id}")
    public EstudanteModel getEstudantePorId(@PathVariable Long id) {
        return estudanteService.acharEstudantePorId(id);
    }

    @PostMapping
    public EstudanteModel  criarEstudante(@RequestBody EstudanteModel estudanteModel) {
        return estudanteService.criarEstudante(estudanteModel);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
    }
}
