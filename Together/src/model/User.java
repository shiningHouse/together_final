package model;

import java.sql.ResultSet;

import javax.servlet.ServletException;

import util.SQLHelper;

/**
 * Created by HDY on 2016/3/6.
 */
public class User {
    private String userName;
    private String password;
    private String userID;

    public User()
    {
    }

    public User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }
    public User(String userName,String password,String userID)
    {
        this.userName = userName;
        this.password = password;
        this.userID = userID;
    }

    
    
    /*
    public static User validate(String userid, String password) throws ServletException {
        SQLHelper helper = SQLHelper.getInstance();
        String selection = SQLHelper.Columns.USER_ID + "=? ";
        String[] selectionArgs = {userid};
        ResultSet rs = helper.query(SQLHelper.TABLE_USER_WEB, null, selection, selectionArgs, null);
        User user = null;
        if (rs != null) {
            try {
                if (rs.next()) {
                    if (password.equals(rs.getString(SQLHelper.Columns.PASSWORD))) {
                        user = new User(
                                SQLHelper.Columns.USER_ID,
                                rs.getString(SQLHelper.Columns.REALNAME),
                                rs.getInt(SQLHelper.Columns.USERTYPE)
                        );
                        switch (user.getUser_type()) {
                            case User.USERTYPE_ADMINISTRATOR: user = new Admin(user); break;
                            case User.USERTYPE_TEACHER: user = new Teacher(user); break;
                            case User.USERTYPE_STUDENT: user = new Student(user); break;
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    helper.closeResultSet(rs);
                } catch (SQLException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return user;
    }
    */
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
