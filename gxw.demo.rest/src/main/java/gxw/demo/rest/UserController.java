package gxw.demo.rest;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gxw.demo.biz.UserBiz;
import gxw.demo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/gxw")
public class UserController {
	//private static Logger log = LoggerFactory.getLogger(TestUserController.class);
	// private static Logger log =
	// LoggerFactory.getLogger(Controller.class);

	@Autowired
	private UserBiz biz;

	@RequestMapping(value = "/show.do", method = RequestMethod.GET)
	public String add(HttpServletRequest request,
			HttpServletResponse response) throws JsonProcessingException {
		Long id = Long.parseLong(request.getParameter("id"));
		Assert.notNull(id);
		System.out.println("show.do=id:" + id);
		User user= biz.findById(id);
		//return new ModelAndView("显示页面路径写在这里", "List",user );
		ObjectMapper mapper = new ObjectMapper();
		String Json =  mapper.writeValueAsString(user);
		return Json;
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public void edit(@RequestBody User user , Writer writer)
			throws IOException {
		System.out.println("json=" + user);
		biz.save(user);
		writer.write("succeed");
	}



	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") String id,@RequestBody User user , Writer writer)
			throws IOException {
		Assert.notNull(id);
		biz.update(user);
		writer.write("你id是" + id+",用户姓名为："+user.getName());

	}

	@RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
	public void del(@PathVariable("id") String id, Writer writer)
			throws IOException {
		Assert.notNull(id);
		Long lid = Long.parseLong(id);
		biz.deleteById(lid);
		writer.write("删除成功" + id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Page<User> getUserPage(
			@PageableDefault(page = 0, size = 10) Pageable pageable) {
		List<User> content = new ArrayList<>();
		User user = new User(1, "z");
		user.setBirthday(new Date());
		content.add(user);
		Page<User> userPage = new PageImpl<User>(content, pageable, 1);

		return userPage;
	}

}