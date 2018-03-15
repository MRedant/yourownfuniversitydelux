package be.cm.redant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"be.cm.redant"})
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class,args);
    }

}
