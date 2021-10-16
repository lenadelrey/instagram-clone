package by.instagram.web.servlet;

import by.instagram.entity.User;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/like")
public class LikeServlet extends HttpServlet {

    private PostService postService = new PostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long postId = Long.parseLong(req.getParameter("postId"));
        User user = (User) req.getSession().getAttribute("user");
        postService.like(postId, user);
        resp.sendRedirect("/post&id=" + postId);
    }
}
