package com.vilelatech.rh.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final CorsConfigurationSource corsConfigurationSource;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .authorizeHttpRequests(auth -> auth
                        // Endpoints públicos
                        .requestMatchers(
                            new AntPathRequestMatcher("/api/auth/**"),
                            new AntPathRequestMatcher("/api/colaboradores/**"),
                            new AntPathRequestMatcher("/api/cargos/**"),
                            new AntPathRequestMatcher("/h2-console/**")
                        ).permitAll()
                        
                        // Endpoint de colaboradores - apenas perfis ADMIN e RH
                        .requestMatchers("/api/colaboradores/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_RH")
                        
                        // Endpoints de registro de ponto - todos autenticados podem acessar
                        .requestMatchers("/api/registros/**").authenticated()
                        
                        // Por padrão, exige autenticação
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers.frameOptions().disable()) // Para H2 Console
                .build();
    }
    
    /**
     * PasswordEncoder simples sem criptografia - para desenvolvimento/teste
     * Compara as senhas diretamente (plain text)
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                // Não criptografa - retorna a senha como está
                return rawPassword.toString();
            }
            
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                // Compara diretamente as strings
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
