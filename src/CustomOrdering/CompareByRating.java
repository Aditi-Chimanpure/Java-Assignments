package CustomOrdering;

import java.util.Comparator;

import com.core.app.Cricketer;

public class CompareByRating implements Comparator<Cricketer>{

	@Override
	public int compare(Cricketer c1, Cricketer c2) {
		
		if (c1.getRating()<c2.getRating())
			return -1;
		else if (c1.getRating()>c2.getRating())
			return 1;
		else 
			return 0;

	}

}
