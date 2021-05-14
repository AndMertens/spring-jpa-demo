package be.bornput.springjpademo;

import be.bornput.springjpademo.model.Student;
import be.bornput.springjpademo.persistence.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	// run some code after that springboot application has come up)
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save ( new Student("andy", "mertens", "andy.mertens@gmail.com",51));
		};
	}

}
