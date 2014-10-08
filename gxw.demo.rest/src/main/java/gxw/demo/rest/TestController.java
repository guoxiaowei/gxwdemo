package gxw.demo.rest;

import java.io.IOException;

import gxw.demo.domain.User;
import gxw.demo.exception.DemoException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "test", description = "测试接口")
@RestController
public class TestController {

	@ApiOperation(value = "打印", notes = "打印")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "打印成功"),
			@ApiResponse(code = 400, message = "{code=3010402, message='打印失败'}") })
	@RequestMapping(value = "/echo", method = RequestMethod.POST)
	public User echo(@RequestBody User user) throws IOException {
		return user;
	}

	@RequestMapping(value = "/array", method = RequestMethod.POST)
	public User useArray(@RequestParam("status") String[] status)
			throws IOException {
		System.out.println(status);

		return null;
	}
	
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public void testException(@RequestParam("name") String name) throws Exception {
		throw new DemoException("出错了");
	}
}
