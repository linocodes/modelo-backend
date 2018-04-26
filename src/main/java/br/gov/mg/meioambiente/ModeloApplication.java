package br.gov.mg.meioambiente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ModeloApplication extends SpringBootServletInitializer {
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());	

	/*
	 * //private Logger logger = LoggerFactory.getLogger(this.getClass());
	 * 
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) {
	 * //logger.info("Starting Spring Boot application.."); return
	 * application.sources(ModeloApplication.class); }
	 * 
	 * public static void main(String[] args) {
	 * SpringApplication.run(ModeloApplication.class, args); }
	 */

	//public static void main(String[] args) {
	//	SpringApplication.run(applicationClass, args);
	//}
/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("Starting Spring Boot application..");		
		logger.info("Student id 10001 -> {}",10);		
		return application.sources(applicationClass);
	}

	private static Class<ModeloApplication> applicationClass = ModeloApplication.class;
	*/

}
