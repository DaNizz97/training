package com.trainingweb.trainingdiary.domain.service.impl;

import com.trainingweb.trainingdiary.domain.exception.ResourceNotFoundException;
import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.model.SetOfExercise;
import com.trainingweb.trainingdiary.domain.model.Training;
import com.trainingweb.trainingdiary.domain.service.ParticularExerciseService;
import com.trainingweb.trainingdiary.domain.service.SetOfExerciseService;
import com.trainingweb.trainingdiary.repository.ParticularExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticularExerciseServiceImpl implements ParticularExerciseService {

    private ParticularExerciseRepository particularExerciseRepository;
    private SetOfExerciseService setOfExerciseService;

    @Autowired
    public ParticularExerciseServiceImpl(ParticularExerciseRepository particularExerciseRepository) {
        this.particularExerciseRepository = particularExerciseRepository;
    }

    @Override
    public void save(ParticularExercise particularExercise) {
        particularExerciseRepository.save(particularExercise);
    }

    @Override
    public void delete(Long partExerciseId) {
        final ParticularExercise particularExercise = particularExerciseRepository.findById(partExerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("ParticularExercise", "ID", partExerciseId));
        final List<SetOfExercise> setsOfExercise = setOfExerciseService.findAllByPartExercise(particularExercise);
        if (setsOfExercise.size() != 0) {
            for (SetOfExercise setOfExercise:
                 setsOfExercise) {
                setOfExerciseService.delete(setOfExercise);
            }
        }
        particularExerciseRepository.deleteById(partExerciseId);
    }

    @Override
    public Optional<ParticularExercise> findById(Long id) {
        return particularExerciseRepository.findById(id);
    }

    @Override
    public List<ParticularExercise> findAllByTrainingId(Training training) {
        return particularExerciseRepository.findAllByTraining(training);
    }
}
