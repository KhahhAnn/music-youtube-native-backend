package vn.khahhann.musicyoutubebackend.config;

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

                // Cho phép tất cả các nguồn truy cập (mục đích thử nghiệm)
                registry.addMapping("/**")
                        .allowedOrigins("http://192.168.51.102:8081")
                        .allowedOrigins("http://192.168.43.194:8081")
                        .allowedOrigins("http://10.0.37.50:8081")
                        .allowedOrigins("http://172.20.10.4:8081")
                        .allowedOrigins("http://172.20.10.3:8081")
                        .allowedOrigins("http://192.168.1.22:8081")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
