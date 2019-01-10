package crawlertl.admin.configure;

import crawlertl.admin.repositories.CustomerRepository;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

@Configuration
public class DBConfig {

    @Value("${datasource.host}")
    private String host;

    @Value("${datasource.database}")
    private String database;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.port}")
    private int port;

    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(host)
                        .database(database)
                        .port(port)
                        .username(username)
                        .password(password)
                        .build());
    }

    @Bean
    DatabaseClient databaseClient(ConnectionFactory factory) {
        return DatabaseClient.builder()
                .connectionFactory(factory)
                .build();
    }

    @Bean
    R2dbcRepositoryFactory repositoryFactory(DatabaseClient client) {
        RelationalMappingContext context = new RelationalMappingContext();
        context.afterPropertiesSet();

        return new R2dbcRepositoryFactory(client, context);
    }

    @Bean
    CustomerRepository coffeeRepository(R2dbcRepositoryFactory factory) {
        return factory.getRepository(CustomerRepository.class);
    }
}