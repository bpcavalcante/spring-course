package com.springcourse.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSavedto {
	@NotBlank(message = "Obrigatório informar o nome")
	private String name;
	
	@Email(message = "Informe um e-mail válido")
	private String email;
	
	@Size(min = 7, max = 99, message = "Senha deve ser entre 7 a 99 caracteres")
	private String password;
	
	@NotNull(message = "Obrigatório informar um role")
	private Role role;
	
	private List<Request> requests = new ArrayList<Request>();
	private List<RequestStage> stages = new ArrayList<RequestStage>();

	// Criando um metodo para transformar a classe em um user
		public User transformToUser() {
			User user = new User(null, this.name, this.email, this.password, this.role, this.requests, this.stages);
			return user;
		}
}
