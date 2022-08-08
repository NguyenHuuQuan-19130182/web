package vn.edu.hcmuaf.fit.demo.dao;

import org.jdbi.v3.core.result.ResultBearing;
import vn.edu.hcmuaf.fit.demo.beans.Cart;
import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.beans.User;
import vn.edu.hcmuaf.fit.demo.db.JDBIConnector;

public class OrderDao {
    private static OrderDao instance;

    private OrderDao() {

    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public boolean create(User user, Cart cart) {
        int orderId = JDBIConnector.get().withHandle(handle -> {
            ResultBearing resultBearing = handle.createUpdate("insert into orders (user_id, status) values (?, ?)")
                    .bind(0, user.getUsername())
                    .bind(1, 0)
                    .executeAndReturnGeneratedKeys();
            return resultBearing.mapTo(Integer.class).findFirst().get();
        });
        int total = JDBIConnector.get().withHandle(handle -> {
            int sum = 0;
            for (Product product : cart.getProductList()) {
                sum += handle.createUpdate("insert into details (order_id, product_id, price, quantity, note) values (?, ?, ?, ?, ?)")
                        .bind(0, orderId)
                        .bind(1, product.getId())
                        .bind(2, product.getPrice())
                        .bind(3, product.getQuantitySold())
                        .bind(4, "").execute();
            }
            return sum;
        });
        return total == cart.getProductList().size();
    }
}
