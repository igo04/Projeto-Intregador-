package br.com.gestaojogos.config;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

public class  WebConfig implements webMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) (
                registry.addMapping("/**")
            )
}