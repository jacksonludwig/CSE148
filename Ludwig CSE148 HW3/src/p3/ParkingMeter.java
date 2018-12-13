package p3;

public class ParkingMeter {
	private int illegalParkingMinutes;
	private String meterNumber;

	public ParkingMeter(int illegalParkingMinutes, String meterNumber) {
		super();
		this.illegalParkingMinutes = illegalParkingMinutes;
		this.meterNumber = meterNumber;
	}

	public ParkingMeter() {
		super();
	}

	public int getIllegalParkingMinutes() {
		return illegalParkingMinutes;
	}

	public void setIllegalParkingMinutes(int illegalParkingMinutes) {
		this.illegalParkingMinutes = illegalParkingMinutes;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	@Override
	public String toString() {
		return "ParkingMeter [illegalParkingMinutes=" + illegalParkingMinutes + ", meterNumber=" + meterNumber + "]";
	}

}
