package designpatterns.yesteryearyonder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class YesteryearYonderApplication {

	@RequestMapping("/")
	public String helloWorld() {
		return "Welcome to Yesteryear Yonder";
	}

	public static void main(String[] args) {
		SpringApplication.run(YesteryearYonderApplication.class, args);
	}

}
