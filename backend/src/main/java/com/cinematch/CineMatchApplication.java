
package com.cinematch;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cinematch.model")
@EnableJpaRepositories("com.cinematch.repository")
public class CineMatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(CineMatchApplication.class, args);
    }
}
