package com.springcourse.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserLogindto {
	
	// Verificar se é um e-mail valido
	@Email(message = "E-mail invalido")
	private String email;
	
	//Verficar se a senha está vazia
	@NotBlank
	private String password;


}
