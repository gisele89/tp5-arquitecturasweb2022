package app.dto;

import io.swagger.annotations.ApiModelProperty;

public class ReporteDto {
    @ApiModelProperty(notes = "Nombre de la carrera", name = "carrera",dataType = "String", value = "test carrera", example = "Tudai")
    private String carrera;

    @ApiModelProperty(notes = "Año", name = "año",dataType = "Integer", value = "test año", example = "2017")
    private Integer anio;

    @ApiModelProperty(notes = "Inscriptos en la carrera", name = "inscriptos",dataType = "Long", value = "test inscriptos", example = "20202")
    private Long inscriptos;
    @ApiModelProperty(notes = "Graduados de la carrera", name = "graduados",dataType = "Long", value = "test graduados", example = "20369")
    private Long graduados;

    public ReporteDto() {
    }

    public ReporteDto(String carrera, Integer anio, Long inscriptos, Long graduados) {
        super();
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public Long getGraduados() {
        return graduados;
    }

    public void setGraduados(Long graduados) {
        this.graduados = graduados;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                ", anio=" + anio +
                "carrera='" + carrera + '\'' +
                ", inscriptos='" + inscriptos + '\'' +
                ", graduados='" + graduados + '\'' +
                '}';
    }
}
