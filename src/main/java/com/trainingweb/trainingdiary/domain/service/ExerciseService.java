package com.trainingweb.trainingdiary.domain.service;

import com.trainingweb.trainingdiary.domain.model.Exercise;

import java.util.Optional;

public interface ExerciseService {
    void save(Exercise exercise);
    Optional<Exercise> findByName(String exerciseName);
    Optional<Exercise> findById(Long exerciseId);
    void delete(Long id);
}
