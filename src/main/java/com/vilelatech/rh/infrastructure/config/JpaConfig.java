package com.vilelatech.rh.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.vilelatech.rh.adapters.outbound.persistence.repository")
public class JpaConfig {
} 