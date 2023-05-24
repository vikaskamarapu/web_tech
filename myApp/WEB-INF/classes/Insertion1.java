import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Insertion1 extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ResultSet rs;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        // get the variables entered in the form
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phoneno = req.getParameter("phoneno");
        String sex = req.getParameter("sex");
        String dob = req.getParameter("day") + req.getParameter("month") + req.getParameter("year");
        String languages = "";
        if (req.getParameter("lan1") != null)
            languages += req.getParameter("lan1");
        if (req.getParameter("lan2") != null)
            languages = languages + "," + req.getParameter("lan2");
        if (req.getParameter("lan3") != null)
            languages = languages + "," + req.getParameter("lan3");
        if (req.getParameter("lan4") != null)
            languages = languages + "," + req.getParameter("lan4");
        String address = req.getParameter("address");
        Connection conn = null;
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app", "root", "1234");
            // Add the data into the database
            String sql = "insert into users values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setString(4, phoneno);
            pst.setString(5, sex);
            pst.setString(6, dob);
            pst.setString(7, languages);
            pst.setString(8, address);
            int numRowsChanged = pst.executeUpdate();
            // show that the new account has been created
            out.println(" Hello : ");
            out.println(" '" + name + "'");
            res.sendRedirect("login.html");
            pst.close();
        } catch (ClassNotFoundException e) {
            out.println("Couldn't load database driver: "
                    + e.getMessage());
        } catch (SQLException e) {
            out.println("SQLException caught: "
                    + e.getMessage());
        } catch (Exception e) {
            out.println(e);
        } finally {
            // Always close the database connection.
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ignored) {
                out.println(ignored);
            }
        }
    }
}