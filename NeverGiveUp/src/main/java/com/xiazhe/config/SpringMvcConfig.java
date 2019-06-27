package com.xiazhe.config;

import com.xiazhe.Intercepter.MyInterceptor;
import com.xiazhe.convert.MyConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;


@EnableWebMvc
@ComponentScan(basePackages = "com.xiazhe.controller")

public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    ConfigurableConversionService conversionService;

    @PostConstruct
    public void addConvert() {
        System.out.println("111111");
        conversionService.addConverter(new MyConvert());

    }

    @Bean
    @Primary
    public ConfigurableConversionService configurableConversionService() {
        System.out.println("222222222");
        return conversionService;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //前面的是mapping 后面的是location
        registry.addResourceHandler("/jsp/**").addResourceLocations("/WEB-INF/jsp/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image/");
        registry.addResourceHandler("/jpg/**").addResourceLocations("classpath:/jpg/");
        registry.addResourceHandler("/jsp/**").addResourceLocations("file:e://jpg/");
    }


}
