package com.trainingweb.trainingdiary.domain.usecase.impl;

import com.trainingweb.trainingdiary.domain.model.Exercise;
import com.trainingweb.trainingdiary.domain.service.ExerciseService;
import com.trainingweb.trainingdiary.domain.usecase.DeleteExerciseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteExerciseUseCaseImpl implements DeleteExerciseUseCase {

    private ExerciseService exerciseService;

    @Autowired
    public DeleteExerciseUseCaseImpl(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Override
    public void deleteExercise(Long exerciseId) {
        try {
            exerciseService.delete(exerciseId);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
