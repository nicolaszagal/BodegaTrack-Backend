package com.example.BodegaTrack.BodegaTrack.shared.project.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper() { return new EnhancedModelMapper(); }

}
