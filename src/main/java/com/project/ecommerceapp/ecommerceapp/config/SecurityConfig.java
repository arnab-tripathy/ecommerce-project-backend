package com.project.ecommerceapp.ecommerceapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.ecommerceapp.ecommerceapp.Service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	   @Bean
	    //authentication
	    public UserDetailsService userDetailsService() {
//	        UserDetails admin = User.withUsername("Basant")
//	                .password(encoder.encode("Pwd1"))
//	                .roles("ADMIN")
//	                .build();
//	        UserDetails user = User.withUsername("John")
//	                .password(encoder.encode("Pwd2"))
//	                .roles("USER","ADMIN","HR")
//	                .build();
//	        return new InMemoryUserDetailsManager(admin, user);
	        return new UserDetailsServiceImpl();
	    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/products/**").permitAll()
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/users/**")
				.permitAll().and().formLogin().and().build();
		
	}
	
	   @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
}
