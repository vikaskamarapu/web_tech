import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetCook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Cookie myCookies[] = request.getCookies();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        for (int i = 0; i < myCookies.length; i++) {
            String s = myCookies[i].getName();
            String v = myCookies[i].getValue();
            out.println("vikas kamarapu");
        }

    }

}
