package com.trainingweb.trainingdiary.domain.service;

import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.model.Training;

import java.util.List;
import java.util.Optional;

public interface ParticularExerciseService {
    void save(ParticularExercise particularExercise);
    void delete(Long id);
    Optional<ParticularExercise> findById(Long id);
    List<ParticularExercise> findAllByTrainingId(Training training);
}
