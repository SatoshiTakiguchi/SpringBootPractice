package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; // 追加
import org.springframework.web.bind.annotation.RestController; //追加

@SpringBootApplication
@RestController // 追加
public class AppApplication {

	@RequestMapping("/") // 追加
	public String home() { // 追加
		return "Hello "; // 追加
	} // 追加

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}