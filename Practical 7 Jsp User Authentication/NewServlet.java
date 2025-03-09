
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String u, p;
        u = request.getParameter("uname").trim();
        p = request.getParameter("pwd").trim();
        Connection c;
        try {
// PrintWriter out = response.getWriter();
/* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb",
                    "root", "");

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                    "select * from users where username='" + u + "' AND password='" + p + "'");
            HttpSession session = request.getSession();
            System.out.println("Record fetched");
            if (rs.next()) {
                session.setAttribute("un", u);
                response.sendRedirect("home.jsp");
            } else {
//session.setAttribute("flag", "Wrong Credentials");
                response.sendRedirect("index.html");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
