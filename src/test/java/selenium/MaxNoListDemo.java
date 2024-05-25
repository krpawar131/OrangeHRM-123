package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxNoListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> numbers = new ArrayList<Integer>();
        
        numbers.add(5);
        numbers.add(9);
        numbers.add(50);
        numbers.add(12);
        numbers.add(50);
        
        System.out.println(Collections.max(numbers));
        System.out.println(Collections.min(numbers));
        
	}

}
