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
import java.util.ArrayList;

@WebServlet("/createPost")
public class CreatePostServlet extends HttpServlet {

    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/createPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        User user = (User) req.getSession().getAttribute("user");
        boolean save = postService.save(new Post(0, description, user, new ArrayList<>(), 0, new ArrayList<>()));
        if(save) {
            resp.sendRedirect("/");
        } else {
            req.setAttribute("message", "Something is wrong");
            getServletContext().getRequestDispatcher("/pages/createPost.jsp").forward(req, resp);
        }
    }
}
