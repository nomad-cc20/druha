package cz.upce.fei.inpda.druha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
@EnableScheduling
public class DruhaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruhaApplication.class, args);
    }

}
