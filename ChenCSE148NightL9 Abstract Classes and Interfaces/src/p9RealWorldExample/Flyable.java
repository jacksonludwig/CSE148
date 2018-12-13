package p9RealWorldExample;

public interface Flyable {
	default void fly() {
		System.out.println("Flying...");
	}
}
