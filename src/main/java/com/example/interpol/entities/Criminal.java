package com.example.interpol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "criminal")
@Entity
public class Criminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "alias", nullable = false)
    private String alias;

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

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;//mb use calendar?

    @Column(name = "last_place_of_residence")
    private String lastPlaceOfResidence;

    @OneToMany(mappedBy = "criminal", orphanRemoval = true)
    private Set<Language> languages = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @ManyToOne
    @JoinColumn(name = "criminal_group_id")
    private CriminalGroup criminalGroup;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "last_case_id")
    private LastCase lastCase;

    public Criminal(String firstName, String lastName, String alias, Double height,
                    String eyesColor, String hairColor, String specialSigns,
                    String nationality, String placeOfBirth, LocalDate dateOfBirth,
                    String lastPlaceOfResidence, Set<Language> languages,
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
}