package com.programmingtechie.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * This method defines the security configuration for the Spring WebFlux application.
     * @param serverHttpSecurity
     * @return
     */
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity){
        /**
         * Disable CSRF protection since this is a stateless, token-based authentication.
         * Allow access to paths starting with "/eureka/" without authentication & require authentication for any other path.
         * Configure OAuth2 resource server (Keycloak) using JWT for authentication.
         */

        serverHttpSecurity
            .csrf(csrf -> csrf.disable())
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/eureka/**").permitAll()
                .anyExchange().authenticated()
            )
            .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer
                .jwt()
            )
        ;

        // Build and return the configured SecurityWebFilterChain
        return serverHttpSecurity.build();
    }
}
