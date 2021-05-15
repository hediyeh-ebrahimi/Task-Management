package bean;
import entity.Task;
import service.TaskService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class Index {

    public List<Task> getTaskList() {
        return TaskService.getInstance().findAll();
    }


}
