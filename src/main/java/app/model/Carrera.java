package app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Carrera {
    @Id
    int carrera_id;
    @Column
    String nombre;
    @OneToMany(mappedBy = "carrera")
    List<Matricula> estudiantes;

    public Carrera() {
    }

    public Carrera(int carrera_id, String nombre) {
        this.carrera_id = carrera_id;
        this.nombre = nombre;
    }

    public Carrera(int carrera_id, String nombre, List<Matricula> estudiantes) {
        this.carrera_id = carrera_id;
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "Carrera{" +
                "carrera_id=" + carrera_id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
