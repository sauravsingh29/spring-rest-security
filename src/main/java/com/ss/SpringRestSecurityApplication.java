package com.ss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringRestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecurityApplication.class, args);
	}
	
	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// You can change based on your oauth request permitAll() to authenticated()
			http.authorizeRequests().anyRequest().permitAll().and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.NEVER);
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources",
					"/configuration/security", "/swagger-ui.html", "/webjars/**");
		}
	}
}
