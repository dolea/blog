package blog;

import blog.domain.PublishPostUseCase;
import blog.domain.ReadPostUseCase;
import blog.domain.Repository;
import blog.infrastructure.FileRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
    @Bean
    public Repository repository() {
        return new FileRepository();
    }
}
