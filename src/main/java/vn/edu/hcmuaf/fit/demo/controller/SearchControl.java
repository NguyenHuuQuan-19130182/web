package vn.edu.hcmuaf.fit.demo.controller;

import vn.edu.hcmuaf.fit.demo.beans.Product;
import vn.edu.hcmuaf.fit.demo.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchControl", value = "/Search")
public class SearchControl extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String txtSearch = request.getParameter("txt");

        ProductDao productDao = new ProductDao();
        List<Product> lst =  productDao.searchByName(txtSearch);


        request.setAttribute("products", lst);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
