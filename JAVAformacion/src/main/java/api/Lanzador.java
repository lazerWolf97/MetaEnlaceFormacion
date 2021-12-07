package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entities")
public class Lanzador {
	
	public static void main(String[] args) {
		SpringApplication.run(Lanzador.class, args);
	}
}
