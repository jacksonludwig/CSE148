package p1;

public class Demo {
	public static void main(String[] args) {
		Dog d1 = new Dog("jerry", 10, "hound");
		Pet p1 = new Pet("Alan", 10);
		Cat c1 = new Cat("Steve", 3, "ORANGE");

		// POLYMORPHISM : a reference variable of a superclass type can be used to
		// reference objects of a subclass type.
		Pet p2 = new Dog("David", 4, "Golden Retriever");
		Pet p3 = new Cat("Frank", 5, "WHITE");
		
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		// if a superclass is referencing a subclass object, it must be "told" explicitly (casted) to use
		// certain methods.
		System.out.println(((Dog)p2).getBreed());
		
		/*
		showPet(p1);
		showPet(d1);
		showPet(c1);
		showPet(p2);
		showPet(p3);
		*/
		// System.out.println(d1 + "\n" + p1 + "\n" + c1);
	}

	private static void showPet(Pet p) {
		System.out.println(p);
	}

}
