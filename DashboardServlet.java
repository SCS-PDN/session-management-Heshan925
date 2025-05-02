import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html"); 
            return;
        }


        List<Course> courses = new ArrayList<>();
        courses.add(new Course("101", "Introduction to Java", "Dr. Saman"));
        courses.add(new Course("102", "Web Development", "Prof. Priyantha"));
        courses.add(new Course("103", "Data Structures", "Dr. Kamal"));


        request.setAttribute("courses", courses);


        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}
