package gxw.demo.rest;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/session")
public class SessionController {
	
	@RequestMapping(value = "/count", method = RequestMethod.POST)
	public void count(HttpSession session) throws IOException {
		Integer sum = (Integer) session.getAttribute("sum");
		if(sum == null) {
			session.setAttribute("sum", 0);
			System.out.println(0);
			return;
		}
		
		session.setAttribute("sum", sum + 1);
		System.out.println(sum + 1);
	}
	
	@RequestMapping(value = "/clearCount", method = RequestMethod.POST)
	public void clearCount(HttpSession session) throws Exception {
		session.invalidate();
	}
}
