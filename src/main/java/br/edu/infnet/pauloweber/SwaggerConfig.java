package br.edu.infnet.pauloweber;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("API de Gerenciamento de Frotas")
            .version("1.0")
            .description("API para gerenciamento de frotas de veículos e motoristas.")
            .contact(new Contact()
            .name("Paulo Weber")
            .email("pauloweber@infnet.edu.br")));
  }
}
