package app.services;

import app.dto.EstudianteDto;
import app.model.Estudiante;
import app.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<EstudianteDto> orderByEdad(){
        var result = estudianteRepository.orderByEdad();
        return result.stream().map( e -> new EstudianteDto(e.getNro_libreta(),e.getNombre(),e.getApellido(),e.getEdad(),e.getGenero(),e.getDni(),e.getCiudad_residencia())).collect(Collectors.toList());
    }


    public EstudianteDto getEstudianteByNumeroLibreta(int nro_libreta) {
        EstudianteDto e = estudianteRepository.getEstudianteByNumeroLibreta(nro_libreta);
        return new EstudianteDto(e.getNro_libreta(),e.getNombre(),e.getApellido(),e.getEdad(),e.getGenero(),e.getDni(),e.getCiudad_residencia());
    }

    public List<EstudianteDto> getEstudiantesByGenero(String gender) {
        var result = estudianteRepository.getEstudiantesByGenero(gender);
        return result.stream().map(e-> new EstudianteDto(e.getNro_libreta(),e.getNombre(),e.getApellido(),e.getEdad(),e.getGenero(),e.getDni(),e.getCiudad_residencia())).collect(Collectors.toList());

    }

    public List<EstudianteDto> getEstudiantesByCarreraOrderByCiudad(String career, String city) {
        var result= estudianteRepository.getEstudiantesByCarreraOrderByCiudad(career,city);
        return result.stream().map(e-> new EstudianteDto(e.getNro_libreta(),e.getNombre(),e.getApellido(),e.getEdad(),e.getGenero(),e.getDni(),e.getCiudad_residencia())).collect(Collectors.toList());
    }

    public EstudianteDto create(EstudianteDto e){
        Estudiante estudiante = estudianteRepository.save(new Estudiante(e.getNro_libreta(),e.getNombre(),e.getApellido(),e.getEdad(),e.getGenero(),e.getDni(),e.getCiudad_residencia()));
        return new EstudianteDto(estudiante.getNro_libreta(),estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),estudiante.getGenero(),estudiante.getDni(),estudiante.getCiudad_residencia());
    }
}
