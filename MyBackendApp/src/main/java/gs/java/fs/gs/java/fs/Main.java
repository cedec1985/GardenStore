package gs.java.fs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "gs.java.fs")
@ComponentScan("gs.java.fs.utils")
public class Main {
public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}


