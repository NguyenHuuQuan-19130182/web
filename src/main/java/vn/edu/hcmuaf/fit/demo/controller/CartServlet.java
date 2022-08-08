package vn.edu.hcmuaf.fit.demo.controller;

import vn.edu.hcmuaf.fit.demo.beans.Cart;
import vn.edu.hcmuaf.fit.demo.beans.Catelogy;
import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.dao.ProductDao;
import vn.edu.hcmuaf.fit.demo.servive.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/Cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get cart from session
        String txtSearch = request.getParameter("txt");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        List<Product> products = ProductService.getInstance().getAll();
        List<Catelogy> catelogies = ProductService.getInstance().getAllCategory();
        List<Product> lst =  ProductService.getInstance().searchByName(txtSearch);
        if(cart == null){
            cart = Cart.getInstance();
        }
        session.setAttribute("cart",cart); // add session cart
        request.setAttribute("cart",cart);
        request.setAttribute("products", products);
        request.setAttribute("category", lst);
        request.setAttribute("category", catelogies);

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
