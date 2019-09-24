package com.fairwaysoftware.lms.configuration;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@Profile({"default"})
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() throws IOException {
        return EmbeddedPostgres.builder()
                .setPort(54321)
                .setCleanDataDirectory(true)
                .start().getPostgresDatabase();
    }

}
