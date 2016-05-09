package control;

import ajax.MyResponse;
import model.User;
import net.sf.json.JSONObject;
import util.SQLHelper;
import util.Tags;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.jfxmedia.logging.Logger;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    SQLHelper helper;

    @Override
    public void init() throws ServletException {
        helper = SQLHelper.getInstance();
        if(helper==null){
        	System.out.println("获取数据库失败");
        }else{
        	System.out.println("获取数据库成功");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.println("LoginServlet Get Method!");
    		Logger.logMsg(0, "LoginServlet", "GetMethod", null);
    		req.getRequestDispatcher(Tags.LOGIN_PATH).forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		doGet(req, resp);

    }
}
