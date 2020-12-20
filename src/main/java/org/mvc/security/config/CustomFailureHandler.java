package org.mvc.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,AuthenticationException exception) throws IOException, ServletException {
		request.getSession().setAttribute("loginFailure", "Username or Password Invalid");
		getRedirectStrategy().sendRedirect(request, response, "/spring-mvc/login.html?error=true");
	}
}
