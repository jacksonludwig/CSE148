package p3AnonymousClass;
public interface InterfaceCalculator {
	int AMOUNT = 5; // all variables in interfaces have "public static final" applied by default. NO instance variables.
	int square(int number); // all methods in interfaces have the "public abstract" keywords applied by default. 
	
	/*
	 * Access modifiers:
	 * public - All classes in the world can access the variable/method.
	 * private - ONLY the LOCAL class can access the variable/method.
	 * default (package) - Occurs when no keyword is put in front of variable/method. Allow ONLY classes in the same package
	 * 		to access.
	 * protected - All classes in the same package AND all of their subclasses can access can access the variable/method.
	 */
}
