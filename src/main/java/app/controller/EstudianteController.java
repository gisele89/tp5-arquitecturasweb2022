package app.controller;

import app.dto.EstudianteDto;

import app.services.EstudianteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiantes")
@Api(value ="EstudianteController")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @ApiOperation(value = "Obtener lista de estudiantes ordenados por edad", response= Iterable.class)
    @GetMapping("/order/edad")
    List<EstudianteDto> orderByEdad() {
        return service.orderByEdad();
    }

    @ApiOperation(value = "Obtener estudiante dado un número de libreta", response= Iterable.class)
    @GetMapping("/nrolibreta/{nro_libreta}")
    EstudianteDto getEstudianteByNumeroLibreta(@PathVariable int nro_libreta) {
        return service.getEstudianteByNumeroLibreta(nro_libreta);
    }

    @ApiOperation(value = "Obtener lista de estudiantes dado un género", response= Iterable.class)
    @GetMapping("/genero/{gender}")
    List<EstudianteDto> getEstudiantesByGenero(@PathVariable String gender) {
        return service.getEstudiantesByGenero(gender);
    }

    @ApiOperation(value = "Obtener lista de estudiantes por carrera ordenados por ciudad", response= Iterable.class)
    @GetMapping("/carrera/{career}/{city}")
    List<EstudianteDto> getEstudiantesByCarreraOrderByCiudad(@PathVariable String career, @PathVariable String city) {
        return service.getEstudiantesByCarreraOrderByCiudad(career, city);
    }

    @ApiOperation(value = "Insertar un estudiante", response= Iterable.class)
    @PostMapping("/")
    public EstudianteDto addEstudiante(@RequestBody EstudianteDto e) {
        return service.create(e);
    }
}
