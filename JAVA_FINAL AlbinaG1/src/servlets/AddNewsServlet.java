package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;
import model.User;

import java.io.IOException;

@WebServlet(value = "/addNews")
public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("ONLINE_USER");
        if (user != null) {
            req.getRequestDispatcher("addnewspage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("404.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String text = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("ONLINE_USER");

        News news = new News();
        news.setTitle(title);
        news.setContent(text);
        news.setUser(user);

        DBManager.addNews(news);
        resp.sendRedirect("/home");
    }
}
