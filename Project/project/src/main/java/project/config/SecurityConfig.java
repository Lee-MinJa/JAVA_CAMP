package project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import project.config.oauth.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeHttpRequests()
			.antMatchers("/member/**").authenticated()
			//.antMatchers("/member").hasAuthority("ROLE_MEMBER")
			.antMatchers("/biz/**").hasAuthority("ROLE_BIZ")
			.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			//.loginPage("/loginForm")
			.loginProcessingUrl("/login")
			.usernameParameter("memId")
			.defaultSuccessUrl("/")
		.and()
			.oauth2Login()
			.loginPage("/oauth")
			.userInfoEndpoint()
			.userService(principalOauth2UserService);
			
	}
}
