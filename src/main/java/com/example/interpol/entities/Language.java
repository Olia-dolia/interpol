package com.example.interpol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "language")
@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "criminal_id")
    private Criminal criminal;

    public Language(String language) {
        this.language = language;
    }

    public Language(String language, Criminal criminal) {
        this.language = language;
        this.criminal = criminal;
    }
}