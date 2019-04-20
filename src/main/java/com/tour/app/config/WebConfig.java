package com.tour.app.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * @author lyq
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

//    @Autowired
//    FastJsonConfig fastJsonConfig;
//
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//
//        converters.add(fastJsonHttpMessageConverter);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);


    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//
//        registry.addMapping("/**").allowedOrigins("http://localhost:8081");
//
//    }
}
