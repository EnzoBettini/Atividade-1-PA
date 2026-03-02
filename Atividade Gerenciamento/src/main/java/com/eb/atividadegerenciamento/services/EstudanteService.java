package com.eb.atividadegerenciamento.services;

import com.eb.atividadegerenciamento.models.EstudanteModel;
import com.eb.atividadegerenciamento.respositories.EstudanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> acharTodos() {
        return estudanteRepository.findAll();
    }

    public EstudanteModel acharEstudantePorId(Long id) {
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado"));
    }

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel) {
        return estudanteRepository.save(estudanteModel);
    }

    @Transactional
    public String deletarEstudante(Long id) {
        if (estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(id);
            return "Estudante deletado com sucesso";
        } else {
            throw new RuntimeException("Estudante com o ID não encontrado");
        }
    }
}
