package com.divya.spring.security;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//get username and password and it is default in this method
		String userName=authentication.getName();
		String password=authentication.getCredentials().toString();
		
		
		if("aara".equals(userName) && "amuthan".equals(password))
		{
			return new UsernamePasswordAuthenticationToken(userName, password,Arrays.asList());
			
		}
		else
		{
			throw new BadCredentialsException("Invalid Username/Password");
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
