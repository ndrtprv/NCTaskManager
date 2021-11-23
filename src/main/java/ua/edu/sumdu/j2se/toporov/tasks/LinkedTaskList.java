package ua.edu.sumdu.j2se.toporov.tasks;

public class LinkedTaskList extends AbstractTaskList{
    private Node start;
    private Node end;
    static class Node {
        Task task;
        Node nextTask;
    }
    private int amount = 0;
    public void add (Task task) throws IllegalArgumentException{
        if (task == null) {
            throw new IllegalArgumentException();
        }
        Node node = new Node();
        node.task = task;
        if (start == null) {
            start = end = node;
        } else {
            end.nextTask = node;
            end = node;
        }
        amount++;
    }
    public boolean remove (Task task) throws IllegalArgumentException {
        if (task == null) {
            throw new IllegalArgumentException();
        }
        int i = 0, j = 0;
        Node findNode = start;
        while (i < size()) {
            if (findNode.task == task) {
                if (i == 0) {
                    start = start.nextTask;
                    if (end == null) {
                        start = null;
                    }
                } else {
                    Node previous = start;
                    while (j < i - 1) {
                        previous = previous.nextTask;
                        j++;
                    }
                    previous.nextTask = previous.nextTask.nextTask;
                    if (i == amount - 1) {
                        end = previous;
                    }
                }
                amount--;
                return true;
            }
            findNode = findNode.nextTask;
            i++;
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
        int i;
        Node begin = start;
        for (i = 0; i < index; i++) {
            begin = begin.nextTask;
        }
        return begin.task;
    }

    @Override
    public ListTypes.types getType() {
        return ListTypes.types.LINKED;
    }

    public LinkedTaskList incoming (int from, int to) {
        LinkedTaskList tasks1 = new LinkedTaskList();
        int i;
        Node adding = start;
        for (i = 0; i < size(); i++) {
            if (adding.task.nextTimeAfter(from) != -1 && adding.task.nextTimeAfter(to) != -1) {
                if (adding.task.nextTimeAfter(to) != adding.task.getTime() || adding.task.nextTimeAfter(to) != adding.task.getStartTime()) {
                    tasks1.add(adding.task);
                }
            }
            adding = adding.nextTask;
        }
        return tasks1;
    }
}