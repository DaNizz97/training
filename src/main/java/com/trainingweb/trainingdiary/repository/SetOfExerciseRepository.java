package com.trainingweb.trainingdiary.repository;

import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.model.SetOfExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetOfExerciseRepository extends JpaRepository<SetOfExercise, Long> {

    List<SetOfExercise> findAllByParticularExercise(ParticularExercise particularExercise);

    
}
