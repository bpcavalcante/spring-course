package com.springcourse.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdatedto {
	@NotBlank(message = "Obrigatório informar o nome")
	private String name;
	
	@Email(message = "Informe um e-mail válido")
	private String email;
	
	@Size(min = 7, max = 99, message = "Senha deve ser entre 7 a 99 caracteres")
	private String password;
	
	private List<Request> requests = new ArrayList<Request>();
	private List<RequestStage> stages = new ArrayList<RequestStage>();

	// Criando um metodo para transformar a classe em um user
	public User transformToUser() {
		User user = new User(null, this.name, this.email, this.password, null, this.requests, this.stages);
		return user;
	}
}
