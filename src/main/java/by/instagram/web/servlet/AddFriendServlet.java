package by.instagram.web.servlet;

import by.instagram.entity.User;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addFriend")
public class AddFriendServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String friendLogin = req.getParameter("friendLogin");
        User byLogin = userService.findByLogin(friendLogin);
        userService.addFriend(byLogin);
        resp.sendRedirect("/account&id=" + byLogin);
    }
}
