package vn.edu.hcmuaf.fit.demo;

import vn.edu.hcmuaf.fit.demo.beans.User;
import vn.edu.hcmuaf.fit.demo.servive.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserService.getInstance().checkLogin(username, password);

        if (user != null) {
            // set session
            HttpSession session = request.getSession();
            session.setAttribute("auth", user);
            response.sendRedirect("/demo/home");
        } else {
            request.setAttribute("error", "Username or password is incorrect");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
}
