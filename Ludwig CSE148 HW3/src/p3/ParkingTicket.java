package p3;

public class ParkingTicket {
	private Cop cop;
	private ParkingMeter meter;
	private String ticketNumber;
	private double finePerIllegalMinute;

	public ParkingTicket(Cop cop, ParkingMeter meter, String ticketNumber, double finePerIllegalMinute) {
		super();
		this.cop = cop;
		this.meter = meter;
		this.ticketNumber = ticketNumber;
		this.finePerIllegalMinute = finePerIllegalMinute;
	}

	public ParkingTicket() {
		super();
	}

	public Cop getCop() {
		return cop;
	}

	public void setCop(Cop cop) {
		this.cop = cop;
	}

	public ParkingMeter getMeter() {
		return meter;
	}

	public void setMeter(ParkingMeter meter) {
		this.meter = meter;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public double getFinePerIllegalMinute() {
		return finePerIllegalMinute;
	}

	public void setFinePerIllegalMinute(double finePerIllegalMinute) {
		this.finePerIllegalMinute = finePerIllegalMinute;
	}

	@Override
	public String toString() {
		return "ParkingTicket \n cop=" + cop + ", \n meter=" + meter + ", \n ticketNumber=" + ticketNumber
				+ ",\n finePerIllegalMinute=" + String.format("%.2f", finePerIllegalMinute) + "\n Fine: " +
				"$" + String.format("%.2f",finePerIllegalMinute * meter.getIllegalParkingMinutes());
	}

}
