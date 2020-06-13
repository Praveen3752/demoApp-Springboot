package com.example.project.Security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandler  implements AuthenticationEntryPoint, Serializable
{
	 @Override
	    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException 
	 	{
	        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		 	String ss = "error correct ga ne vachindi rooo";
	        response.setContentType("application/json");
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.getOutputStream().println("{ \"error\": \"" + ss + "\" }");

	    }
}
