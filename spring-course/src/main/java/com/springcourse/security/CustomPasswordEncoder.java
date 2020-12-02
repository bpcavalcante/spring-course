package com.springcourse.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springcourse.service.util.HashUtil;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	// Este metodo codifica a senha
	@Override
	public String encode(CharSequence rawPassword) {
		String hash = HashUtil.getSecureMash(rawPassword.toString());
		return hash;
	}

	// Este metodo compara a senha entre um texto e uma senha ja codificada
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String hash = HashUtil.getSecureMash(rawPassword.toString());
		return hash.equals(encodedPassword);

	}

	
	
}
