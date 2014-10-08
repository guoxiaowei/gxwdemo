package gxw.demo.biz.impl;

import java.util.Calendar;
import java.util.Date;

import gxw.demo.biz.UserBiz;
import gxw.demo.domain.User;
import gxw.demo.repository.mybatis.PageRepositoryMyBatis;
import gxw.demo.repository.mybatis.UserRepositoryMyBatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserBizImpl implements UserBiz {


	@Autowired
	private UserRepositoryMyBatis repositoryMyBatis;
	
	@Autowired
	private PageRepositoryMyBatis pageRepositoryMyBatis;
	
	@Override
	@Cacheable(value="gxw.demo.user",key="#p0.toString()")
	public User getUser(Long id) {
		Assert.notNull(id, "用户id不能为空");
		System.out.println("id="+id);
		System.out.println("未用cache="+id);
		
		return repositoryMyBatis.findById(id);
	}

	@Override
	public void testTransaction() {
		Calendar cal=Calendar.getInstance();

		Date date=cal.getTime();
		repositoryMyBatis.save(new User(10, "zhang",date));
		repositoryMyBatis.save(new User(11,"12345678901234567890",new Date()));
	}

	@Override
	public Page<User> findUser(Pageable pageable) {
		return pageRepositoryMyBatis.findUser(pageable);
	}

	@Override
	@CacheEvict(value="gxw.demo.user",key="#p0.id.toString()")
	public void save(User user) {
		System.out.println("未用cache="+user);
		repositoryMyBatis.save(user);
		
	}

	@Override
	@CacheEvict(value="gxw.demo.user",key="#p0.id.toString()")
	public void update(User user) {
		repositoryMyBatis.update(user);
		
	}

	@Override
	@CacheEvict(value="gxw.demo.user",key="#p0.toString()")
	public void deleteById(Long id) {
	 repositoryMyBatis.deleteById(id);
		
	}

	@Override
	@Cacheable(value="gxw.demo.user",key="#p0.toString()")
	public User findById(Long id) {
		System.out.println("未用cache="+id);
	 return repositoryMyBatis.findById(id);
	}

}
