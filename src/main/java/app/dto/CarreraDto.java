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
public class CarreraDto {
    int carrera_id;
    @ApiModelProperty(notes = "Nombre de la carrera", name = "career",dataType = "String", value = "test career", example = "Tudai")
    String nombre;

    @Override
    public String toString() {
        return "CarreraDto{" +
                "carrera_id=" + carrera_id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
