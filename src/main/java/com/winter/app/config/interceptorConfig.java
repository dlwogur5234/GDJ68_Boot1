package com.winter.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.winter.app.interceptors.TestInterceptor;

//먼저 읽으라는 명령어
@Configuration
public class interceptorConfig implements WebMvcConfigurer{
	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(testInterceptor)
				.addPathPatterns("/notice/list")
				;
		
		registry.addInterceptor(localeChangeInterceptor)
				.addPathPatterns("/**")
				;
	}		
}
