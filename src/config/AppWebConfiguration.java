package config;


	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.web.servlet.config.annotation.EnableWebMvc;
	import org.springframework.web.servlet.view.InternalResourceViewResolver;

import aluno.controllers.HomeController;

	@EnableWebMvc
	@ComponentScan(basePackageClasses={HomeController.class})
	public class AppWebConfiguration {
		
		@Bean
		public InternalResourceViewResolver internalResourceViewResolver(){
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}

	}
