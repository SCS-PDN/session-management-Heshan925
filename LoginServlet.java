import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        
        if ((userName.equals("student1") && password.equals("pass1")) ||
                (userName.equals("student2") && password.equals("pass2"))) {


            HttpSession session = request.getSession();
            session.setAttribute("username", userName);


            Cookie userCookie = new Cookie("username", userName);
            userCookie.setMaxAge(60 * 60); 
            response.addCookie(userCookie);


            response.sendRedirect("DashboardServlet");
        } else {

            response.sendRedirect("login.html");
        }
    }
}
