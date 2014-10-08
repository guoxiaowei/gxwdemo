package gxw.demo.repository.mybatis;

import gxw.demo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMyBatis {
	
	//@Cacheable(value="gxw.demo.user",key="#p0.toString()")
	User findById(Long id);
	
	//@Cacheable(value="gxw.demo.user",key="#p0.id.toString()")
	void save(User user);
	
	//@CacheEvict(value="gxw.demo.user",key="#p0.id.toString()")
	void update(User user);
	
	//@CacheEvict(value="gxw.demo.user",key="#p0.toString()")
	void deleteById(Long id);
}
