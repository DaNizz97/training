package com.trainingweb.trainingdiary.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sets")
@Data
public class SetOfExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "set_id")
    private Long setId;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "count_of_repeats", nullable = false)
    private Short countOfRepeats;

    @ManyToOne
    @JoinColumn(name = "particular_exercise_id")
    private ParticularExercise particularExercise;

}
