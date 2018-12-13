package p9RealWorldExample;
// FAVOR interface over superclass
public class Demo {

	public static void main(String[] args) {
		MallardDuck d1 = new MallardDuck("John Duck", 2);
		d1.fly();
		d1.quack();
		
		RubberDucky r1 = new RubberDucky("Rubber Duck", 1);
	//	r1.fly();
		r1.quack();
	}

}
