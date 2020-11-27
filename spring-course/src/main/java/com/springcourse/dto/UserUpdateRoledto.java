package com.springcourse.dto;

import javax.validation.constraints.NotNull;

import com.springcourse.domain.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateRoledto {
	// Informando que deve ser obrigatorio preencher e personalizando a mensagem de erro
	@NotNull(message = "Obrigatorio informar um role")
	private Role role;
	

}
