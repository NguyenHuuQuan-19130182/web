package vn.edu.hcmuaf.fit.demo.controller;

import vn.edu.hcmuaf.fit.demo.beans.Cart;
import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/Cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get cart from session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null){
            cart = Cart.getInstance();
        }
        session.setAttribute("cart",cart); // add session cart
        request.setAttribute("cart",cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
