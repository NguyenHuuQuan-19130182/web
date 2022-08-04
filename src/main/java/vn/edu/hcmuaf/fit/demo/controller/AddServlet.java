package vn.edu.hcmuaf.fit.demo.controller;

import vn.edu.hcmuaf.fit.demo.beans.Cart;
import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.servive.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddServlet", value = "/Add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get product id from request
        String id = request.getParameter("id");
        Product product = ProductService.getInstance().getByID(id);
        if (product != null) {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = Cart.getInstance();
            }
            cart.put(product);
            session.setAttribute("cart", cart);
        }

        response.sendRedirect("/demo/Cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
