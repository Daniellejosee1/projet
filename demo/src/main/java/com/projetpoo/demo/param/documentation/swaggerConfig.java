package com.projepoo.demo.media.documentation;

@Configuration
@EnableSwagger2WebMvc
public class swaggerConfig {

   @Bean
   public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.projetpoo.demo"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
   }

   private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
            .title("API RESTful de Elearn")
            .description("Documentation de l'API RESTful de Elearn")
            .version("1.0")
            .build();
   }
}
