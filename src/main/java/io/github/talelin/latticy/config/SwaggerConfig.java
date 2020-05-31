package io.github.talelin.latticy.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 雪
 * @create 2020-04-14-14:07
 * @desc 描述
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // 定义分隔符
    private static final String splitor = ";";

    @Bean
    Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(basePackage("io.github.talelin.latticy.controller.v1"))    //这里采用包扫描的方式来确定要显示的接口
                 .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CMS")
                .description("电商小程序 CMS Api文档")
                .termsOfServiceUrl("https://blog.csdn.net/xfx_1994")
                .version("1.0")
                .build();
    }

//    public static Predicate <RequestHandler> basePackage(final String basePackage) {
//        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
//    }
//
//    private static Function <Class<?>, Boolean> handlerPackage(final String basePackage)     {
//        return input -> {
//            // 循环判断匹配
//            for (String strPackage : basePackage.split(splitor)) {
//                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
//                if (isMatch) {
//                    return true;
//                }
//            }
//            return false;
//        };
//    }
//
//    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
//        return Optional.fromNullable(input.declaringClass());
//    }

}
