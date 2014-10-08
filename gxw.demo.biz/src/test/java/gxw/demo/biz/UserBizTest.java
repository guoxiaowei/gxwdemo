package gxw.demo.biz;

import static org.junit.Assert.assertEquals;
import gxw.demo.biz.UserBiz;
import gxw.demo.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/*.xml")
@ActiveProfiles("dev")
public class UserBizTest {

	@Autowired
	private UserBiz biz;

	@Test
	public void testGetUser() {
		User user = biz.getUser(10L);
		assertEquals("zhang", user.getName());
	}
	
	@Test(expected=org.springframework.dao.DuplicateKeyException.class)
	public void testTransaction() {
		biz.testTransaction();
		 
	}
	
}
