package gxw.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath*:/META-INF/spring/*.xml","classpath*:/META-INF/springWeb/*.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecurityControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
    
    @Test
    public void test01checkPrincipalExistTest() throws Exception {
        mockMvc.perform((get("/security/checkPrincipalExist.do"))).andExpect(status().isOk()).andDo(print());
    }
    
    @Test
    public void test02registerTest() throws Exception {
        mockMvc.perform((get("/security/register.do"))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void test03loginTest() throws Exception {
        mockMvc.perform((get("/security/login.do"))).andExpect(status().isOk()).andDo(print());
    }
    
    @Test
    public void test04getUserIDTest() throws Exception {
        mockMvc.perform((get("/security/getUserID.do"))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void test05logoutTest() throws Exception {
        mockMvc.perform((get("/security/logout.do"))).andExpect(status().isOk()).andDo(print());
    }
    
    @Test
    public void test06genSmsCodeForLogin() throws Exception {
        mockMvc.perform((get("/security/genSmsCodeForLogin.do"))).andExpect(status().isOk()).andDo(print());
    }
    
    @Test
    public void test07checkSmsCodeForLogin() throws Exception {
        mockMvc.perform((get("/security/checkSmsCodeForLogin.do"))).andExpect(status().isOk()).andDo(print());
    }
    
    @Test
    public void test08modifyPassword() throws Exception {
        mockMvc.perform((get("/security/modifyPassword.do"))).andExpect(status().isOk()).andDo(print());
    }

}
