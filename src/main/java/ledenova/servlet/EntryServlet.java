package ledenova.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/enter")
public class EntryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");

        if (userName == null) {
            // No name in session — forward to askName.jsp
            req.getRequestDispatcher("/WEB-INF/askName.jsp").forward(req, resp);
        } else {
            // Name present — forward to index.jsp
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Handle form submission from askName.jsp
        String name = req.getParameter("name");
        if (name != null && !name.trim().isEmpty()) {
            req.getSession().setAttribute("userName", name.trim());
        }
        resp.sendRedirect(req.getContextPath() + "/enter");  // redirect to GET /
    }
}
