package com.springcourse.dto;

import javax.validation.constraints.NotNull;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RequestStageSavedto {
	
	
	private String description;
	
	@NotNull(message = "Obrigatório ter um state")
	private RequestState state;
	
	@NotNull(message = "Obrigatório ter um request")
	private Request request;
	
	@NotNull(message = "Obrigatório ter um usuário")
	private User owner;
	
	public RequestStage transformToRequestStage() {
		RequestStage stage = new RequestStage(null, description, null, state, request, owner);
		return stage;
	}

}
