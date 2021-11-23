package ua.edu.sumdu.j2se.toporov.tasks;

import java.util.Arrays;

public class ArrayTaskList extends AbstractTaskList {
    private int amount = 0;
    private Task[] tasks = new Task[7];
    public void add (Task task) throws IllegalArgumentException{
        if (task == null) {
            throw new IllegalArgumentException();
        }
        amount += 1;
        tasks = Arrays.copyOf(tasks, tasks.length + amount);
        int i;
        for (i = 0; i < amount; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
            }
        }
    }
    public boolean remove (Task task) throws IllegalArgumentException{
        if (task == null) {
            throw new IllegalArgumentException();
        }
        int i;
        for (i = 0; i < size(); i++) {
            if (tasks[i] == task) {
                System.arraycopy(tasks, i + 1, tasks, i, tasks.length - i - 1);
                tasks = Arrays.copyOf(tasks, tasks.length - 1);
                amount -= 1;
                return true;
            }
        }
        return false;
    }
    public int size () {
        return amount;
    }
    public Task getTask (int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return tasks[index];
    }

    @Override
    public ListTypes.types getType() {
        return ListTypes.types.ARRAY;
    }

    public ArrayTaskList incoming (int from, int to) {
        ArrayTaskList tasks1 = new ArrayTaskList();
        int i;
        for (i = 0; i < size(); i++) {
            if (tasks[i].nextTimeAfter(from) != -1 && tasks[i].nextTimeAfter(to) != -1) {
                if (tasks[i].nextTimeAfter(to) != tasks[i].getTime() || tasks[i].nextTimeAfter(to) != tasks[i].getStartTime()) {
                    tasks1.add(tasks[i]);
                }
            }
        }
        return tasks1;
    }
}