package service;

import common.JPAProvider;
import entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class TaskService {
    private TaskService() {
    }

    private static TaskService service = new TaskService();

    public static TaskService getInstance() {
        return service;
    }


    public void save(Task task) {
        EntityManager manager = JPAProvider.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        task.setCreatedOn(LocalDate.now());
        task.setUpdatedOn(LocalDate.now());
        manager.persist(task);
        transaction.commit();
        manager.close();
    }

    public void update(Task task) {
        EntityManager manager = JPAProvider.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        task.setUpdatedOn(LocalDate.now());
        manager.merge(task);
        transaction.commit();
        manager.close();
    }

    public void delete(Task task) {
        EntityManager manager = JPAProvider.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        task = manager.merge(task);
        manager.remove(task);
        transaction.commit();
        manager.close();
    }

    public List<Task> findAll( ) {
        EntityManager manager = JPAProvider.getEntityManagerFactory().createEntityManager();
        List<Task> taskList = manager.createQuery("select o from task o").getResultList();
        manager.close();
        return taskList;
    }

    public Task findById(Long id) {
        EntityManager manager = JPAProvider.getEntityManagerFactory().createEntityManager();
        Task task = manager.find(Task.class,id);
        return task;

    }
}
