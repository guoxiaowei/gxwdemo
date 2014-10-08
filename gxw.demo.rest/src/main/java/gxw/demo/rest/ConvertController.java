package gxw.demo.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gxw.demo.domain.LineitemType;
import gxw.demo.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {

    @RequestMapping(value = "/users/{id}/setBirthday", method = RequestMethod.PUT)
    public User getUser(@PathVariable("id") Long id, 
    		@RequestParam(value="birthday",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date birthday) {
    	User user = new User(id, "zhangh", birthday);
    	return user;
    }
    
    @RequestMapping(value = "/users/{id}/setEnum", method = RequestMethod.PUT)
    public User getUser(@PathVariable("id") Long id, 
    		@RequestParam(value="lineitemType") LineitemType lineitemType) {
    	User user = new User(id, "zhangh");
    	user.setLineitemType(lineitemType);
    	return user;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
    	return user;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<User> getUserPage(@PageableDefault(page=0,size=10) Pageable pageable) {
    	List<User> content = new ArrayList<>();
    	User user = new User(1, "z");
    	user.setBirthday(new Date());
    	content.add(user);
		Page<User> userPage = new PageImpl<User>(content, pageable, 1);
    	
    	return userPage;
    }
}
