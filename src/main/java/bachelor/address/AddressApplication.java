package bachelor.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AddressApplication {
	public static void main(String[] args) {
		SpringApplication.run(AddressApplication.class, args);
	}

}
