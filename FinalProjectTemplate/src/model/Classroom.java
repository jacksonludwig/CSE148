package model;

public class Classroom {
	private String roomNumber;
	private int capacity;

	public Classroom(String roomNumber, int capacity) {
		super();
		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "roomNumber=" + roomNumber + ", capacity=" + capacity;
	}

}
