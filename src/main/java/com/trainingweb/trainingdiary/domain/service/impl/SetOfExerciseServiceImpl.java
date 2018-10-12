package com.trainingweb.trainingdiary.domain.service.impl;

import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.model.SetOfExercise;
import com.trainingweb.trainingdiary.domain.service.ParticularExerciseService;
import com.trainingweb.trainingdiary.domain.service.SetOfExerciseService;
import com.trainingweb.trainingdiary.repository.SetOfExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetOfExerciseServiceImpl implements SetOfExerciseService {

    private SetOfExerciseRepository setOfExerciseRepository;

    @Autowired
    public SetOfExerciseServiceImpl(SetOfExerciseRepository setOfExerciseRepository) {
        this.setOfExerciseRepository = setOfExerciseRepository;
    }

    @Override
    public void save(SetOfExercise setOfExercise) {
        setOfExerciseRepository.save(setOfExercise);
    }

    @Override
    public Optional<SetOfExercise> findById(Long id) {
        return setOfExerciseRepository.findById(id);
    }

    @Override
    public List<SetOfExercise> findAllByPartExercise(ParticularExercise particularExercise) {
        return setOfExerciseRepository.findAllByParticularExercise(particularExercise);
    }
}
