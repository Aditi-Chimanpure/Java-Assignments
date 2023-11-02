package Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.time.LocalDate.parse;

import com.core.app.Task;
import com.core.app.TaskStatus;

import CustomException.TaskHandlingException;

public class TaskUtils {
public static List<Task> populatedList(){
	List<Task> tList = new ArrayList<Task>();
	//String taskName, String description, LocalDate taskDate
	tList.add(new Task("Study","Java",parse("2023-10-20")));
	tList.add(new Task("Study","cpp",parse("2023-10-23")));
	tList.add(new Task("laundry","officecloths",parse("2023-10-22")));
	tList.add(new Task("shopping","grocary",parse("2023-10-21")));
	tList.add(new Task("Study","DBT",parse("2023-10-23")));
	return tList;
}

public static Map<Integer,Task> populateMap(List<Task> tList)
{
	Map<Integer,Task> taskMap = new HashMap<Integer,Task>();
	for(Task t : tList)
	{
		taskMap.put(t.getTaskId(), t);
	}
	
	return taskMap;
	
}
public static void deleteTask(int taskID,Map<Integer,Task> tasksMap)throws TaskHandlingException {
	Task t = tasksMap.remove(taskID);
	if(t==null)
	{
		throw new TaskHandlingException("TaskID  is invalid");
	}
	else
		System.out.println("Removed the task : "+t);
}
public static void updateTaskStatus(int taskID,String status,Map<Integer,Task> tasksMap)throws TaskHandlingException
{
	Task t =tasksMap.get(taskID);
	TaskStatus vStatus=TaskStatus.valueOf(status.toUpperCase());
	t.setStatus(vStatus);
	System.out.println("status updated for task "+ t );
}

}
