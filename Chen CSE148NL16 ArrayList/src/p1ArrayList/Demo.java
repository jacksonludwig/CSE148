package p1ArrayList;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		/*
		 * array review:
		 * 1.) Arrays require the same data type throughout, but allows both primitive 
		 * AND reference.
		 * 2.) Array size must be known when it is created (nothing can be added or removed).
		 * 3.) Arrays very slow at shifting values after deleting/inserting values.
		 * 
		 */
		int[] numbers = {1,2,3,4,5,6,7,8,9}; // primitive
		String[] names = new String[5]; // reference
		numbers[1] = 2; // Arrays are very efficient at storing/retrieving data at known points.
		
		/*
		 * arraylist review:
		 * 1.) Only holds reference variables (changes primitive to reference automatically).
		 * 2.) Inefficient in space (cannot shrink and doubles in size [copies old values as well]
		 *  when array limit is reached).
		 */
		
		ArrayList myList = new ArrayList();
		myList.add(1); // converts statement to: myList.add(new Integer(1)); called autoboxing.
		myList.add(2);
		myList.add(2.5);
		myList.add("word");
		int i = (int)myList.get(0);
		String m = (String)myList.get(3);
		System.out.println(myList.get(0));
		
		ArrayList<Integer> correctUse = new ArrayList(); // Generics
		correctUse.add(1);
		correctUse.add(5);
		int x = correctUse.get(0); // auto unboxing (from Integer 1 to int 1).
		System.out.println(correctUse.get(0));
		
		// <arraylist>.add(index, <value>) adds value. No index will add to end of list.
		// <arraylist>.set(index, <value>) replaces value.
		// <arraylist>.contains(index (?), <value>) returns true or false if list has value. 
	}
	

}
