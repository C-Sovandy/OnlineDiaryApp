package org.diary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/auth/logout") // Replace with your actual endpoint
                        .allowedOrigins("http://localhost:3000") // Allow requests from your Next.js app
                        .allowCredentials(true) // Allow credentials (cookies)
                        .allowedMethods("GET"); // Specify the allowed HTTP methods
            }
        };
    }
}
