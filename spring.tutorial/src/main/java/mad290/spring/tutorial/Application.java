package mad290.spring.tutorial;

import mad290.spring.tutorial.entities.Customer;
import mad290.spring.tutorial.repositories.CustomerRepository;
import mad290.spring.tutorial.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication(exclude = {
        // disable auto configuration to prevent datasource error
        // DataSourceAutoConfiguration.class,

        // disable auto configuration to prevent login
        SecurityAutoConfiguration.class
})
//@EntityScan
//@EnableJpaRepositories
@PropertySource(value = "secrets/database.properties")
public class Application
{
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Value("${secrets.database.password}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
        CommandLineRunner is used to run code after the application is started.
        This is useful for testing.
     */
    @Bean
    public CommandLineRunner run(UserRepository userRepository){
        return args -> {
            System.out.println("value is " + password);
            System.out.println("----Command line runner starts----");
            var users = userRepository.findAll();
            for (var user : users) {
                System.out.println(user.print());
            }
            System.out.println("----Command line runner ends----");
        };
    }

}
