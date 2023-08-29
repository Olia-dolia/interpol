package com.example.interpol;

import com.example.interpol.entities.Language;
import com.example.interpol.repositories.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterpolApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterpolApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(LanguageRepository repository) {
        return (args) -> {
            fillLanguages(repository);

            //repository.findAll().forEach(System.out::println);

          /*  repository.findByFirstNameStartsWith("Ja").forEach(System.out::println);*/
        };
    }

    private void fillLanguages(LanguageRepository languageRepository){
        languageRepository.save(new Language("UK"));
        languageRepository.save(new Language("EN"));
        languageRepository.save(new Language("FR"));
        languageRepository.save(new Language("CS"));
        languageRepository.save(new Language("DE"));
        languageRepository.save(new Language("ES"));
        languageRepository.save(new Language("EL"));
        languageRepository.save(new Language("IT"));
        languageRepository.save(new Language("KO"));
        languageRepository.save(new Language("BG"));
    }

    private void fillProfessions(){

    }

    private void fillStatus(){

    }

    private void fillCriminalType(){

    }

    private void fillCriminalTypeProfessions(){

    }
}
