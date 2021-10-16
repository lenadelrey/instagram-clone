package by.instagram.web.servlet;

import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createComment")
public class CreateCommentServlet extends HttpServlet {

    private PostService postService = new PostService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comment = req.getParameter("comment");
        User user = (User) req.getSession().getAttribute("user");
        long postId = Long.parseLong(req.getParameter("postId"));
        postService.addComment(postId, comment, user);
        resp.sendRedirect("/post?id=" + postId);
    }
}
