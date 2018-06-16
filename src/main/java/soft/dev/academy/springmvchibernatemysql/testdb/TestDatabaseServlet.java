package soft.dev.academy.springmvchibernatemysql.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(value = "/TestDatabaseServlet")
public class TestDatabaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            // setup connection variables
            String user = "springstudent";
            String pass = "springstudent";

            String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
            String driver = "com.mysql.jdbc.Driver";

            // get connection to database

            try {
                PrintWriter out = resp.getWriter();

                out.println("Connecting to database: " + jdbcUrl);

                Class.forName(driver);
                Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);

                out.println("SUCCESS!!!");

                connection.close();

            } catch (Exception exc) {
                exc.printStackTrace();
                throw new ServletException(exc);
            }
        }
    }

