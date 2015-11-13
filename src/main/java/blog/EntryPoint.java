package blog;

import blog.domain.PublishPostUseCase;
import blog.domain.ReadPostUseCase;
import blog.domain.Repository;
import blog.infrastructure.FileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntryPoint {

    public static void main(String[] args) {
        SpringApplication.run(EntryPoint.class, args);
    }

    @Bean
    public ReadPostUseCase readPostUseCase(Repository repository) {
        return new ReadPostUseCase(repository);
    }

    @Bean
    public PublishPostUseCase publishPostUseCase(Repository repository) {
        return new PublishPostUseCase(repository);
    }

    @Bean
    public Repository repository() {
        return new FileRepository();
    }
}
