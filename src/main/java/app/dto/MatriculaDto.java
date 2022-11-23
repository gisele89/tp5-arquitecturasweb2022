package app.dto;

import app.model.Carrera;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDto {
    @ApiModelProperty(notes = "Nombre de la carrera", name = "career",dataType = "String", value = "test career", example = "Tudai")
    Carrera carrera;
    @ApiModelProperty(notes = "Fecha de inscripción a la carrera", name = "dateI",dataType = "date", value = "test dateI", example = "20/03/2018")
    Date fecha_inscripcion;
    @ApiModelProperty(notes = "Fecha de graduacion de la carrera", name = "dateG",dataType = "date", value = "test dateG", example = "20/12/2022")
    Date fecha_graduacion;
    @ApiModelProperty(notes = "Finalizó la carrera", name = "finalizo",dataType = "boolean", value = "test dateI", example = "true")
    boolean finalizo;

    @Override
    public String toString() {
        return "MatriculaDto{" +
                "carrera=" + carrera +
                ", fecha_inscripcion=" + fecha_inscripcion +
                ", fecha_graduacion=" + fecha_graduacion +
                ", finalizo=" + finalizo +
                '}';
    }
}
