package homework.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:ams.properties")
public class FileUploadController implements WebMvcConfigurer {

    @Value("${file.image.path}")
    String path;
    @Value("${file.image.server}")
    String server;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(path + "**").addResourceLocations("file:" + server);
    }


}
