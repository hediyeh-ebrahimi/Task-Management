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

@WebServlet("/delete")
public class TaskDeleteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Task task = TaskService.getInstance().findById(Long.valueOf(id));
        TaskService.getInstance().delete(task);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
        dispatcher.forward(req, resp);

    }
}
