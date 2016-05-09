package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Tags;

/**
 * Created by HDY on 2016/3/7.
 */
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	/*
    	HttpSession session = req.getSession(true); 
    	if(session.isNew()){
    		System.out.println("It is a new session!");
    		session.setAttribute(Tags.SESSION_ID, "8888");
    	}else{
    		System.out.println("The session id is "+session.getAttribute(Tags.SESSION_ID));
    	}
    	*/
    	/*---����cookie----*/ 	

    	
	    Cookie cookie = null;
		Cookie[] cookies = null;
	    // ��ȡ�������ص� Cookies ������
	    cookies = req.getCookies();
	    if( cookies != null ){
	         for (int i = 0; i < cookies.length; i++){
	            cookie = cookies[i];
	            System.out.println("���ƣ�" + cookie.getName( ) + "��");
	            System.out.println("ֵ��" + cookie.getValue( )+" <br/>");
	    		// ɾ��cookie
	    		cookie.setMaxAge(0);
	    		resp.addCookie(cookie);
	         }
	      }else{
	    	  System.out.println("δ�ҵ� Cookies");
	      }
    	
        req.getRequestDispatcher(Tags.WELCOME_PATH).forward(req,resp);
        //super.doGet(req, resp);
    }
}
