package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import net.sf.json.JSONObject;
import util.SQLHelper;
import util.Tags;

public class AjaxLoginServlet extends HttpServlet{
	SQLHelper helper;
	
	@Override
	public void init() throws ServletException {
		helper = SQLHelper.getInstance();
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		resp.setContentType("text/html"); 
        System.out.println("Ajax Post Method!");
        
        PrintWriter writer = resp.getWriter();
        
        /*----------Session Part----------------*/
//        // 如果不存在session会话，则创建一个session对象
//        HttpSession session = req.getSession(true); 
//        // 获取session创建时间
//        Date createTime = new Date(session.getCreationTime());
//        // 获取该网页的最后一次访问时间
//        Date lastAccessionTime = new Date(session.getLastAccessedTime());
//        Integer visitCount = new Integer(0);
//     
//        // 检查网页是否有新的访问者
//        if(session.isNew()){
//        	session.setAttribute(Tags.SESSION_ID, 123456);
//        }else{
//        	visitCount = (Integer)session.getAttribute(Tags.VISIT_COUNT);
//        	System.out.println("Session id is "+session.getAttribute(Tags.SESSION_ID));
//        }
//        session.setAttribute(Tags.VISIT_COUNT,visitCount);  // 设置count
        
        
        
        User user = new User();
        String username = req.getParameter(Tags.USER_NAME);
        String password = req.getParameter(Tags.PASSWORD);
        user.setUserName(username);
        user.setPassword(password);     

        System.out.println("userName="+username);
        System.out.println("password="+password);
        MyResponse myResponse = new MyResponse();

        if(user.getUserName() !=null ){
            //session.setAttribute(Tags.USER,user);
       
            try {

                String sql = String.format("SELECT * FROM user WHERE userName = \"%s\" and password=\"%s\";",
                        username,
                        password);
       
                
                ResultSet result = helper.query(sql);

                if(result.next()){ 
                    myResponse.setMessage("login in successfully!");
                    myResponse.setState("200");
                    /*------- Add the cookie------*/
                    Cookie cookie = setCookie(username);
                    Cookie cookie2 = new Cookie("TestCookie","IamHere");
                    resp.addCookie(cookie);
                    resp.addCookie(cookie2);
            		System.out.println("Set the user name in cookie: " + username);
                }else{
                    myResponse.setState("0");
                }
//                preparedStatement.close();     

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            myResponse.setState("0");
            myResponse.setMessage("username or password is wrong!");
        }

        JSONObject jsonObject = JSONObject.fromObject(myResponse);
        writer.write(jsonObject.toString());
        
	}

	// set the cookie in the response
	private Cookie setCookie(String username) {
		Cookie cookie = new Cookie("username", username);

		cookie.setMaxAge(60);   // cookie life time is 15 minutes
		//cookie.setPath("/");
		cookie.setDomain("http://localhost:8080/Together");
		return cookie;
	}
	



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}



}
