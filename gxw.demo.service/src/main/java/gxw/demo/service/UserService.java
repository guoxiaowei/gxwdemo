package gxw.demo.service;

import gxw.demo.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	
	User getUser(Long id);

	Page<User> getUserPage(Pageable pageable);
	
	String getSMS();
}
