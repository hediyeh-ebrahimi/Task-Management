import common.JPAProvider;
import service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {

    private JPAProvider jpaProvider;
    private TaskService taskService;

    public Test() {
    }

    public Test(JPAProvider jpaProvider, TaskService taskService) {
        this.jpaProvider = jpaProvider;
        this.taskService = taskService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.taskService.findAll();
        System.out.println("-------------13-----------------");
    }
}
