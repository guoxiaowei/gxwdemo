package gxw.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Calendar;
import java.util.Date;

import gxw.demo.domain.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/META-INF/spring/*.xml","classpath*:/META-INF/springWeb/*.xml"})
@ActiveProfiles("dev")
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		System.out.println("测试="+wac.getAutowireCapableBeanFactory());
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	/*@Test
	public void select() throws Exception {
		mockMvc.perform((get("/gxw/show.do?id=10"))).andExpect(status().isOk()).andDo(print());
	}*/
	@Test
	public void add() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		User user=new User(12l,"郭小伟",new Date());
		String Json =  mapper.writeValueAsString(user);
		mockMvc.perform(post("/gxw/add.do").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON).content(Json.getBytes())).andExpect(status().isOk()).andDo(print());
	}
	/*@Test
	public void update() throws Exception {
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis()-2*24*60*60*1000;
		ObjectMapper mapper = new ObjectMapper();
		User user=new User(12l,"郭大小伟",new Date(time));
		String Json =  mapper.writeValueAsString(user);
		mockMvc.perform(put("/gxw/update/12").characterEncoding("UTF-8").contentType(MediaType.APPLICATION_JSON).content(Json.getBytes())).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}*/
	/*@Test
	public void del() throws Exception {
		
		mockMvc.perform(delete("/gxw/del/10")).andExpect(status().isOk()).andDo(print());
	}*/
}
