package com.example.interpol;

import com.example.interpol.entities.*;
import com.example.interpol.repositories.*;
import org.hibernate.mapping.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

@SpringBootApplication
public class InterpolApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterpolApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(LanguageRepository lr, ProfessionRepository pr, CriminalRepository cr,
                                 CriminalGroupRepository crg, StatusRepository sr, CriminalTypeRepository crt) {
        return (args) -> {
           /* fillLanguages(lr);
            fillProfessions(pr);
            fillStatus(sr);
            fillCriminals(cr);
            fillCriminalTypes(crt);
            fillCriminalGroups(crg);*/

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

    private void fillProfessions(ProfessionRepository professionRepository){
        professionRepository.save(new Profession("Leader"));
        professionRepository.save(new Profession("Right hand"));
        professionRepository.save(new Profession("Assistant"));
        professionRepository.save(new Profession("Accountant"));
        professionRepository.save(new Profession("Driver"));
        professionRepository.save(new Profession("Drug dealer"));
        professionRepository.save(new Profession("Arms dealer"));
        professionRepository.save(new Profession("Thief"));
        professionRepository.save(new Profession("Guard"));
        professionRepository.save(new Profession("Gangster"));
    }

    private void fillStatus(StatusRepository statusRepository){
        statusRepository.save(new Status("Active"));
        statusRepository.save(new Status("In prison"));
        statusRepository.save(new Status("Out of game"));
        statusRepository.save(new Status("Dead"));
    }

    private void fillCriminalTypes(CriminalTypeRepository criminalTypeRepository){
        criminalTypeRepository.save(new CriminalType("Mafia"));
        criminalTypeRepository.save(new CriminalType("Gang"));
        criminalTypeRepository.save(new CriminalType("Drug business"));
        criminalTypeRepository.save(new CriminalType("Arms business"));
        criminalTypeRepository.save(new CriminalType("Far right"));
    }

    private void fillCriminalGroups(CriminalGroupRepository criminalGroupRepository){
        criminalGroupRepository.save(new CriminalGroup("Winter Hill"));
    }

    private void fillCriminals(CriminalRepository criminalRepository){
        criminalRepository.save(new Criminal("James", "Bulger", "Whitey", 175.0, "Brown", "Black",
                "Have a tattoo on right hand", "American", "Boston",
                LocalDate.of(1929, Month.SEPTEMBER, 3), "California"));
    }
}
