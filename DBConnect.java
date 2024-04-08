import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBConnect")
public class DBConnect extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Database connection parameters
        String hostname = "database-1.clg0y6oqkpd2.ap-south-1.rds.amazonaws.com";
        String databaseName = "cdd";
        String dbUsername = "admin";
        String dbPassword = "Sumeddha2004";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            String url = "jdbc:mysql://" + hostname + ":3306/" + databaseName;
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Insert data into users table
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                response.sendRedirect("signup.html");
            } else {
                response.getWriter().println("Error: Failed to insert data into the database.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
