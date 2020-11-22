package com.cg.healthassist.doctorpatient;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.ant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** This class elaborates on configuration of the swagger concept
* 
* @author Swathi
* 
*/

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	/**in this method the document is to be created is represented */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(pathsToBeDocumented()).build();
	}
	/** method to represent the path to be documented */
	@SuppressWarnings("unchecked")
	private Predicate<String> pathsToBeDocumented() {
		return or(ant("/api/**"));
	}
	/** method to represent the title, version and license */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("doctor API").description("Doctor-Patient REST API").license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}
	
}