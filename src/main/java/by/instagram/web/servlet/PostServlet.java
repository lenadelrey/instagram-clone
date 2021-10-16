package by.instagram.web.servlet;

import by.instagram.entity.Comment;
import by.instagram.entity.Like;
import by.instagram.entity.Post;
import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Post byId = postService.findById(id);
        if (byId.getUser().equals(req.getSession().getAttribute("user"))) {
            req.setAttribute("isCreator", true);
        }
        req.setAttribute("post", byId);
        List<Like> allLikes = postService.getAllLikes(id);
        req.setAttribute("likes", allLikes.size());
        List<Comment> allComments = postService.getAllComments(id);
        req.setAttribute("comments", allComments);
        getServletContext().getRequestDispatcher("/pages/post.jsp").forward(req, resp);
    }

}
