package utils;

import java.util.Comparator;

import com.app.core.Customer;

public class DobLastNameComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		if( o1.getDob().isBefore(o2.getDob())) {
			return -1;
		}
		else if(o1.getDob().isAfter(o2.getDob())){
			return 1;
		}
		else
		{
			return o1.getLastname().compareTo(o2.getLastname());
				
				
		}
					}

}
