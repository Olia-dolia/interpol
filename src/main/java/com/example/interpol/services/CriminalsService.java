package com.example.interpol.services;

import com.example.interpol.entities.Criminal;
import com.example.interpol.entities.Language;
import com.example.interpol.entities.LastCase;
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

    public List<Criminal> getCriminalsExceptArchive() {
        return criminalRepository.findCriminalByStatusIsNot("Out of game");
    }

    public List<Criminal> getCriminalsByStatusId(Long id) {
        return criminalRepository.findCriminalsByStatusId(id);
    }

    public Set<Criminal> getParticipantsByCriminalGroupId(Long id) {
        return criminalRepository.findCriminalByCriminalGroupId(id);
    }

    public Optional<Criminal> getCriminalById(Long id) {
        return criminalRepository.findById(id);
    }

    /*public List<Criminal> getCriminalsByLanguages(long[] languages) {
        List<Language> languageList = new ArrayList<>();
        for (long i : languages) {
            languageList.add(languageRepository.findById(i).get());
        }
        return criminalRepository.findAllByLanguages(languageList);
    }*/

    public void addCriminal(String firstName, String lastName, String alias, String dateBirth, String placeBirth,
                            String nationality, long[] languages, String eyesColor, String hairColor,
                            Double height, String lastPlace, Long criminalGroup, String specialSigns, Long lastCase, Long profession,
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
        LastCase lc = new LastCase();
        if (lastCase!=0) {
            lc = lastCaseRepository.findById(lastCase).get();
        } else {
            lc = null;
        }
        criminalRepository.save(new Criminal(firstName, lastName, alias, height, eyesColor, hairColor, specialSigns, nationality,
                placeBirth, date, lastPlace, languageList,
                professionRepository.findById(profession).get(), criminalGroupRepository.findById(criminalGroup).get(),
                statusRepository.findById(status).get(), lc));
    }

    public void deleteCriminal(Long id) {
        criminalRepository.deleteById(id);
    }

    public void updateCriminal(Long id, String firstName, String lastName, String alias,
                               String dateBirth, String placeBirth, String nationality, long[] languages, String eyesColor,
                               String hairColor, Double height, String lastPlace, Long criminalGroup, String specialSigns,
                               Long lastCase, Long profession, Long status) {
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
            if (height != null) {
                c.setHeight(height);
            } else c.setHeight(criminal.get().getHeight());
            c.setLastPlaceOfResidence(lastPlace);
            c.setCriminalGroup(criminalGroupRepository.findById(criminalGroup).get());
            c.setSpecialSigns(specialSigns);
            if(lastCase!=0){
                c.setLastCase(lastCaseRepository.findById(lastCase).get());
            } else c.setLastCase(null);
            c.setProfession(professionRepository.findById(profession).get());
            c.setStatus(statusRepository.findById(status).get());
            criminalRepository.save(c);
        });
    }

    public List<Criminal> getCriminalsByNameOrAlias(String name) {
        return criminalRepository.findAllByFirstNameOrLastNameOrAliasLike(name);
    }

    public List<Criminal> getCriminalsByProfessionId(long professionId) {
        return criminalRepository.findCriminalByProfessionId(professionId);
    }

    public List<Criminal> getCriminalsByLastCaseId(long lastCaseId) {
        return criminalRepository.findCriminalByLastCaseId(lastCaseId);
    }
}
