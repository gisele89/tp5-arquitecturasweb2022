package app.services;

import app.model.Carrera;
import app.model.Estudiante;
import app.model.Matricula;
import org.hibernate.ObjectNotFoundException;
import app.repository.CarreraRepository;
import app.repository.EstudianteRepository;
import app.repository.MatriculaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;


public class DataLoaderService {


    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;
    private final MatriculaRepository matriculaRepository;

    public DataLoaderService(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository, MatriculaRepository matriculaRepository) {
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
        this.matriculaRepository = matriculaRepository;
    }

    /**
     * inserta en la base de datos Estudiantes
     * @param f recibe un objeto de tipo String con la ruta del archivo .app.csv
     */
    public void insertEstudiantesFromCSV(String f) {
        CSVParser parser = null;

        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Estudiante estudiante = new Estudiante(
                    Integer.parseInt(row.get("numero_libreta")), row.get("nombre"), row.get("apellido"),
                    Integer.parseInt(row.get("edad")), row.get("genero"), Integer.parseInt(row.get("dni")),
                    row.get("ciudad_residencia"));
            estudianteRepository.save(estudiante);
        }
    }

    /**
     * inserta en la base de datos Carreras
     * @param f recibe un objeto de tipo String con la ruta del archivo .app.csv
     */
    public void insertCarrerasFromCSV(String f) {
        CSVParser parser = null;

        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Carrera carrera = new Carrera(
                    Integer.parseInt(row.get("id_carrera")), row.get("nombre_carrera"));
            carreraRepository.save(carrera);
        }
    }

    /**
     * inserta en la base de datos Matriculas
     * @param f recibe un objeto de tipo String con la ruta del archivo .app.csv
     */
    public void insertMatriculasFromCSV(String f) {
        CSVParser parser = null;
        Date fechaG = null;
        try {
            FileReader csvFile = new FileReader(f);
            parser = CSVFormat.DEFAULT.builder().setHeader().build().parse(csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord row : parser) {
            Integer idEstudiante = Integer.parseInt(row.get("id_estudiante"));
            Integer idCarrera = Integer.parseInt(row.get("id_carrera"));
            Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new ObjectNotFoundException(idEstudiante, "Estudiante"));
            Carrera carrera = carreraRepository.findById(idCarrera).orElseThrow(() -> new ObjectNotFoundException(idCarrera, "Carrera"));
            if (row.get("fecha_graduacion").equals("")) {
                fechaG = null;
            } else {
                fechaG = Date.valueOf(row.get("fecha_graduacion"));
            }

            Matricula matricula = new Matricula(
                    estudiante,
                    carrera,
                    Date.valueOf(row.get("fecha_inscripcion")),
                    fechaG,
                    Boolean.valueOf(row.get("finalizo"))
            );

            matriculaRepository.save(matricula);
        }

    }
}
