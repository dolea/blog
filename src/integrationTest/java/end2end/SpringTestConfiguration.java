package end2end;

import blog.DomainConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = "blog")
@Import({DomainConfiguration.class, PersistenceTestConfiguration.class})
public class SpringTestConfiguration {
}
