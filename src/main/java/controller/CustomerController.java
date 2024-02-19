package controller;

import model.Customer;
import service.CustomerService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "")

public class CustomerController extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = "";
        try {
            findAllCustomer(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void findAllCustomer (HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/list.jsp");
        List<Customer> customerList = customerService.showList();
        req.setAttribute("list",customerList);
        dispatcher.forward(req,resp);

    }
}
