package controller;

import entity.Task;
import service.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class TaskAddController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String duration = req.getParameter("duration");

        Task task = new Task().setTitle(title).setDescription(description).setDescription(duration);
        TaskService.getInstance().save(task);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        dispatcher.forward(req, resp);
    }
}
