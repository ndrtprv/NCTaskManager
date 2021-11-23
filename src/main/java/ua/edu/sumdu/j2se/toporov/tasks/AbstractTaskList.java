package ua.edu.sumdu.j2se.toporov.tasks;

public abstract class AbstractTaskList {
    public abstract void add (Task task);
    public abstract boolean remove (Task task);
    public abstract int size();
    public abstract Task getTask(int index);
    public abstract ListTypes.types getType();
    public AbstractTaskList incoming (int from, int to) {
        AbstractTaskList list = TaskListFactory.createTaskList(getType());
        int i;
        Task task;
        for (i = 0; i < list.size(); i++) {
            task = list.getTask(i);
            if (task.nextTimeAfter(from) != -1 && task.nextTimeAfter(to) != -1) {
                if (task.nextTimeAfter(from) != task.getTime() || task.nextTimeAfter(to) != task.getStartTime()) {
                    list.add(task);
                }
            }
        }
        return list;
    }
}