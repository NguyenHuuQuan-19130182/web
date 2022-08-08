package vn.edu.hcmuaf.fit.demo.servive;

import vn.edu.hcmuaf.fit.demo.beans.Catelogy;
import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.dao.ProductDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private static ProductService instance;

    private ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public List<Product> getAll() {
        return ProductDao.getInstance().getAll();
    }

    public Product getByID(String id) {
        return ProductDao.getInstance().getByID(id);
    }

    public List<Catelogy> getAllCategory(){
        return ProductDao.getInstance().getAllCategory();
    }

    public List<Product> getProductByCID(String cid){
        return ProductDao.getInstance().getProductByCID(cid);
    }

    public List<Product> searchByName(String txtSearch) {
        return  ProductDao.getInstance().searchByName(txtSearch);
    }
}
