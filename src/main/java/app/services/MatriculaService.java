package app.services;

import app.model.Matricula;
import app.repository.EstudianteRepository;
import app.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula addMatricula(@RequestBody Matricula m) {
        return matriculaRepository.save(m);
    }
}
