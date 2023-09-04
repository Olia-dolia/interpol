package com.example.interpol.entities;

import com.example.interpol.repositories.CriminalRepository;
import com.example.interpol.services.CriminalsService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "criminal_group")
@Entity
public class CriminalGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "criminal_type_id")
    private CriminalType criminalType;

    @OneToMany(mappedBy = "criminalGroup", orphanRemoval = true)
    private Set<Criminal> criminals = new LinkedHashSet<>();

    public CriminalGroup(String name, CriminalType criminalType, Set<Criminal> criminals) {
        this.name = name;
        this.criminalType = criminalType;
        this.criminals = getCriminals();
    }

    public CriminalGroup(String name, CriminalType criminalType) {
        this.name = name;
        this.criminalType = criminalType;;
    }

    public CriminalGroup(String name) {
        this.name = name;
    }
}