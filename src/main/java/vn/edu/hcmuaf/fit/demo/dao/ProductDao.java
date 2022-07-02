package vn.edu.hcmuaf.fit.demo.dao;


import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDao {
    private static ProductDao instance;

    private ProductDao() {

    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    public List<Product> getAll() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from products").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }
    public Product getByID(String id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select  * from  products where  id = ?").bind(0, id).mapToBean(Product.class).first();
        });
    }
}
