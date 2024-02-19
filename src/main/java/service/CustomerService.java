package service;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minitest_1","root","123456");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public List<Customer> showList() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement statement = getConnection().prepareStatement("select * from student;");
//        // tra ve thong tin
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            Customer customer = new Customer(id,name,email,address);
            customerList.add(customer);
        }
        return customerList;
    }
}
