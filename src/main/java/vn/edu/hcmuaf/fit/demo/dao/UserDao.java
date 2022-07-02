package vn.edu.hcmuaf.fit.demo.dao;

import vn.edu.hcmuaf.fit.demo.beans.User;
import vn.edu.hcmuaf.fit.demo.db.DBConnect;
import vn.edu.hcmuaf.fit.demo.db.JDBIConnector;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {
    private static UserDao instance;

    private UserDao() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public User checkLogin(String username, String password) {
        List<User> users = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select  * from user where  username = ?")
                        .bind(0, username)
                        .mapToBean(User.class).stream().collect(Collectors.toList())
        );
        if (users.size() != 1) return null;
        User user = users.get(0);
        if (!user.getPassword().equals(hashPassword(password)) || !user.getUsername().equals(username))
            return null;
        return user;
    }

    public boolean register(String username, String email, String password, String address, String phone) {
        int i = JDBIConnector.get().withHandle(handle ->
                handle.createUpdate("insert into user(username,password) values (?,?)").bind(0, username).bind(1, hashPassword(password)).execute()
        );
        return i == 1;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest sha256 = null;
            sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(password.getBytes());
            BigInteger number = new BigInteger(1, hash);
            return number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
