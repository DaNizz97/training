package com.trainingweb.trainingdiary.repository;

import com.trainingweb.trainingdiary.domain.model.Exercise;
import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticularExerciseRepository extends JpaRepository<ParticularExercise, Long> {
    Optional<ParticularExercise> findByExercise(Exercise exercise);
    List<ParticularExercise> findAllByTraining(Training training);
}
