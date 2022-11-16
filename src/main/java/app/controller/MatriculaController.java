package app.controller;

import app.model.Matricula;
import app.services.MatriculaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matriculas")
@Api(value ="MatriculaController")
public class MatriculaController {
    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @ApiOperation(value = "Insertar una matrícula", response= Iterable.class)
    @PostMapping("/")
    public Matricula addMatricula(@RequestBody Matricula m) {
        return service.addMatricula(m);
    }
}
