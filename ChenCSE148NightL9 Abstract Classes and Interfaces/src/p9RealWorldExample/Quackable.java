package p9RealWorldExample;

public interface Quackable {
	default void quack() {
		System.out.println("Quacking...");
	}
}
