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
@Table(name = "profession")
@Entity
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @OneToMany(mappedBy = "profession", orphanRemoval = true)
    private Set<Criminal> criminals = new LinkedHashSet<>();

    public Profession(String title) {
        this.title = title;
    }
}