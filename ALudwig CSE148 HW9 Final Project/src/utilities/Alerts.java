package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	public static boolean showItemFound() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data search complete");
		alert.setHeaderText("Item Found Successfully");
		alert.setContentText("Click OK to load the data or Cancel to leave text fields as they are");
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
		alert.setHeaderText("There Was a Problem Finding Your Item.");
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
		alert.setHeaderText("Item Updated Successfully");
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
		alert.setHeaderText("Item With Matching Identification Was Not Found In The Database");
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
		alert.setHeaderText("The New Item Was Inserted Into The Database");
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
		alert.setHeaderText("Item With Matching Identification Was Already Found In The Database");
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
		alert.setHeaderText("The Item Was Deleted From The Database");
		alert.setContentText("Click OK to load the deleted data or Cancel to leave you the text fields as they are");
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
		alert.setHeaderText("Item With Matching Identification Was Not Found In The Database");
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

	public static String confirmClassGrade() {
		String[] grades = { "A", "B+", "B", "C+", "C", "D+", "D", "F" };
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Grade", grades);
		dialog.setTitle("Grade Selection");
		dialog.setHeaderText("The Grade For The Class Is Required");
		dialog.setContentText("Choose your letter grade:");
		Optional<String> result = dialog.showAndWait();
		String grade = "";
		if (result.isPresent()) {
			grade = result.get();

			if (grade.equals("A")) {
				return ",A";
			} else if (grade.equals("B+")) {
				return ",B+";
			} else if (grade.equals("B")) {
				return ",B";
			} else if (grade.equals("C+")) {
				return ",C+";
			} else if (grade.equals("C")) {
				return ",C";
			} else if (grade.equals("D+")) {
				return ",D+";
			} else if (grade.equals("D")) {
				return ",D";
			} else {
				return ",F";
			}
		}
		return ",F";
	}

	public static void showClassFailed() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Class move failed");
		alert.setContentText("The course was not added to the \"taken\" list");
		alert.setHeaderText("The Student Did Not Pass This Class");
		alert.showAndWait();
	}

	public static void showClassWrongGradeEntered() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Class move failed");
		alert.setContentText("It is important that the correct grade the student earned is entered");
		alert.setHeaderText("Incorrect Grade Chosen");
		alert.showAndWait();
	}

	public static void showMajorNotChosen() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Person insert failed");
		alert.setContentText("Please choose a major");
		alert.setHeaderText("Major Not Chosen");
		alert.showAndWait();
	}

	public static void showFillAllFields() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Person insert failed");
		alert.setContentText("Please fill all supplied fields");
		alert.setHeaderText("All Fields Not Filled");
		alert.showAndWait();
	}

	public static boolean showItemInsertedAndId(String id) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data insert completed");
		alert.setHeaderText("Person entered with ID of: " + id);
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

	public static String searchForPerson() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Person Search Window");
		dialog.setHeaderText("Use Identification Number to Search Here");
		dialog.setContentText("Enter ID number: ");
		Optional<String> result = dialog.showAndWait();
		return result.get();
	}
	
	public static void showPersonNotFound() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Data search complete");
		alert.setHeaderText("There Was a Problem Finding Your Item.");
		alert.setContentText("The ID either does not exist or is from a faculty member");
		alert.showAndWait();
	}

	public static boolean showPersonFound() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data search complete");
		alert.setHeaderText("Person Found Successfully");
		alert.setContentText("Click OK to load the person's data or Cancel to leave data fields as they are");
		Optional<ButtonType> result = alert.showAndWait();
		if (!result.isPresent()) {
			return false;
		} else if (result.get() == ButtonType.CANCEL) {
			return true;
		} else if (result.get() == ButtonType.OK) {
			return false;
		}
		return false;
	}
	
	public static void showWrongPerson() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Person search completed");
		alert.setContentText("This ID was found, but it was not applicable for a student.");
		alert.setHeaderText("Please Use the Faculty Tab to Search For This Person");
		alert.showAndWait();
	}
	
	public static void showFailedCourseAutoMoved(int coursesFailed) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("This student did not pass all of his/her classes");
		alert.setContentText("The failed classes were moved to the \"Courses To Take\" column");
		alert.setHeaderText("Failed Classes: " + coursesFailed);
		alert.showAndWait();
	}
	
	public static String searchForPersonUpdate() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Person Update Window");
		dialog.setHeaderText("Use Identification Number to Search Here.\nAny Filled Data Fields Will Be Used In Place Of The Original Data.");
		dialog.setContentText("Replace information of person with ID: ");
		Optional<String> result = dialog.showAndWait();
		return result.get();
	}
	
	public static String searchForPersonDelete() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Person Delete Window");
		dialog.setHeaderText("Use Identification Number to Search Here.\nIf a Person Is Found, He/She Will Be Deleted.");
		dialog.setContentText("Delete person with ID: ");
		Optional<String> result = dialog.showAndWait();
		return result.get();
	}
	
	public static boolean keepDeletedDataOrNot() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data delete complete");
		alert.setHeaderText("Person Deleted Successfully");
		alert.setContentText("Click OK to load the deleted data or Cancel to leave data fields as they are");
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
	
	public static boolean showPersonUpdatedWithID(String id) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Person Update Complete");
		alert.setHeaderText("ID " + id + " Has Been Updated.");
		alert.setContentText("The database has been successfuly updated");
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
	
//	public static void showPersonFound() {
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Person search completed");
//		alert.setContentText("The person's information will now be loaded");
//		alert.setHeaderText("A Person With This ID Was Found");
//		alert.showAndWait();
//	}
}
