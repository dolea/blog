package end2end;

import blog.domain.Post;
import blog.domain.Repository;
import blog.infrastructure.FileRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PersistenceTestConfiguration {
    @Bean
    public Repository repository() {
        return new InMemoryRepository();
    }
}
