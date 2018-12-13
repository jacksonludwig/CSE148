package StaticVariablesStaticMethods;

public class Demo {

	public static void main(String[] args) {
		Dog d1 = new Dog();

		Dog d2 = new Dog("Freddy", 9, "Basset", 75.5);
		
		// can use class name for class methods/variables (static variables/methods)
		Dog.setNumberOfLegs(3);
		System.out.println(Dog.getNumberOfLegs());
		
		System.out.println(d1.getName());
	}

}
