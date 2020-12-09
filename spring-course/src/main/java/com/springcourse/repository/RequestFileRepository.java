package com.springcourse.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springcourse.domain.RequestFile;

public interface RequestFileRepository extends JpaRepository<RequestFile,Long> {
	
	public Page<RequestFile> findAllByRequestId(Long id, org.springframework.data.domain.Pageable pageable);

}
