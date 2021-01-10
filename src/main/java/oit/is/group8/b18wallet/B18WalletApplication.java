package oit.is.group8.b18wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class B18WalletApplication {
	public static void main(String[] args) {
		SpringApplication.run(B18WalletApplication.class, args);
	}
}
