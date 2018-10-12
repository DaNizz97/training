package com.trainingweb.trainingdiary.domain.usecase.impl;

import com.trainingweb.trainingdiary.domain.model.Exercise;
import com.trainingweb.trainingdiary.domain.service.ExerciseService;
import com.trainingweb.trainingdiary.domain.usecase.AddExerciseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddExerciseUseCaseImpl implements AddExerciseUseCase {

    private final ExerciseService exerciseService;

    @Autowired
    public AddExerciseUseCaseImpl(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Override
    public Long addExercise(String exerciseName) {
        final Exercise exercise = new Exercise();
        exercise.setExerciseName(exerciseName);

        exerciseService.save(exercise);

        return exercise.getExerciseId();
    }

}
