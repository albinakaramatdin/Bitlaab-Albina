package db;

import model.Tasks;

import java.util.ArrayList;

public class DBManager {

    public static ArrayList<Tasks> tasksArrayList = new ArrayList<>();
    public static long id = 2L;

    static {
        tasksArrayList.add(new Tasks(1L, "Создать веб приложение на Java EE", "Нужно будет создать собственное приложение на Java EE для себя", "23.10.2021", true));
    }

    public static ArrayList<Tasks> getAllTasks(){
        return tasksArrayList;

    }

    public static void addTask(Tasks task){
        task.setId(id);
        task.setStatus(false);
        tasksArrayList.add(task);
        id++;
    }                                                                                     public static Tasks getTask(Long id){
        for (Tasks task : tasksArrayList){
            if (task.getId()==id){
                return task;
            }
        }
        return null;
    }


    public void deleteTask(Long id){
        tasksArrayList.removeIf(task -> task.getId().equals(id));
    }
}

