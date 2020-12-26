package org.mvc.security.config;

import java.util.List;
import java.util.Map;

import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserDetailsService userDetailsService;
	@Autowired
	public UserService userService;
	@Autowired
	private CustomFailureHandler customeFailureHandler;
	@Autowired
	private CustomSuccessHandler customSuccessHandler;
    private Map<String,List<String>> viewPermissions;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("------configureGlobal-----------");
        auth.authenticationProvider(customeAuthenticationProvider());
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    	viewPermissions = userService.getRoleAndUrlAddressMap();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry interceptUrlRegistry = http.
        		csrf().
        		disable().
        		authorizeRequests().
        		antMatchers("/login.html").permitAll();
        
        for (Map.Entry<String, List<String>> entry: viewPermissions.entrySet()) {
        	for(String url : entry.getValue())
            interceptUrlRegistry.antMatchers(url).hasAuthority(entry.getKey());
        }
        interceptUrlRegistry
        .and()
        .formLogin().loginPage("/login.html").loginProcessingUrl("/perform-login.html")
        .successHandler(customSuccessHandler)
        .failureUrl("/login.html?error=true").failureHandler(customeFailureHandler)
        .and()
        .logout().logoutUrl("/logout.html")
        .deleteCookies("JSESSIONID");
    		       
    		        
    	/*  http
          .csrf().disable()
          .authorizeRequests().antMatchers("/login.html").permitAll()
          .and()
          .authorizeRequests().antMatchers("/*").authenticated()
          .and()
          .formLogin().loginPage("/login.html").loginProcessingUrl("/perform-login.html")
          .successHandler(customSuccessHandler)
          .failureUrl("/login.html?error=true").failureHandler(customeFailureHandler)
          .and()
          .logout().logoutUrl("/logout.html")
          .deleteCookies("JSESSIONID"); */
    }
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public CustomProvider customeAuthenticationProvider(){System.out.println("provider");
        CustomProvider authProvider = new CustomProvider();
    	authProvider.setUserDetailsService(userDetailsService);
    	authProvider.setPasswordEncoder(passwordEncoder());
    	return authProvider;
    }
}
