package com.ensp.elearning;

import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.service.LearningSystemServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class ElearningApplication {
	/*@Autowired
	LearningSystemServiceSpec learningSystemServiceSpec;*/

	public static void main(String[] args) {
		SpringApplication.run(ElearningApplication.class, args);

	}

	/*@PostConstruct
	public void testElearningService(){
		System.out.println("**********creating system***************");
		for (int i=0; i<10; i++){
			LearningSystem learningSystem = new LearningSystem();
			learningSystem.setName("Test "+i);
			learningSystem.setDescription("Test system description "+i);
			learningSystemServiceSpec.create(learningSystem);
		}
		System.out.println("**********Reading system***************");
		List<LearningSystem> learningSystemList = learningSystemServiceSpec.readAll();
		learningSystemList.forEach(learningSystem -> System.out.println(learningSystem));
		System.out.println("**********deleting odd system***************");
		learningSystemList.forEach(learningSystem ->{
			if(learningSystem.getId()%2 ==0){
				learningSystemServiceSpec.delete(learningSystem.getId());
			}
		});
		System.out.println("**********after deleting odd system***************");
		learningSystemList = learningSystemServiceSpec.readAll();
		learningSystemList.forEach(learningSystem -> System.out.println(learningSystem));
	}
*/
}
