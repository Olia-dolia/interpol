package com.example.interpol.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "criminal")
@Entity
public class Criminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "alias", nullable = false)
    private String alias;

    @Nullable
    @Column(name = "height")
    private Double height;

    @Column(name = "eyes_color")
    private String eyesColor;

    @Column(name = "hair_color")
    private String hairColor;

    @Column(name = "special_signs")
    private String specialSigns;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Nullable
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "last_place_of_residence")
    private String lastPlaceOfResidence;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "criminal_group_id")
    private CriminalGroup criminalGroup;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "last_case_id")
    private LastCase lastCase;

    @Nullable
    @ManyToMany
    @JoinTable(name = "criminal_languages",
            joinColumns = @JoinColumn(name = "criminal_id"),
            inverseJoinColumns = @JoinColumn(name = "languages_id"))
    private List<Language> languages = new ArrayList<>();

    public Criminal(String firstName, String lastName, String alias, Double height,
                    String eyesColor, String hairColor, String specialSigns,
                    String nationality, String placeOfBirth, LocalDate dateOfBirth,
                    String lastPlaceOfResidence, List<Language> languages,
                    Profession profession, CriminalGroup criminalGroup, Status status,
                    LastCase lastCase) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.height = height;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.specialSigns = specialSigns;
        this.nationality = nationality;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.lastPlaceOfResidence = lastPlaceOfResidence;
        this.languages = languages;
        this.profession = profession;
        this.criminalGroup = criminalGroup;
        this.status = status;
        this.lastCase = lastCase;
    }

    public Criminal(String firstName, String lastName, String alias, Double height, String eyesColor,
                    String hairColor, String specialSigns, String nationality, String placeOfBirth,
                    LocalDate dateOfBirth, String lastPlaceOfResidence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.height = height;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.specialSigns = specialSigns;
        this.nationality = nationality;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.lastPlaceOfResidence = lastPlaceOfResidence;
    }

    public Criminal(String firstName, String lastName, String alias, Double height, String eyesColor,
                    String hairColor, String nationality, String specialSigns, String placeBirth, LocalDate date,
                    String lastPlace, CriminalGroup byName, LastCase lastCaseByCaseName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.height = height;
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.nationality =nationality;
        this.specialSigns = specialSigns;
        this.placeOfBirth = placeBirth;
        this.dateOfBirth = date;
        this.lastPlaceOfResidence = lastPlace;
        this.criminalGroup = byName;
        this.lastCase = lastCaseByCaseName;
    }

    public Criminal(String firstName, String lastName, String alias) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
    }

    public String printLanguages() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Language l : languages) {
            stringBuilder.append(l.getLanguage()).append(" ");
        }
        return stringBuilder.toString();
    }
}