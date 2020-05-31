package io.github.talelin.latticy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 雪
 * @create 2020-05--17:02
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Override
//    public void configureMessageConverters(List <HttpMessageConverter <?>> converters) {
//        for (int i = 0; i < converters.size(); i++) {
//            HttpMessageConverter<?> messageConverter = converters.get(i);
//            if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
//                converters.remove(i);
//            }
//        }
//        converters.add(mappingJackson2HttpMessageConverter());
//    }
//
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
//        MappingJackson2HttpMessageConverter converter=new MappingJackson2HttpMessageConverter();
//        ObjectMapper om=new ObjectMapper();
//        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        //设置中文编码格式
//        List <MediaType> list = new ArrayList <MediaType>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        converter.setSupportedMediaTypes(list);
//        converter.setObjectMapper(om);
//        return converter;
//    }

}


