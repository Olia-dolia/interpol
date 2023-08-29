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
@Table(name = "status")
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<Criminal> criminals = new LinkedHashSet<>();

    public Status(String status) {
        this.status = status;
    }

    public void setCriminals(Set<Criminal> criminals) {
        this.criminals = criminals;
    }


}