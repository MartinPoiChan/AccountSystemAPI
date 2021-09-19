package za.ac.nwu.translator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import za.ac.nwu.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
public class TranslatorConfig {
}
