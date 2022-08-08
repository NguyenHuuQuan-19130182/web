package vn.edu.hcmuaf.fit.demo.dao;


import vn.edu.hcmuaf.fit.demo.beans.Catelogy;
import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.db.DBConnect;
import vn.edu.hcmuaf.fit.demo.db.JDBIConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDao {
    private static ProductDao instance;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public ProductDao() {

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


    public List<Catelogy> getAllCategory() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select  * from catelogy").mapToBean(Catelogy.class).stream().collect(Collectors.toList());
        });
    }

    public List<Product> getProductByCID(String cid) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select  * from  products where idCa = ?").bind(0, cid).mapToBean(Product.class).list();
        });
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from products where name like ?";
        try {
            conn = new DBConnect().get().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1), rs.getInt(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getInt(8), rs.getString(9),
                        rs.getString(10), rs.getDouble(11), rs.getDouble(12)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
