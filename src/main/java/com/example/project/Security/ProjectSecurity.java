package com.example.project.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.project.Service.ProjectDetails;
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ProjectSecurity extends WebSecurityConfigurerAdapter
{
	
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	ProjectDetails details;
	
	@Autowired
	ErrorHandler unauthorizedHandler;
	
	@Autowired
	JwtFilter jwtfilter;

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
@Override
protected void configure(HttpSecurity security) throws Exception
{
	security.cors();
	security.csrf().disable();
	
	//security.authorizeRequests().anyRequest().fullyAuthenticated().and()
	//security.authorizeRequests().antMatchers("/**").fullyAuthenticated().and()
	//security.authorizeRequests().antMatchers("/location").authenticated().and().httpBasic().authenticationEntryPoint(unauthorizedHandler);
	
	//security.authorizeRequests().antMatchers("/location").permitAll().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(unauthorizedHandler);
	
	security.authorizeRequests().antMatchers("/location").permitAll().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(unauthorizedHandler);
	
	//security.authorizeRequests().antMatchers("/location").permitAll().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(unauthorizedHandler).and().formLogin().loginPage("/home").defaultSuccessUrl("/home1");
	
	
	security.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	
	//.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
} 

@Override 
protected void configure(AuthenticationManagerBuilder amb) throws Exception 
	  {
	  //amb.inMemoryAuthentication().withUser("praveen").password("{noop}3752").roles("");
	
	
		//amb.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder());
	
		//amb.userDetailsService(details).passwordEncoder(passwordEncoder());
	
		amb.authenticationProvider(authenticationProvider());
	
	  }

@Bean
public DaoAuthenticationProvider authenticationProvider()
{
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(details);
    return provider;
}

	 
}
