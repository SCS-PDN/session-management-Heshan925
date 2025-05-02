import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseId = request.getParameter("courseId");


        HttpSession session = request.getSession();
        if (courseId != null) {

            @SuppressWarnings("unchecked")
            List<String> enrolledCourses = (List<String>) session.getAttribute("enrolledCourses");
            if (enrolledCourses == null) {
                enrolledCourses = new ArrayList<>();
                session.setAttribute("enrolledCourses", enrolledCourses);
            }
            enrolledCourses.add(courseId);


            response.sendRedirect("DashboardServlet");
        } else {
            response.sendRedirect("errorPage.html"); 
        }
    }
}
