package app.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto {
    int nro_libreta;
    @ApiModelProperty(notes = "Nombre de la persona", name = "name",dataType = "String", value = "test name", example = "Juana")
    String nombre;
    @ApiModelProperty(notes = "Apellido de la persona", name = "surname",dataType = "String", value = "test surname", example = "Perez")
    String apellido;
    @ApiModelProperty(notes = "Edad de la persona", name = "age",dataType = "int", value = "test age", example = "21")
    int edad;
    @ApiModelProperty(notes = "Género de la persona", name = "gender",dataType = "String", value = "test gender", example = "Femenino")
    String genero;
    @ApiModelProperty(notes = "Documento nacional de identidad de la persona", name = "dni",dataType = "int", value = "test dni", example = "12320852")
    int dni;
    @ApiModelProperty(notes = "Ciudad de residencia de la persona", name = "city",dataType = "String", value = "test city", example = "Tandil")
    String ciudad_residencia;

    @Override
    public String toString() {
        return "EstudianteDto{" +
                "nro_libreta=" + nro_libreta +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", dni=" + dni +
                ", ciudad_residencia='" + ciudad_residencia + '\'' +
                '}';
    }
}
