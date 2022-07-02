package vn.edu.hcmuaf.fit.demo.servive;

import vn.edu.hcmuaf.fit.demo.beans.Cart;
import vn.edu.hcmuaf.fit.demo.beans.User;
import vn.edu.hcmuaf.fit.demo.dao.OrderDao;

public class OrderService {
    private  static  OrderService instance;
    private  OrderService(){

    }
    public static OrderService getInstance(){
        if(instance == null){
            instance = new OrderService();
        }
        return instance;
    }
    public boolean createOrder(User user, Cart cart){
        OrderDao orderDao = OrderDao.getInstance();
        return orderDao.create(user,cart);
    }
}
