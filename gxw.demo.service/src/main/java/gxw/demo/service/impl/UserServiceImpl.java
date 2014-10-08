package gxw.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import ocean.config.message.MessageUtils;
import gxw.demo.biz.UserBiz;
import gxw.demo.domain.LineitemType;
import gxw.demo.domain.User;
import gxw.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserBiz userBiz;
	
	public User getUser(Long id) {
		return userBiz.getUser(id);
		//return new User(100, "wang");
	}
	
	public Page<User> getUserPage(Pageable pageable) {
    	List<User> content = new ArrayList<>();
    	User user = new User(1, "z");
    	user.setLineitemType(LineitemType.AUTOMOBILE_SERVICE_AGENT);
    	content.add(user);
		Page<User> userPage = new PageImpl<User>(content, pageable, 1);
    	
    	return userPage;
    }

	@Override
	public String getSMS() {
		return MessageUtils.getMessage("sms.commodity.shop.regist", "XX洗车店", "111111", "123456");
	}
}
