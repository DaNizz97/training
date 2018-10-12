package com.trainingweb.trainingdiary;

import com.trainingweb.trainingdiary.domain.model.Exercise;
import com.trainingweb.trainingdiary.domain.model.ParticularExercise;
import com.trainingweb.trainingdiary.domain.service.ParticularExerciseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingDiaryApplicationTests {

	@Autowired
	ParticularExerciseService particularExerciseService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPartExercisesByTraining() {
		particularExerciseService.findAllByTrainingId(1L);
	}

	@Test
	public void setExerciseName() {
		Exercise exercise = new Exercise();
		exercise.setExerciseName("new exercise");
		exercise.setExerciseId(1L);
		System.out.println(exercise.getExerciseId() + " - exercise name");
	}

}
