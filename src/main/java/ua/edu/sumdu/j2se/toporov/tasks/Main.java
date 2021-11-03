package ua.edu.sumdu.j2se.toporov.tasks;

public class Main {

	public static void main(String[] args) {
		Task task1 = new Task("Practice", 58);
		Task task2 = new Task("Lecture", 80, 88, 2);
		System.out.println("Name of the task 1: " + task1.getTitle());
		System.out.println("Is the task 1 repeated: " + task1.isRepeated());
		System.out.println("Is the task 1 active: " + task1.isActive());
		System.out.println("Time of the task 1: " + task1.getTime());
		System.out.println("Start time of the task 1: " + task1.getStartTime());
		System.out.println("End time of the task 1: " + task1.getEndTime());
		System.out.println("Interval time of the task 1: " + task1.getRepeatInterval());
		System.out.println("Name of the task 2: " + task2.getTitle());
		System.out.println("Start of the task 2: " + task2.getStartTime());
		System.out.println("End of the task 2: " + task2.getEndTime());
		System.out.println("Interval of the task 2: " + task2.getRepeatInterval());
		task1.setTitle("Course");
		task2.setTitle("Conference");
		System.out.println("Name of the task 1 after the change: " + task1.getTitle());
		System.out.println("Name of the task 2 after the change: " + task2.getTitle());
		task2.setActive(true);
		System.out.println("Is the task 2 active: " + task2.isActive());
		task1.setTime(60);
		System.out.println("Time of the task 1 after the change: " + task1.getTime());
		task2.setTime(82, 86, 1);
		System.out.println("Start of the task 2 after the change: " + task2.getStartTime());
		System.out.println("End of the task 2 after the change: " + task2.getEndTime());
		System.out.println("Interval of the task 2 after the change: " + task2.getRepeatInterval());
		System.out.println("The repeat interval of the task 1: " + task1.getRepeatInterval());
		System.out.println("The repeat interval of the task 2: " + task2.getRepeatInterval());
		System.out.println("Does the task 2 repeat: " + task2.isRepeated());
		task1.setActive(false);
		System.out.println(task1.nextTimeAfter(50));
	}
}