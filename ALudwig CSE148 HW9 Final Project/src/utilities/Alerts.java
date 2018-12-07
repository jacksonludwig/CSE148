package utilities;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	public static boolean showItemFound() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data search complete");
		alert.setHeaderText("Item found successfully");
		alert.setContentText("Click OK to clear text fields or Cancel to leave you data");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showItemNotFound() {
		Alert alert = new Alert(AlertType.ERROR, "Click OK to clear text fields or Cancel to leave your data",
				ButtonType.OK, ButtonType.CANCEL);
		alert.setTitle("Data search complete");
		alert.setHeaderText("There was a problem finding your item.");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showItemUpdated() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data manipulation complete");
		alert.setHeaderText("Item updated successfully");
		alert.setContentText("Click OK to clear text fields or Cancel to leave you data");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showItemNotUpdated() {
		Alert alert = new Alert(AlertType.ERROR, "Click OK to clear text fields or Cancel to leave your data",
				ButtonType.OK, ButtonType.CANCEL);
		alert.setTitle("Data manipulation failed");
		alert.setHeaderText("Item with matching identification was not found in the database");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showItemInserted() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data insert completed");
		alert.setHeaderText("The new item was inserted into the database");
		alert.setContentText("Click OK to clear text fields or Cancel to leave you data");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showRepeatItem() {
		Alert alert = new Alert(AlertType.ERROR, "Click OK to clear text fields or Cancel to leave your data",
				ButtonType.OK, ButtonType.CANCEL);
		alert.setTitle("Data insert failed");
		alert.setHeaderText("Item with matching identification was already found in the database");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showItemDeleted() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data delete completed");
		alert.setHeaderText("The item was deleted from the database");
		alert.setContentText("Click OK to clear text fields or Cancel to leave you data");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}

	public static boolean showItemNotDeleted() {
		Alert alert = new Alert(AlertType.ERROR, "Click OK to clear text fields or Cancel to leave your data",
				ButtonType.OK, ButtonType.CANCEL);
		alert.setTitle("Data delete failed");
		alert.setHeaderText("Item with matching identification was not found in the database");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.OK) {
			return true;
		} else if (result.get() == ButtonType.CANCEL) {
			return false;
		}
		return false;
	}
}
