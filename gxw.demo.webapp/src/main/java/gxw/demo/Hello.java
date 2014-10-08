package gxw.demo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer count = (Integer)session.getAttribute("count");
        if(count==null){
        	count =0;
        }
        count++;
        session.setAttribute("count",count);
        OutputStream out = resp.getOutputStream();
    	out.write("Hello world,count=".getBytes());
        
        out.write(Integer.valueOf(count).toString().getBytes());
        out.close();
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}