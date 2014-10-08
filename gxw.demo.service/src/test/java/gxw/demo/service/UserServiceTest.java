package gxw.demo.service;

import static org.junit.Assert.assertEquals;
import gxw.demo.domain.User;
import gxw.demo.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/*.xml")
@ActiveProfiles("dev")
public class UserServiceTest {

	@Autowired
	private UserService service;

	@Test
	public void test1() {
		User user = service.getUser(12L);
		assertEquals("wang", user.getName());
	}

	@Test
	public void test2() {
		User user = service.getUser(12L);
		assertEquals("郭小伟", user.getName());
	}
	
	@Test
	public void testGetSMS() {
		assertEquals("XX洗车店，您好。贵司在联创车盟乐驾平台的帐户已经开通，用户名为：111111 ，密码为：123456。请及时登录以下网址修改默认密码：http://hcm.aalejia.com。", service.getSMS());
	}
}
