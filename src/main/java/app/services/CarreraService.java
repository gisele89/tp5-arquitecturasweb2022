package app.services;

import app.dto.CarreraDto;

import app.dto.ReporteCarreraInscriptosDto;
import app.dto.ReporteDto;
import app.model.Carrera;
import app.repository.CarreraRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class CarreraService {
    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<ReporteCarreraInscriptosDto> getCarrerasOrdenadasPorCantidadInscriptos() {
        return carreraRepository.getCarrerasOrdenadasPorCantidadInscriptos();
    }

    public List<ReporteDto> getReporte() {
        return carreraRepository.getReporte();
    }

    public CarreraDto addCarrera(@RequestBody CarreraDto c) {
        Carrera carrera = carreraRepository.save(new Carrera(c.getCarrera_id(), c.getNombre()));
        return new CarreraDto(carrera.getCarrera_id(), carrera.getNombre());
    }
}
