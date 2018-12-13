package p1Car;

public class Car {
	private String make;
	private int year;
	private double price;
	private String color;
	private int speed;

	public Car(String make, int year, double price, String color) {
		this.make = make;
		this.year = year;
		this.price = price;
		this.color = color;
	}

	public Car() {
	}

	public void speedUp(int speed) {
		this.speed += speed;
	}

	public void slowDown(int speed) {
		this.speed -= speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/*
	public void setSpeed(int speed) {
		
	}
	*/
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", year=" + year + ", price=" + price + ", color=" + color + "]";
	}

}
