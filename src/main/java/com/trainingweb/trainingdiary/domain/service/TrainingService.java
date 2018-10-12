package com.trainingweb.trainingdiary.domain.service;

import com.trainingweb.trainingdiary.domain.model.Training;

import java.util.Optional;

public interface TrainingService {
    Optional<Training> findById(Long id);
}
