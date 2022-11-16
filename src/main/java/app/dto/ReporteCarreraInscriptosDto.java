package app.dto;

import io.swagger.annotations.ApiModelProperty;

public class ReporteCarreraInscriptosDto {
    @ApiModelProperty(notes = "Nombre de la carrera", name = "carrera",dataType = "String", value = "test carrera", example = "Tudai")
    private String carrera;
    @ApiModelProperty(notes = "Cantidad de alumnos", name = "cantidad",dataType = "String", value = "test cantidad", example = "253")
    private Long cantAlumnos;

    public ReporteCarreraInscriptosDto() {
    }

    public ReporteCarreraInscriptosDto(String carrera, Long cantAlumnos) {
        this.carrera = carrera;
        this.cantAlumnos = cantAlumnos;
    }

    public Long getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(Long cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return "ReporteCarrera [carrera=" + carrera + ", cantAlumnos=" + cantAlumnos + "]";
    }
}
