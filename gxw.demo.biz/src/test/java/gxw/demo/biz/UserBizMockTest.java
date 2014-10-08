package gxw.demo.biz;

import static org.junit.Assert.assertEquals;
import gxw.demo.biz.UserBiz;
import gxw.demo.domain.User;
import gxw.demo.repository.mybatis.UserRepositoryMyBatis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/spring/*.xml")
@ActiveProfiles("dev")
public class UserBizMockTest {

	@InjectMocks
	@Autowired
	private UserBiz biz;

	@Mock
	private UserRepositoryMyBatis repository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		UserBiz biz = (UserBiz) unwrapProxy(this.biz);
	    ReflectionTestUtils.setField(biz, "repository", repository);
	}

	@Test
	public void test() {
		Mockito.when(this.repository.findById(1L)).thenReturn(new User(1L, "zhangh"));

		User user = biz.getUser(1L);
		assertEquals("zhangh", user.getName());
	}
	
	public static final Object unwrapProxy(Object bean) throws Exception {
	    /*
	     * If the given object is a proxy, set the return value as the object
	     * being proxied, otherwise return the given object.
	     */
	    if (AopUtils.isAopProxy(bean) && bean instanceof Advised) {
	        Advised advised = (Advised) bean;
	        bean = advised.getTargetSource().getTarget();
	    }
	    return bean;
	}
}
