package com.springcourse.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RequestSavedto {
	// Não pode estar vazio
	@NotBlank(message = "Obrigatorio informar subject")
	private String  subject;
	private String description;
	
	@NotNull(message = "Obrigatorio informar o owner")
	private User owner;
	private List<RequestStage> stages = new ArrayList<RequestStage>();

	public Request transformToRequest() {
		Request request = new Request(null, this.subject, this.description, null, null, this.owner, stages,null);
		return request;
	}
}
