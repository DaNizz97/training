package com.trainingweb.trainingdiary.domain.service.impl;

import com.trainingweb.trainingdiary.domain.exception.ResourceNotFoundException;
import com.trainingweb.trainingdiary.domain.model.Training;
import com.trainingweb.trainingdiary.domain.service.TrainingService;
import com.trainingweb.trainingdiary.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Optional<Training> findById(Long id) {
        return trainingRepository.findById(id);
    }
}
