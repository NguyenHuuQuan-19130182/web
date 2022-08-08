package vn.edu.hcmuaf.fit.demo;

import vn.edu.hcmuaf.fit.demo.servive.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        if(UserService.getInstance().register(username,password,confirm,email,name,address,phone)){
            response.sendRedirect("/demo/Login");
        }else{
            request.setAttribute("error", "Register fail");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
        }
    }
}
