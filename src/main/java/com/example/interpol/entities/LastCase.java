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
@Table(name = "last_case")
@Entity
public class LastCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "case_name", nullable = false, unique = true)
    private String caseName;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @OneToMany(mappedBy = "lastCase", orphanRemoval = true)
    private Set<Criminal> criminals = new LinkedHashSet<>();

    public LastCase(String name, String description) {
        this.caseName = name;
        this.description = description;
    }
}