package vn.edu.hcmuaf.fit.demo.beans;

import vn.edu.hcmuaf.fit.demo.dao.ProductDao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<String, Product> productList;

    public Cart() {
        productList = new HashMap<>();
    }

    public static Cart getInstance() {
       return new Cart();
    }

    // put product from cart
    public void put(Product product) {
        if (productList.containsKey(product.getId())) {
            upQuantity(product.getId());
        } else {
            product.setQuantitySold(1);
            productList.put(product.getId(), product);
        }

    }

    private void upQuantity(String id) {
        Product product = productList.get(id);
        product.setQuantitySold(product.getQuantity());
    }

    // update quantity of product by id
    public void updateQuantity(String id, int quantity) {
        Product product = productList.get(id);
        product.setQuantitySold(quantity);
    }

    // get product from cart by id
    public Product get(String id) {
        return productList.get(id);

    }

    // remove product from cart by id
    public Product remove(String id) {

        return productList.remove(id);
    }

    //  get total price of cart
    public int getTotal() {
        int totalPrice = 0;
        for (Product product : productList.values()) {
            totalPrice += product.getTotalMoney();
        }
        return totalPrice;
    }

    //  get total quantity of cart
    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Product product : productList.values()) {
            totalQuantity += product.getQuantitySold();
        }
        return totalQuantity;
    }

    // get list of product
    public Collection<Product> getProductList() {
        return productList.values();
    }

    public int updateQuantitySold(String id, int quantity) {
        Product product = productList.get(id);
        if(quantity < 1 || quantity > product.getQuantity()){
            return product.getQuantitySold();
        }
        product.setQuantitySold(quantity);
        return product.getQuantitySold();
    }
    public  int getTotalOrder(){
        int total = 0;
        for (Product product : productList.values()){
            total++;
        }
        return total;
    }
}


