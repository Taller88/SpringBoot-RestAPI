package board.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import board.interceptor.LoggerInterceptor;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	public void addInterceptors(InterceptorRegistry registry) {
		//인터셉터 등록
		registry.addInterceptor(new LoggerInterceptor());
	}
	
}
