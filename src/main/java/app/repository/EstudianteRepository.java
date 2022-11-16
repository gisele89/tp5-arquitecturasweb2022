package app.repository;

import app.dto.EstudianteDto;
import app.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    @Query("SELECT new app.dto.EstudianteDto(e.nro_libreta,e.nombre, e.apellido, e.edad, e.genero,e.dni, e.ciudad_residencia) FROM Estudiante e ORDER BY e.edad DESC")
    List<EstudianteDto> orderByEdad();

    @Query("SELECT new app.dto.EstudianteDto(e.nro_libreta,e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad_residencia) FROM Estudiante e WHERE e.nro_libreta =:nro_libreta")
    EstudianteDto getEstudianteByNumeroLibreta(@Param("nro_libreta") int nro_libreta);

    @Query("SELECT new app.dto.EstudianteDto(e.nro_libreta,e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad_residencia) FROM Estudiante e WHERE e.genero =:genero")
    List<EstudianteDto> getEstudiantesByGenero(@Param("genero") String genero);

    @Query("SELECT new app.dto.EstudianteDto(e.nro_libreta,e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad_residencia) FROM Estudiante e JOIN e.carreras M JOIN M.carrera C WHERE e.ciudad_residencia =:ciudad_residencia AND  C.nombre =:carrera")
    List<EstudianteDto> getEstudiantesByCarreraOrderByCiudad(@Param("carrera") String carrera, @Param("ciudad_residencia") String ciudad_residencia);


}
