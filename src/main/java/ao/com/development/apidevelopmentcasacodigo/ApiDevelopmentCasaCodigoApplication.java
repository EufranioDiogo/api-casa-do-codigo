package ao.com.development.apidevelopmentcasacodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ApiDevelopmentCasaCodigoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDevelopmentCasaCodigoApplication.class, args);
    }

}
