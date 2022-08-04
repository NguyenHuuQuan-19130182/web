package vn.edu.hcmuaf.fit.demo.dao;


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

    public Product getLast() {
        String sql = "select top 1 * from products order by id desc";
        try {
            conn = new DBConnect().get().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)
                        , rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getDouble(10)
                        , rs.getDouble(11));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Product getByID(String id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select  * from  products where  id = ?").bind(0, id).mapToBean(Product.class).first();
        });
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "select top 1 * from products where [name] like ? ";
        try {
            conn = new DBConnect().get().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)
                        , rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getDouble(10)
                        , rs.getDouble(11)));
            }
        } catch (Exception e) {

        }
        return list;
    }
//    public Product getLast(){
//        return (Product) JDBIConnector.get().withHandle(handle -> {
//            return  handle.createQuery("select  top 1 * from products order by id desc").mapToBean(Product.class)
//                    .stream().collect(Collectors.toList());
//        });
//    }
//    public  List<Product> searchByName(String txtSearch){
//        return  (List<Product>)JDBIConnector.get().withHandle(handle -> {
//            return handle.createQuery("select  * from  products where  name like ? ")
//                    .bind(0, txtSearch).mapToBean(Product.class).first();
//        });
//    }
}
