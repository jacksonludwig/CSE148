package p1TextFileGenerators;

import java.util.Random;

public class Classroom {
	private String roomNumber;
	private String buildingName;
	private int numberOfSeats;
	private int numberOfComputers;
	private boolean projectorOrNot;

	private static int room = 148;

	private static final int MIN_SEATS_COMPUTERS = 12;
	private static final int MAX_SEATS_COMPUTERS = 30;

	public Classroom() {
		buildingName = generateBuilding();
		roomNumber = buildingName.charAt(0) + String.valueOf(room++);
		numberOfSeats = generateSeats();
		numberOfComputers = generateComputers();
		projectorOrNot = checkForProjector();
	}

	public String generateBuilding() {
		Random rand = new Random();

		Buildings[] buildings = Buildings.values();
		String[] buildingList = new String[buildings.length];

		for (int i = 0; i < buildings.length; i++) {
			buildingList[i] = String.valueOf(buildings[i]);
		}

		int randomBuildingValue = rand.nextInt(buildingList.length);

		return buildingList[randomBuildingValue];
	}

	public int generateSeats() {
		Random rand = new Random();
		return MIN_SEATS_COMPUTERS + rand.nextInt((MAX_SEATS_COMPUTERS - MIN_SEATS_COMPUTERS) + 1);
	}

	public int generateComputers() {
		Random rand = new Random();
		int randomValue = MIN_SEATS_COMPUTERS + rand.nextInt((MAX_SEATS_COMPUTERS - MIN_SEATS_COMPUTERS) + 1);
		while (randomValue - 1 > numberOfSeats) {
			randomValue--;
		}
		return randomValue;
	}

	public boolean checkForProjector() {
		Random rand = new Random();
		return rand.nextBoolean();
	}
	
	@Override
	public String toString() {
		return roomNumber + "; " + buildingName + "; " + numberOfSeats + "; " + numberOfComputers + "; "
				+ projectorOrNot;
	}

}
