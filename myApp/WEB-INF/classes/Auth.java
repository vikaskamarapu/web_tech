import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Auth extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app", "root", "1234");

            PreparedStatement pt = conn.prepareStatement("select * from users where email=? and password=?");

            pt.setString(1, email);
            pt.setString(2, password);

            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                response.sendRedirect("home.html");
            } else {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body><h2>InValid Email or Password</h2><br></body></html>");
            }
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
