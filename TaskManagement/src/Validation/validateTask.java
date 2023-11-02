package Validation;

import java.time.LocalDate;

import com.core.app.Task;
import com.core.app.TaskStatus;

public class validateTask {
	public static TaskStatus validateTaskStatus(String status) throws IllegalArgumentException
	{
		return TaskStatus.valueOf(status);
	}

	public static LocalDate parseAndValidateDate(String taskDate)
	{
		return LocalDate.parse(taskDate);
		
	}
	
	public static Task validateAll( String taskName, String description, String taskDate)throws IllegalArgumentException
	{
		LocalDate vtaskDate=parseAndValidateDate(taskDate);
		
		return new Task(taskName, description,vtaskDate);		
		
	}
}
