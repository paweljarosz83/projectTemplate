package pl.tfkable.quality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;
	
	//@Autowired
	//PersistentTokenRepository persistenceTokenRepository;



	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.userDetailsService(userService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}




	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}


	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{

		
		
		//wyłączyć po uruchomieniu security
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		
		
		
		
		
		//http.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry());

		http.cors();

		http
		.authorizeRequests()

		//.antMatchers("/**").permitAll()//wylcz na produkcji
		//.antMatchers("/*").permitAll()

		.mvcMatchers("/importuj").permitAll()

		.mvcMatchers("/download/**").permitAll()
		.mvcMatchers("/pomoc").permitAll()
		.mvcMatchers("/css/**").permitAll()
		.mvcMatchers("/lib/**").permitAll()
		.mvcMatchers("/images/**").permitAll()
		.mvcMatchers("/js/**").permitAll()
		.mvcMatchers("/dist/**").permitAll()
		.mvcMatchers("/DataTables/**").permitAll()
		.mvcMatchers("/login").permitAll()
		.mvcMatchers("/forgot").permitAll()
		.mvcMatchers("/user/changePassword").permitAll()
		.mvcMatchers("/logout").permitAll()
		.anyRequest().authenticated()


		//		.anyRequest().hasAnyRole("ROLE_ADMIN",
		//				"ROLE_TWORZY_WNIOSEK",
		//				"ROLE_WIDZI_WNIOSEK",
		//				"ROLE_TWORZY_RAPORT",
		//				"ROLE_WIDZI_RAPORT",
		//				"ROLE_TWORZY_KOSZTY",
		//				"ROLE_WIDZI_KOSZTY",
		//				"ROLE_TWORZY_POSTEPOWANIE",
		//				"ROLE_WIDZI_POSTEPOWANIE")
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", true)
		.usernameParameter("usernameparam")
		.permitAll()
		.and()
		.logout()
		//.logoutUrl("/login")
		.logoutSuccessUrl("/login")
		//.deleteCookies("remember-me")
		.permitAll()

		//.and().exceptionHandling().authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login"))	
		.and().exceptionHandling().accessDeniedPage("/login")
		//.and().anonymous().disable();

		.and().cors()

		//.and().csrf().ignoringAntMatchers("/*")
		//			.disable()
		;








	}
}