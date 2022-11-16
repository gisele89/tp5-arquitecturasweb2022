package app.controller;


import app.dto.CarreraDto;
import app.dto.ReporteDto;
import app.dto.ReporteCarreraInscriptosDto;
import app.model.Carrera;
import app.services.CarreraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RequestMapping("carreras")
@RestController
@Api(value ="CarreraController")
public class CarreraController {
    private final CarreraService service;

    public CarreraController(CarreraService service) {
        this.service = service;
    }
    @ApiOperation(value = "Obtener lista de inscriptos ordenada por cantidad", response= Iterable.class)
    @GetMapping("/inscriptos")
    public List<ReporteCarreraInscriptosDto> getCarrerasOrdenadasPorCantidadInscriptos() {
        return service.getCarrerasOrdenadasPorCantidadInscriptos();
    }

    @ApiOperation(value = "Obtener reporte de carreras", response= Iterable.class)
    @GetMapping("/reporte")
    public List<ReporteDto> getReporte() {
        return service.getReporte();
    }

    @ApiOperation(value = "Insertar una carrera", response= Iterable.class)
    @PostMapping("/")
    public CarreraDto addCarrera (@RequestBody CarreraDto c){
        return service.addCarrera(c);
    }
}
