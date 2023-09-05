package com.example.interpol.services;

import com.example.interpol.entities.Criminal;
import com.example.interpol.entities.Language;
import com.example.interpol.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class CriminalsService {
    private final CriminalRepository criminalRepository;
    private final CriminalGroupRepository criminalGroupRepository;
    private final ProfessionRepository professionRepository;
    private final StatusRepository statusRepository;
    private final LastCaseRepository lastCaseRepository;
    private final LanguageRepository languageRepository;

    public List<Criminal> getCriminals() {
        return criminalRepository.findAll();
    }

    public List<Criminal> getOutOfGameCriminals() {
        return criminalRepository.findCriminalsByStatusStatus("Out of game");
    }

    public Set<Criminal> getParticipantsByCriminalGroupId(Long id) {
        return criminalRepository.findCriminalByCriminalGroupId(id);
    }

    public Optional<Criminal> getCriminalById(Long id) {
        return criminalRepository.findById(id);
    }

    public void addCriminal(String firstName, String lastName, String alias, String dateBirth, String placeBirth,
                            String nationality, long[] languages, String eyesColor, String hairColor,
                            Double height, String lastPlace, Long criminalGroup, String specialSigns, String lastCase, Long profession,
                            Long status) {
        List<Language> languageList = new ArrayList<>();
        if (languages != null) {
            for (long i : languages) {
                languageList.add(languageRepository.findById(i).get());
            }
        } else languageList.add(languageRepository.findByLanguage("EN"));
        if (height == null) height = 0.0;
        LocalDate date;
        if (dateBirth.isEmpty()) date = null;
        else {
            date = LocalDate.parse(dateBirth);
        }
        criminalRepository.save(new Criminal(firstName, lastName, alias, height, eyesColor, hairColor,  specialSigns, nationality,
                placeBirth, date, lastPlace, languageList,
                professionRepository.findById(profession).get(), criminalGroupRepository.findById(criminalGroup).get(),
                statusRepository.findById(status).get(), lastCaseRepository.findLastCaseByCaseName(lastCase)));
    }

    public void addCriminal(Criminal criminal) {
        criminalRepository.save(criminal);
    }

    public void deleteCriminal(Long id) {
        criminalRepository.deleteById(id);
    }

    public void updateCriminal(Long id, String firstName, String lastName, String alias,
                               String dateBirth, String placeBirth, String nationality, long[] languages, String eyesColor,
                               String hairColor, Double height, String lastPlace, Long criminalGroup, String specialSigns,
                               String lastCase, Long profession, Long status) {
        Optional<Criminal> criminal = criminalRepository.findById(id);
        criminal.ifPresent(c -> {
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setAlias(alias);
            LocalDate date;
            if (dateBirth.isEmpty()) date = null;
            else {
                c.setDateOfBirth(LocalDate.parse(dateBirth));
            }
            c.setPlaceOfBirth(placeBirth);
            c.setNationality(nationality);
            List<Language> languageList = new ArrayList<>();
            if (languages != null) {
                for (long i : languages) {
                    languageList.add(languageRepository.findById(i).get());
                }
            } else languageList.addAll(criminal.get().getLanguages());
            c.setLanguages(languageList);
            c.setEyesColor(eyesColor);
            c.setHairColor(hairColor);
            if(height!=null) {
                c.setHeight(height);
            } else c.setHeight(criminal.get().getHeight());
            c.setLastPlaceOfResidence(lastPlace);
            c.setCriminalGroup(criminalGroupRepository.findById(criminalGroup).get());
            c.setSpecialSigns(specialSigns);
            c.setLastCase(lastCaseRepository.findByCaseName(lastCase));
            c.setProfession(professionRepository.findById(profession).get());
            c.setStatus(statusRepository.findById(status).get());
            criminalRepository.save(c);
        });
    }
}
