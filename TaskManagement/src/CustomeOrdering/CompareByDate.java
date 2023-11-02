package CustomeOrdering;
import java.util.Comparator;

import com.core.app.Task;

public class CompareByDate implements Comparator<Task>{
	
@Override
	public int compare(Task t1,Task t2) {
		
		
		return t1.getTaskDate().compareTo(t2.getTaskDate());
	}

	
	

}
