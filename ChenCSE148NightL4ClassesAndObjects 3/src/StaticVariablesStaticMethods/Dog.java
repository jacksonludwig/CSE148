package StaticVariablesStaticMethods;

public class Dog {
	// instance variables -- CHANGE FROM OBJECT TO OBJECT
	private String name;
	private int age;
	private String breed;
	private double weight;
	
	// static variables -- CARRIED BETWEEN OBJECTS, also a CLASS variable (not 
	// part of an object)
	private static int numberOfLegs = 4;
	
	// like a static variable that CANNOT BE CHANGED. Otherwise known as a constant
	private final int NUMBER_OF_HEADS = 1;
	
	
	public Dog(String name, int age, String breed, double weight) {
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.weight = weight;
	}

	public Dog() {
		
	}

	
	// static methods
	public static int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	public int getNUMBER_OF_HEADS() {
		return NUMBER_OF_HEADS;
	}

	public static void setNumberOfLegs(int numberOfLegs) {
		Dog.numberOfLegs = numberOfLegs;
	}


	// instance methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", breed=" + breed + ", weight=" + weight + "]";
	}
	
	
	
	
	
}
