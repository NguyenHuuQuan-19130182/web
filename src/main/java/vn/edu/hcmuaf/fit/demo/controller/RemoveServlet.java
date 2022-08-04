package vn.edu.hcmuaf.fit.demo.controller;

import vn.edu.hcmuaf.fit.demo.beans.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveServlet", value = "/Remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.get(id) == null){
            response.setStatus(404);
            return;
        }
        cart.remove(id);
        session.setAttribute("cart",cart);

    }
}
