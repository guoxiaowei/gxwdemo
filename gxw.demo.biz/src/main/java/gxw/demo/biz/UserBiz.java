package gxw.demo.biz;

import gxw.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface UserBiz {
	
	User getUser(Long id);
	void save(User user);
	void update(User user);
	void deleteById(Long id);
	void testTransaction();
	User findById(Long id);
	
	Page<User> findUser(Pageable pageable);
}
