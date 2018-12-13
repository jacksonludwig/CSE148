package p2;

public class Fan {
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	public Fan(int speed, boolean on, double radius, String color) {
		super();
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
	}

	public Fan() {
		super();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		if(on == true) {
			return "Fan [speed=" + speed + ", radius=" + radius + ", color=" + color + "]";
		}
		return "Fan [speed=" + speed + ", radius=" + radius + ", color=" + color + ", fan is off]";
	}
	
	
}
