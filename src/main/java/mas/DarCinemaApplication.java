package mas;

import mas.Clients.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DarCinemaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DarCinemaApplication.class, args);

		context.getBean(ClientService.class).fillInitialData();
	}
}
