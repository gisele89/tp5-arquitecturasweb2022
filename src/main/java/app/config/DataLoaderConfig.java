package app.config;

import app.repository.CarreraRepository;
import app.repository.EstudianteRepository;
import app.repository.MatriculaRepository;
import app.services.DataLoaderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {
    @Bean
    public DataLoaderService dataLoader(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository, MatriculaRepository matriculaRepository){
        return new DataLoaderService(estudianteRepository, carreraRepository, matriculaRepository);
    }
}
