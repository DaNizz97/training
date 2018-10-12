package com.trainingweb.trainingdiary.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trainings")
@Data
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Long trainingId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<ParticularExercise> particularExercises;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void addParticularExercise(ParticularExercise particularExercise) {
        particularExercises.add(particularExercise);
    }
}
