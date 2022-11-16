package app.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Estudiante {
    @Id
    int nro_libreta;
    @Column(nullable = false)
    String nombre;
    @Column(nullable = false)
    String apellido;
    @Column(nullable = false)
    int edad;
    @Column(nullable = false)
    String genero;
    @Column(nullable = false)
    int dni;
    @Column(nullable = false)
    String ciudad_residencia;
    @OneToMany (mappedBy = "estudiante")
    List<Matricula> carreras;

    public Estudiante() {
    }

    public Estudiante(int nro_libreta, String nombre, String apellido, int edad, String genero, int dni, String ciudad_residencia, List<Matricula> carreras) {
        this.nro_libreta = nro_libreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad_residencia = ciudad_residencia;
    }

    public Estudiante(int nro_libreta, String nombre, String apellido, int edad, String genero, int dni, String ciudad_residencia) {
        this.nro_libreta = nro_libreta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad_residencia = ciudad_residencia;
    }

    public void addCarreras(Matricula m) {
        if(!carreras.contains(m)){
            carreras.add(m);
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" +
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
