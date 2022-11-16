package app.repository;

import app.dto.ReporteCarreraInscriptosDto;
import app.model.Carrera;
import app.dto.ReporteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
    @Query("SELECT new app.dto.ReporteCarreraInscriptosDto(c.nombre,COUNT(m.estudiante)) FROM Carrera c JOIN c.estudiantes m WHERE m.fecha_graduacion IS NULL GROUP BY c.carrera_id ORDER BY COUNT(m.estudiante) DESC")
    List<ReporteCarreraInscriptosDto> getCarrerasOrdenadasPorCantidadInscriptos();

    @Query("SELECT new app.dto.ReporteDto(c.nombre, YEAR(m.fecha_inscripcion), COUNT(YEAR(m.fecha_inscripcion)), COUNT(YEAR(m.fecha_graduacion)))FROM Matricula m JOIN m.carrera c GROUP BY c.carrera_id, YEAR(m.fecha_inscripcion) ORDER BY YEAR(m.fecha_inscripcion), c.nombre")
    List<ReporteDto> getReporte();
}
