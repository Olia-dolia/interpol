package com.example.interpol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "criminal_type")
@Entity
public class CriminalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private Long id;

    @Column(name = "name_type")
    private String nameType;

    @OneToMany(mappedBy = "criminalType", orphanRemoval = true)
    private Set<CriminalGroup> criminalGroups = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "criminal_type_professions",
            joinColumns = @JoinColumn(name = "criminalType_id"),
            inverseJoinColumns = @JoinColumn(name = "professions_id"))
    private List<Profession> professions = new ArrayList<>();

    public CriminalType(String nameType) {
        this.nameType = nameType;
    }
}