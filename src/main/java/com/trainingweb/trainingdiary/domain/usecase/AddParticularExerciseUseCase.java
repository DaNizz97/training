package com.trainingweb.trainingdiary.domain.usecase;

import com.trainingweb.trainingdiary.domain.model.ParticularExercise;

public interface AddParticularExerciseUseCase {
    Long addParticularExercise(Long exerciseId, Long trainingId);
    void deleteParticularExercise(Long id);
    boolean isUserCanAddParticularExercise();
}
