package com.springcourse.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springcourse.domain.User;
import com.springcourse.exception.NotFoundException;
import com.springcourse.model.PageModel;
import com.springcourse.model.PageRequestModel;
import com.springcourse.repository.UserRepository;
import com.springcourse.service.util.HashUtil;
import com.springcourse.specification.UserSpecification;

@Service
public class UserService implements UserDetailsService {

	@Autowired private UserRepository userRepository;
	
	
	public User save(User user) {
		
		String hash = HashUtil.getSecureMash(user.getPassword());
		user.setPassword(hash);
		
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}
	
	
	public User update(User user) {
		String hash = HashUtil.getSecureMash(user.getPassword());
		user.setPassword(hash);
		
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		
		// Verificar se tem um user com  id informado caso não tenha exibir a mensagem
		return result.orElseThrow(() -> new NotFoundException("Este id do usuário não existe = " + id));
	}
	
	
	public List<User> listAll(){
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public PageModel<User> listAllOnLazyMode( PageRequestModel pr){
		org.springframework.data.domain.Pageable pageable = pr.toSpringPageRequest();
		
		Specification<User> spec = UserSpecification.search(pr.getSearch());
		
		Page<User> page = userRepository.findAll(spec, pageable);
		
		PageModel<User> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
		return pm;
	}

	
	public User login(String email,String password) {
		password = HashUtil.getSecureMash(password);
		
		
		Optional<User> result = userRepository.login(email, password);
		return result.get();
	}
	
	public int updateRole(User user) {
		return userRepository.updateRole(user.getId(), user.getRole());
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> result = userRepository.findByEmail(username);
		
		if(!result.isPresent()) {
			throw new UsernameNotFoundException("Não existe o usuário com o email" + username);
		}
		
		User user = result.get();
		
		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE " +  user.getRole().name()));
		
		org.springframework.security.core.userdetails.User userSpring = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
		
		return userSpring;
	}
		
}
