package pl.tfkable.quality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;





@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableScheduling
public class ReklamacjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReklamacjeApplication.class, args);
	}
}













