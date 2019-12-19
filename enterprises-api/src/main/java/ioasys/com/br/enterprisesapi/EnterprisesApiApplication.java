package ioasys.com.br.enterprisesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
		//(exclude = {SecurityAutoConfiguration.class})
public class EnterprisesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterprisesApiApplication.class, args);
//		System.out.println(new BCryptPasswordEncoder().encode("12341234"));
	}

}
