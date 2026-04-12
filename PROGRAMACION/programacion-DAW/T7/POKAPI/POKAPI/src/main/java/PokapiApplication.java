import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service", "model", "dto"})
public class PokapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokapiApplication.class, args);
    }
}
