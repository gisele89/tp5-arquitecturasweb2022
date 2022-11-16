package app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
public class Matricula implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "nro_libreta", referencedColumnName = "nro_libreta")
    Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id", referencedColumnName = "carrera_id")
    Carrera carrera;

    @Column (nullable = false)
    Date fecha_inscripcion;

    @Column(nullable = true)
    Date fecha_graduacion;

    @Column(nullable = false)
    boolean finalizo;

    public Matricula() {
    }

    public Matricula(Estudiante estudiante, Carrera carrera, Date fecha_inscripcion, Date fecha_graduacion, boolean finalizo) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_graduacion = fecha_graduacion;
        this.finalizo = finalizo;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "estudiante=" + estudiante +
                ", carrera=" + carrera +
                ", fecha_inscripcion=" + fecha_inscripcion +
                ", fecha_graduacion=" + fecha_graduacion +
                ", finalizo=" + finalizo +
                '}';
    }
}
