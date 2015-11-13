package blog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DomainConfiguration.class, PersistenceConfiguration.class})
public class SpringConfiguration {
}
