package p7;

public class Car {
	private String color;
	private int year;
	private String make;
	private int speed;
	
	public Car(String color, int year, int speed) {
		this.color = color;
		this.year = year;
		this.speed = speed;
	}
	
	public Car() {
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String toString() {
		return "color=" + color + ", year=" + year + ", make=" + make + ", speed=" + speed;
	}

	public void speedUp() {
		speed = speed + 10;
	}
	
	public void slowDown() {
		speed = speed - 10;
	}
}
