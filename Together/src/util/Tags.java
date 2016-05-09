package util;

/**
 * Created by HDY on 2016/3/9.
 */
public class Tags {
	// jsp
    public static final String LOGIN_PATH = "/WEB-INF/view/login.jsp";
    public static final String WELCOME_PATH = "/WEB-INF/view/welcome.jsp";
    
    public static final String Main_PATH = "/WEB-INF/view/ViewProject.jsp";
    public static final String View_Project_PATH = "/WEB-INF/view/ViewProject.jsp";
    public static final String ErrorHandler_PATH = "/WEB-INF/view/ErrorHandler.jsp";
    // session
    public static final String SESSION_ID = "sessioin_id";
    public static final String VISIT_COUNT = "visit_count";
    
    // database
    public  final static String DATA_SOURCE_PREFIX = "java:comp/env/";
    public final static String DATA_SOURCE = "jndi/mybatis";
    public final static String USER_ID = "userid";
    public final static String USER_NAME = "username";
    public final static String PASSWORD = "password";
    public final static String USER = "user";
}
