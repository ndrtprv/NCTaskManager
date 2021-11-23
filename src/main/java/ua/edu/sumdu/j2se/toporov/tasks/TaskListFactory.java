package ua.edu.sumdu.j2se.toporov.tasks;

public class TaskListFactory {
    public static AbstractTaskList createTaskList (ListTypes.types type) throws IllegalArgumentException {
        if (type == ListTypes.types.ARRAY) {
            return new ArrayTaskList();
        } else if (type == ListTypes.types.LINKED) {
            return new LinkedTaskList();
        } else {
            throw new IllegalArgumentException();
        }
    }
}