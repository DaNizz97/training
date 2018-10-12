package com.trainingweb.trainingdiary.domain.usecase.impl;

import com.trainingweb.trainingdiary.domain.exception.ResourceNotFoundException;
import com.trainingweb.trainingdiary.domain.model.*;
import com.trainingweb.trainingdiary.domain.service.*;
import com.trainingweb.trainingdiary.domain.usecase.AddParticularExerciseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddParticularExerciseUseCaseImpl implements AddParticularExerciseUseCase {

    private ParticularExerciseService particularExerciseService;
    private ExerciseService exerciseService;
    private SecurityService securityService;
    private TrainingService trainingService;
    private UserService userService;

    @Autowired
    public AddParticularExerciseUseCaseImpl(ParticularExerciseService particularExerciseService,
                                            ExerciseService exerciseService, SecurityService securityService,
                                            TrainingService trainingService, UserService userService) {
        this.particularExerciseService = particularExerciseService;
        this.exerciseService = exerciseService;
        this.securityService = securityService;
        this.trainingService = trainingService;
        this.userService = userService;
    }

    @Override
    public Long addParticularExercise(Long exerciseId, Long trainingId) {
        final Exercise exercise = exerciseService.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise", "ID", exerciseId));
        final Training training = trainingService.findById(trainingId)
                .orElseThrow(() -> new ResourceNotFoundException("Training", "ID", trainingId));
        List<SetOfExercise> setsOfExercise = new ArrayList<>();

        ParticularExercise particularExercise = new ParticularExercise();
        particularExercise.setExercise(exercise);
        particularExercise.setTraining(training);
        particularExercise.setSetsOfExercise(setsOfExercise);
        exercise.addParticularExercise(particularExercise);
        training.addParticularExercise(particularExercise);

        particularExerciseService.save(particularExercise);
        return particularExercise.getParticularExerciseId();
    }

    @Override
    public void deleteParticularExercise(Long id) {
        try {
            particularExerciseService.delete(id);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public boolean isUserCanAddParticularExercise() {
        return userService.getCurrentAuthUser().isPresent();
    }
}
