package gxw.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gxw.demo.domain.User;
import gxw.demo.repository.mybatis.UserRepositoryMyBatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/*.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
						 DbUnitTestExecutionListener.class })
@ActiveProfiles("dev")
public class UserRepositoryMyBatisTest {

	/*@Autowired
	private UserRepositoryMyBatis repository;*/
	
	/*@Autowired
	@Qualifier("userCache")
	private Cache userCache;*/
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	@DatabaseSetup(type=DatabaseOperation.INSERT,value="/dataset/user/findById.xml")
	@DatabaseTearDown(type=DatabaseOperation.DELETE,value="/dataset/user/findById.xml")
	public void testFindById() throws Exception {
		System.out.println(((UserRepositoryMyBatis)context.getBean("userRepositoryMyBatis")).findById(2L).getName());
		/*User user = repository.findById(2L);
		
		assertNotNull(user);
		assertEquals("管理员", user.getName());
		
		assertNotNull(userCache);*/
	}
/*
	@Test
	@DatabaseTearDown(type=DatabaseOperation.DELETE,value="/dataset/user/save.xml")
	@ExpectedDatabase(query="select * from ZH_USER where id=10",table="ZH_USER",value="/dataset/user/save.xml")
	public void testSave() throws Exception {
		repository.save(new User(10,"wang"));
	}
	
	@Test
	@DatabaseSetup(type=DatabaseOperation.INSERT,value="/dataset/user/updateBefore.xml")
	@DatabaseTearDown(type=DatabaseOperation.DELETE,value="/dataset/user/update.xml")
	@ExpectedDatabase(query="select * from ZH_USER where id=2",table="ZH_USER",value="/dataset/user/update.xml")
	public void testUpdate() throws Exception {
		repository.update(new User(2,"王"));
	}
	
	@Test
	@DatabaseSetup(type=DatabaseOperation.INSERT,value="/dataset/user/deleteBefore.xml")
	@ExpectedDatabase(query="select * from ZH_USER where id=2",table="ZH_USER",value="/dataset/user/delete.xml")
	public void testDeleteById() throws Exception {
		repository.deleteById(2L);
	}*/
}
