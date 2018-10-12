package com.trainingweb.trainingdiary.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "particular_exercises")
@Data
public class ParticularExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "particular_exercise_id")
    private Long particularExerciseId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "particularExercise")
    private List<SetOfExercise> setsOfExercise;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;
}






