package com.example.interpol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "criminal_group")
@Entity
public class CriminalGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number_of_participants", columnDefinition = "integer default 0")
    private Integer numberOfParticipants;

    @ManyToOne
    @JoinColumn(name = "criminal_type_id")
    private CriminalType criminalType;

    @OneToMany(mappedBy = "criminalGroup", orphanRemoval = true)
    private Set<Criminal> criminals = new LinkedHashSet<>();

    public CriminalGroup(String name, Integer numberOfParticipants, CriminalType criminalType, Set<Criminal> criminals) {
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.criminalType = criminalType;
        this.criminals = criminals;
    }
}