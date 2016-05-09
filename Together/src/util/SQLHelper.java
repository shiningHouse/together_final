package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 * Created by HDY on 2016/3/6.
 */
public class SQLHelper {
    private DataSource pool; //
    private static SQLHelper instance;

    
    private SQLHelper() throws ServletException {

        try {
        	Context initCtx = new InitialContext();
        	pool  = (DataSource)initCtx.lookup("java:comp/env/jndi/mybatis");
            if (pool == null) {
            	System.out.println("连接数据库失败");
                throw new ServletException("Unknown DataSource: "+ Tags.DATA_SOURCE);
            }
        } catch (NamingException e) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // single model
    public static   SQLHelper getInstance() throws ServletException{
        if(instance==null){
        	
        	instance = new SQLHelper();
//            synchronized(SQLHelper.class) {
//                if(instance==null)
//                    instance = new SQLHelper();
//            }
        }
        return instance;
    }

    
    public interface Columns {
        final static String USER_ID                 = "userID";
        final static String PASSWORD                = "password";
        final static String USER_NAME               = "userName";
        final static String REALNAME                = "realname";
        final static String USERTYPE                = "user_type";
        final static String COURSE_ID               = "course_id";
        final static String COURSE_NAME             = "course_name";
        final static String COURSE_BEGIN            = "course_begin";
        final static String COURSE_END              = "course_end";
        final static String INTRO_TEXT              = "intro_text";
        final static String CLASS_ID                = "class_id";
        final static String CLASS_NAME              = "class_name";
        final static String TEACHER_ID              = "teacher_id";
        final static String STUDENT_ID              = "student_id";
        final static String TA                      = "ta";
        final static String HOMEWORK_ID             = "homework_id";
        final static String HOMEWORK_TITLE          = "homework_title";
        final static String HOMEWORK_DESCRIPTION    = "homework_description";
        final static String ATTACH_FILE             = "attach_file";
        final static String POST_DATE               = "post_date";
        final static String DDL                     = "ddl";
        final static String SUBMIT_DATE             = "submit_date";
        final static String SCORE                   = "score";
        final static String MAIL_FROM               = "mail_from";
        final static String MAIL_TO                 = "mail_to";
        final static String CONTENT                 = "content";
        final static String MAIL_DATE               = "mail_date";
        final static String HAS_READ                = "has_read";
    }
    
   public Connection connect() {
        Connection conn = null;
        /*
        String connectString = "jdbc:mysql://202.116.76.22:53306/13354195"
                + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";
                */
        String connectString = "jdbc:mysql://localhost:3306/together?characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectString, "root", "37213721");
            
            if(conn!=null)
            	System.out.println("Success login in the database!");
            return conn;
        } catch (Exception e) {
        	System.out.println("Failed login in the database!");
            System.out.println(e.getMessage());
        }
        return conn;
    }


   public ResultSet executeQuery(String sql) {
       System.out.println(sql);

       ResultSet rs = null;
       Connection conn;
       Statement stat;
       try {
           conn = connect();
           stat = conn.createStatement();
           rs = stat.executeQuery(sql);
       } catch (SQLException ex) {
           Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rs;
   }
   

    public ResultSet query(String sql) {
        ResultSet rs = null;
        Connection conn;
        Statement stat;
        try {
            // Get a connection from the pool
            conn = getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    
    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }




}
