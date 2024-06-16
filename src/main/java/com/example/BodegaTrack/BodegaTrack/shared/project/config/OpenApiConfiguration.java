package com.example.BodegaTrack.BodegaTrack.shared.project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    /**
     * Creates a custom OpenAPI configuration.
     *
     * @param applicationDescription The description of the Fast Food application
     * @param applicationVersion     The version of the Fast Food application
     * @return The custom OpenAPI configuration
     */
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${documentation.application.description}") String applicationDescription,
            @Value("${documentation.application.version}") String applicationVersion) {

        return new OpenAPI()
                .info(new Info()
                        .title("Bodega Track API")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .contact(new Contact()
                                .name("BodegaTrackTeam")
                                .email("bodegatrack@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0"))

                );
    }
}
