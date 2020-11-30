package com.springcourse.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RequestUpdatedto {
	// Não pode estar vazio
		@NotBlank(message = "Obrigatorio informar o subject")
		private String  subject;
		private String description;
		
		@NotNull(message = "Obrigatorio informar o state")
		private RequestState state;
		
		@NotNull(message = "Obrigatorio informar o owner")
		private User owner;
		private List<RequestStage> stages = new ArrayList<RequestStage>();

		public Request transformToRequest() {
			Request request = new Request(null, this.subject, this.description, null, this.state, this.owner, stages);
			return request;
		}
	
}