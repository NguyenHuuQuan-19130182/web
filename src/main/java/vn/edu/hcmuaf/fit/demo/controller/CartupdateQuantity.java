package vn.edu.hcmuaf.fit.demo.controller;

import com.google.gson.Gson;
import vn.edu.hcmuaf.fit.demo.beans.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Cart-updateQuantity", value = "/cart-updateQuantity")
public class CartupdateQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart.get(id) == null) {
            response.setStatus(404);
            return;
        }
        int quantity = cart.get(id).getQuantitySold();
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
            response.getWriter().println(new Gson().toJson(Map.of("quantity",quantity)));
        }

        int quantityAfterUpdate = cart.updateQuantitySold(id, quantity);
        session.setAttribute("cart", cart);
        response.getWriter().println(new Gson().toJson(Map.of("quantity",quantity)));

    }
}
