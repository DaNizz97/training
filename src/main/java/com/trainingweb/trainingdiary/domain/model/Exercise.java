package com.trainingweb.trainingdiary.domain.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercises")
@Data
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long exerciseId;

    @Column(name = "name", nullable = false)
    private String exerciseName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<ParticularExercise> particularExercises;

    public void addParticularExercise(ParticularExercise particularExercise) {
        particularExercises.add(particularExercise);
    }
}
