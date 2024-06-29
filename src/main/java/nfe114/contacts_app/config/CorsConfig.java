package nfe114.contacts_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

import nfe114.contacts_app.constant.HeaderConstants;

/*
 * Classe permettant de configurer les URL de connection (GET, POST...)
 */

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        var urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        var corsConfiguration = new CorsConfiguration();
        // Autorise les cookies
        corsConfiguration.setAllowCredentials(true);
        // Autorise les URL locales suivantes, définir ici le port local utile pour l'app front-end React
        corsConfiguration.setAllowedOrigins(List.of(
                "http://localhost:3000"
        ));
        // Liste standard de headers autorisés dans les requêtes
        corsConfiguration.setAllowedHeaders(List.of(
                HeaderConstants.ORIGIN, 
                HeaderConstants.CONTENT_TYPE, 
                HeaderConstants.ACCEPT, 
                HeaderConstants.AUTHORIZATION, 
                HeaderConstants.X_REQUESTED_WITH, 
                HeaderConstants.ACCESS_CONTROL_REQUEST_METHOD, 
                HeaderConstants.ACCESS_CONTROL_REQUEST_HEADERS, 
                HeaderConstants.ACCESS_CONTROL_ALLOW_CREDENTIALS
        ));
        corsConfiguration.setExposedHeaders(List.of(
                HeaderConstants.ORIGIN, 
                HeaderConstants.CONTENT_TYPE, 
                HeaderConstants.ACCEPT, 
                HeaderConstants.AUTHORIZATION, 
                HeaderConstants.X_REQUESTED_WITH, 
                HeaderConstants.ACCESS_CONTROL_REQUEST_METHOD, 
                HeaderConstants.ACCESS_CONTROL_REQUEST_HEADERS, 
                HeaderConstants.ACCESS_CONTROL_ALLOW_CREDENTIALS
        ));
        // Méthodes HTTP de communication avec le serveur
        corsConfiguration.setAllowedMethods(List.of(
                "GET", 
                "POST", 
                "PUT", 
                "PATCH", 
                "DELETE", 
                "OPTIONS"
        ));
        
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}