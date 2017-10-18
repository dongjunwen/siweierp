package com.fangxin.siwei.fangzhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger-ui的配置
 * api页面 /swagger-ui.html 或者/swagger/index.html ()
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fangxin.siwei.fangzhi.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("思维纺织ERP测试接口")
                .termsOfServiceUrl("https://github.com/dongjunwen/siweierp")
                .description("思维纺织ERP后台接口")
                .contact(new Contact("思维纺织ER","https://github.com/dongjunwen/siweierp","704434431@qq.com"))
                .version("1.0.0")
                .build();
    }

}
