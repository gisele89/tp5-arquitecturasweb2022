package app.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import app.services.DataLoaderService;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DataLoaderService dataLoaderService) {
        return args -> {
            dataLoaderService.insertEstudiantesFromCSV("src/main/java/app/csv/estudiantes.csv");
            dataLoaderService.insertCarrerasFromCSV("src/main/java/app/csv/carreras.csv");
            dataLoaderService.insertMatriculasFromCSV("src/main/java/app/csv/matriculas.csv");
        };
    }
}
