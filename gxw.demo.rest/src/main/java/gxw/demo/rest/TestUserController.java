package gxw.demo.rest;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gxw.demo.biz.UserBiz;
import gxw.demo.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class TestUserController {  
  
	private static Logger log = LoggerFactory.getLogger(TestUserController.class);
	
	@Autowired
	private UserBiz biz;
	
    @RequestMapping(value="/index.do")  
    public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
    	String name = request.getParameter("name");
    	log.info(name + "访问了系统");
    	return new ModelAndView("index","name",name);
    }
    
    @RequestMapping(value="/index2.do")  
    public String index2(@RequestParam("name") String name, ModelMap model){
    	log.info(name + "访问了系统");
    	model.put("name", name);
    	return "index";
    }
    
    @RequestMapping(value = "/getName/{id}", method = RequestMethod.GET)  
    public void getName(@PathVariable("id") String id, Writer writer) throws IOException {  
      writer.write("你是zhangh，id是" + id);
    }
    
    @RequestMapping(value = "/say", method = RequestMethod.PUT)  
    public void say(@RequestBody String body, Writer writer) throws IOException {  
      writer.write("json是" + body);
    }
    
    @RequestMapping(value = "/echo", method = RequestMethod.POST)
    @ResponseBody
    public User echo(@RequestBody User user) throws IOException {  
      return biz.getUser(user.getId());
    }
}