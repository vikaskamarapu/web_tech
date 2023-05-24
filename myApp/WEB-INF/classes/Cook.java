import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cook extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Cookie myCookie1 = new Cookie("email", email);
        Cookie myCookie2 = new Cookie("password", password);
        // Enumeration keys;
        // String key, value;
        // keys = request.getParameterNames();
        // while (keys.hasMoreElements()) {
        //     key = (String) keys.nextElement();
        //     value = request.getParameter(key);
        //     myCookie = new Cookie(key, value);
        //     response.addCookie(myCookie);
        // }
        response.addCookie(myCookie1);
        response.addCookie(myCookie2);
        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();
        // out.println("\n The Cookie is added");
        response.sendRedirect("GetCook");
    }

}
