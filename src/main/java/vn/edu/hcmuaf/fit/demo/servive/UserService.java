package vn.edu.hcmuaf.fit.demo.servive;

import vn.edu.hcmuaf.fit.demo.beans.User;
import vn.edu.hcmuaf.fit.demo.dao.UserDao;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private static UserService instance;
    private static Map<String, String> user = new HashMap<>();

    static {
        user.put("admin", "123");

    }

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    //    public boolean checkLogin(String username, String password) {
////    return user.containsKey(username) && user.get(username).equals(password);
//      return UserDao.getInstance().checkLogin(username, password);
//    }
    public User checkLogin(String username, String password) {
        return UserDao.getInstance().checkLogin(username, password);
    }

    public boolean register(String username, String password, String confirm, String email,String name, String address, String phone) {
        // check register
        if (!password.equals(confirm))
            return false;
        return UserDao.getInstance().register(username, email, name, password, address, phone);
    }
}
