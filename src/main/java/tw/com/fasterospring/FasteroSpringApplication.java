package tw.com.fasterospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FasteroSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FasteroSpringApplication.class, args);
	}

}
