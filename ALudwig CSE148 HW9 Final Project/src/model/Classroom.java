package model;

import java.io.Serializable;

public class Classroom implements Serializable{
	private String roomNumber;
	private String buildingName;
	private int numberOfSeats;
	private int numberOfComputers;
	private boolean projectorOrNot;

	public Classroom(String dataLine) {
		roomNumber = getRoomNumberFromFile(dataLine);
		buildingName = getBuildingNameFromFile(dataLine);
		numberOfSeats = getNumberOfSeatsFromFile(dataLine);
		numberOfComputers = getNumberOfComputersFromFile(dataLine);
		projectorOrNot = getProjectorOrNotFromFile(dataLine);
	}

	public Classroom(String room, String building, int seats, int computers, Boolean projector) {
		buildingName = building;
		try {
			roomNumber = buildingName.charAt(0) + room;
		} catch (Exception e) {
			roomNumber = "X" + room;
		}
		numberOfSeats = seats;
		numberOfComputers = computers;
		projectorOrNot = projector;
	}

	public String getRoomNumberFromFile(String line) {
		int count = 0;
		String room = "";
		while (line.charAt(count) != '*') {
			room += line.charAt(count);
			count++;
		}
		return room;
	}

	public String getBuildingNameFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String building = "";
		while (sectionCount < 1) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			building += line.charAt(count);
			count++;
		}
		return building;
	}

	public int getNumberOfSeatsFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String seats = "";
		while (sectionCount < 2) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			seats += line.charAt(count);
			count++;
		}
		return Integer.parseInt(seats);
	}

	public int getNumberOfComputersFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String computers = "";
		while (sectionCount < 3) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			computers += line.charAt(count);
			count++;
		}
		return Integer.parseInt(computers);
	}

	public boolean getProjectorOrNotFromFile(String line) {
		int sectionCount = 0;
		int count = 0;
		String projector = "";
		while (sectionCount < 4) {
			if (line.charAt(count) == '*') {
				sectionCount++;
			}
			count++;
		}
		while (line.charAt(count) != '*') {
			projector += line.charAt(count);
			count++;
		}
		return Boolean.parseBoolean(projector);
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getNumberOfComputers() {
		return numberOfComputers;
	}

	public void setNumberOfComputers(int numberOfComputers) {
		this.numberOfComputers = numberOfComputers;
	}

	public boolean isProjectorOrNot() {
		return projectorOrNot;
	}

	public void setProjectorOrNot(boolean projectorOrNot) {
		this.projectorOrNot = projectorOrNot;
	}

	@Override
	public String toString() {
		return "Classroom [roomNumber=" + roomNumber + ", buildingName=" + buildingName + ", numberOfSeats="
				+ numberOfSeats + ", numberOfComputers=" + numberOfComputers + ", projectorOrNot=" + projectorOrNot
				+ "]";
	}

}
