package p5;

public class RetailItem {
	private int itemId;
	private String description;
	private int unitsOnHand;
	private double price;

	public RetailItem(int itemId, String description, int unitsOnHand, double price) throws BadPriceException, BadUnitsException {
		super();
		this.itemId = itemId;
		this.description = description;
		this.unitsOnHand = unitsOnHand;
		this.price = price;
		checkPrice(price);
		checkUnitsOnHand(unitsOnHand);
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUnitsOnHand() {
		return unitsOnHand;
	}

	public void setUnitsOnHand(int unitsOnHand) throws BadUnitsException {
		checkUnitsOnHand(unitsOnHand);
		this.unitsOnHand = unitsOnHand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws BadPriceException {
		checkPrice(price);
		this.price = price;
	}
	
	public void checkPrice(double price) throws BadPriceException {
		if(price < 0.0) {
			throw new BadPriceException("Negative prices are not allowed.");
		}
	}
	
	public void checkUnitsOnHand(int amount) throws BadUnitsException {
		if(amount < 0) {
			throw new BadUnitsException("Amount on hand cannot be below zero.");
		}
	}

	@Override
	public String toString() {
		return "RetailItem [itemId=" + itemId + ", description=" + description + ", unitsOnHand=" + unitsOnHand
				+ ", price=" + price + "]";
	}

}
