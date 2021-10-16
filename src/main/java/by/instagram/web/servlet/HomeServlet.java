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
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> all = postService.getAll();
        req.setAttribute("posts", all);
        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }
}
//достать все посты в лист и в jsp вывести их циклом
