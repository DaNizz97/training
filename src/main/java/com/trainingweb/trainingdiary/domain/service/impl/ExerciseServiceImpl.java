package com.trainingweb.trainingdiary.domain.service.impl;

import com.trainingweb.trainingdiary.domain.exception.ResourceNotFoundException;
import com.trainingweb.trainingdiary.domain.model.Exercise;
import com.trainingweb.trainingdiary.domain.service.ExerciseService;
import com.trainingweb.trainingdiary.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public void save(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public Optional<Exercise> findByName(String exerciseName) {
        return exerciseRepository.findByExerciseName(exerciseName);
    }

    @Override
    public Optional<Exercise> findById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId);
    }

    @Override
    public void delete(Long id) {
            exerciseRepository.deleteById(id);
    }

}
