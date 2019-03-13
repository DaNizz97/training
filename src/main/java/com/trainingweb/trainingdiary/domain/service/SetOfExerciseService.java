package com.trainingweb.trainingdiary.domain.service;

import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.model.SetOfExercise;

import java.util.List;
import java.util.Optional;

public interface SetOfExerciseService {
    void delete(SetOfExercise setOfExercise);
    void save(SetOfExercise setOfExercise);
    Optional<SetOfExercise> findById(Long id);
    List<SetOfExercise> findAllByPartExercise(ParticularExercise particularExercise);
}
