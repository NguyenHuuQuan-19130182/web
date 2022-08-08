package vn.edu.hcmuaf.fit.demo.controller;

import vn.edu.hcmuaf.fit.demo.beans.Cart;
import vn.edu.hcmuaf.fit.demo.beans.User;
import vn.edu.hcmuaf.fit.demo.servive.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckOutServlet", value = "/CheckOut")
public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      if(session.getAttribute("auth") == null){
          response.sendRedirect("/demo/Login");
          return;
      }
      if(session.getAttribute("cart") == null){
          response.sendRedirect("/demo/Cart");
          return;
      }
      boolean result = OrderService.getInstance().createOrder((User) session.getAttribute("auth"),(Cart) session.getAttribute("cart"));
      session.removeAttribute("cart");
      if(result){
          response.sendRedirect("/demo/shop");
      }else {
          response.sendRedirect("/demo/cart.jsp");
      }
    }
}
