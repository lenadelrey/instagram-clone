package by.instagram.web.servlet;

import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.service.PostService;
import by.instagram.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    private PostService postService = new PostService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = Long.parseLong(req.getParameter("userId"));
        User user = userService.findById(userId);
        List<Post> allByUser = postService.findAllByUser(user);
        req.setAttribute("posts", allByUser);
        getServletContext().getRequestDispatcher("/pages/account.jsp").forward(req, resp);
    }
}