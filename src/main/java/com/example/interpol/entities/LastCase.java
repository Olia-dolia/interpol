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
@Table(name = "last_case")
@Entity
public class LastCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "case_name", nullable = false, unique = true)
    private String caseName;

    @Column(name = "number_of_participants", columnDefinition = "integer default 0")
    private Integer numberOfParticipants;

    @OneToMany(mappedBy = "lastCase", orphanRemoval = true)
    private Set<Criminal> criminals = new LinkedHashSet<>();

}