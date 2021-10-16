package by.instagram.web.servlet;

import by.instagram.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPost")
public class EditPostServlet extends HttpServlet {

    private PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("postId", Long.parseLong(req.getParameter("postId")));
        getServletContext().getRequestDispatcher("/pages/editPost.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = (String) req.getAttribute("description");
        long postId = Long.parseLong(req.getParameter("postId"));
        postService.editPost(postId, description);
        req.setAttribute("description", description);
        resp.sendRedirect("/post&id=" + postId);
    }
}

//аккаунт, вывод всех постов в аккаунте, удаление, едит и прочее
//сделать красивше
