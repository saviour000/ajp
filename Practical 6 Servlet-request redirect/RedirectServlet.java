import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/RedirectServlet" })
public class RedirectServlet extends HttpServlet {

    // Handle both GET and POST requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Same logic as POST method for handling GET requests
        handleRedirect(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle the POST method (which will be used when form is submitted)
        handleRedirect(request, response);
    }

    // Common logic to handle redirect for both GET and POST requests
    private void handleRedirect(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the URL entered by the user
        String location = request.getParameter("location");
        response.sendRedirect("https://www.google.com/search?q=" + location);
    }
}
