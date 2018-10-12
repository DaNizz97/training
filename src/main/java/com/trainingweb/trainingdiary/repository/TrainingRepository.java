package com.trainingweb.trainingdiary.repository;

import com.trainingweb.trainingdiary.domain.model.Training;
import com.trainingweb.trainingdiary.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    Optional<Training> findAllByDate(Date date);

    List<Training> findAllByUser(User user);
}
