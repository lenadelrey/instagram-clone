package by.instagram.web.servlet;

import by.instagram.entity.User;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User byLogin = userService.findByLogin(login);
        if(byLogin != null && byLogin.getPassword().equals(password)) {
            req.getSession().setAttribute("user", byLogin);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("message", "Wrong login or password");
            getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
        }
    }
}
