package Tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static Utils.TaskUtils.*;
import static Validation.validateTask.*;
import CustomeOrdering.CompareByDate;

import com.core.app.Task;
import com.core.app.TaskStatus;

import CustomException.TaskHandlingException;

public class TaskTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, Task> tasksMap = new HashMap<Integer, Task>();
			List<Task> tList = populatedList();
			tasksMap = populateMap(tList);

			boolean flag = false;
			while (!flag) {
				try {
					System.out.println(
							"Menu : 1. Add New Task\n2.Delete a task\n 3. Update task status\n4. Display all pending tasks\n5.Display all pending tasks for today\n6.Display all tasks sorted by taskDate\n7.Display all tasks ");
					System.out.println("Enter your choice : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the Task Details \ntaskName,description,taskDate(YYYY-MM-DD)");
						Task validatedTask = validateAll(sc.next(), sc.next(), sc.next());
						tasksMap.put(validatedTask.getTaskId(), validatedTask);
						System.out.println("Task Added successfully");

						break;
					case 2:
						System.out.println("Enter task ID to delete ");
						deleteTask(sc.nextInt(), tasksMap);
						break;
					case 3:
						System.out
								.println("Enter task ID  and status (PENDING, INPROGRESS,COMPLETED)to update status ");
						updateTaskStatus(sc.nextInt(), sc.next(), tasksMap);
						break;
					case 4:
						System.out.println("All Pending Tasks are below ");
						for (Task t : tasksMap.values()) {
							if (t.getStatus() == TaskStatus.PENDING) {
								System.out.println(t);
							}
						}
						break;
					case 5:
						System.out.println("All Pending Tasks for today ");

						LocalDate today = LocalDate.of(2023, 10, 23);
						for (Task t : tasksMap.values()) {

							if (t.getTaskDate().isEqual(today)) {
								System.out.println(t);
							}
						}

						break;
						
					case 6:
						List<Task> taskList=new ArrayList<Task>(tasksMap.values());
						Collections.sort(taskList, new CompareByDate());
						System.out.println("Sorted List ");
						for (Task t7 : taskList) {
							System.out.println(t7);
						}
						
						break;				
						

					case 7:
						System.out.println("All tasks in taskMap ");
						for (Task t7 : tasksMap.values()) {
							System.out.println(t7);
						}
						break;
					
					

					default:
						System.out.println("Invalid choice ....please Enter again");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Please try again");
					sc.nextLine();

				}
			}
		}
	}

}
