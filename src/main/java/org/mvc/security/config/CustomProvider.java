package org.mvc.security.config;

import org.mvc.security.util.Utililty;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomProvider extends DaoAuthenticationProvider{
	
 	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication){
 		System.out.println("------CustomProvider-----------");
 		checkPassword(userDetails, authentication);
 	}
 	
	@SuppressWarnings("deprecation")
	private void checkPassword(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) {
		if (authentication.getCredentials() == null) {
			throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), (Throwable) userDetails);
		}
		String presentedPassword = authentication.getCredentials().toString();
		String userPassword = userDetails.getPassword();
		if(!Utililty.passwordEncoder().matches(presentedPassword, userPassword)){
			throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), (Throwable) userDetails);
		}
	}
}
