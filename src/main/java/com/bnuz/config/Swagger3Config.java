package com.bnuz.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
@EnableKnife4j
public class Swagger3Config extends WebMvcConfigurationSupport {
    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .apiInfo(apiInfo())
                .groupName("物业app接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bnuz.controller"))//配置要扫描接口的方式
                .build();

    }
    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("chanchitin","blog.cqt.com","369xxxx336@qq.com");
        return new ApiInfo(
                "物业app文档",
                "关于物业app的Api",
                "1.0",
                "blog.cqt.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.
                addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui")
                .setViewName("/swagger-ui/index.html");
        // swagger3 登录url localhost:8080/swagger-ui/index.html
        // swagger2 登录url localhost:8080/swagger-ui.html


    }

}
