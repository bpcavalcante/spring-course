package com.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springcourse.domain.RequestFile;
import com.springcourse.model.PageModel;
import com.springcourse.model.PageRequestModel;
import com.springcourse.repository.RequestFileRepository;

@Service
public class RequestFileService {

	@Autowired
	private RequestFileRepository fileRepository;
	
	// upload 
	
	// listar os ficheiros dado o id do pedido
	public PageModel<RequestFile> listAllByRequestId(Long requestId, PageRequestModel prm){
		Pageable pageable = PageRequest.of(prm.getPage(), prm.getSize());
		

	}
}
