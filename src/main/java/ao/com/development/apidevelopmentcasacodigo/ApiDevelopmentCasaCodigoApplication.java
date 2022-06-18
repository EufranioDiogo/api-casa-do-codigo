package ao.com.development.apidevelopmentcasacodigo;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ApiDevelopmentCasaCodigoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDevelopmentCasaCodigoApplication.class, args);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return (factory ->
                factory.addContextCustomizers(context ->
                        context.setCookieProcessor(new LegacyCookieProcessor()
                        )));
    }
}
