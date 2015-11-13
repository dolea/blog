package blog;

import blog.domain.PublishPostUseCase;
import blog.domain.ReadPostUseCase;
import blog.domain.Repository;
import blog.infrastructure.FileRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {
    @Bean
    public ReadPostUseCase readPostUseCase(Repository repository) {
        return new ReadPostUseCase(repository);
    }

    @Bean
    public PublishPostUseCase publishPostUseCase(Repository repository) {
        return new PublishPostUseCase(repository);
    }
}
