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
		alert.setContentText("Click OK to clear text fields or Cancel to leave your data");
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

	public static String confirmClassGradeWeighted(double credits) {
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
				return 4.0 * credits + ",A";
			} else if (grade.equals("B+")) {
				return 3.5 * credits + ",B+";
			} else if (grade.equals("B")) {
				return 3.0 * credits + ",B";
			} else if (grade.equals("C+")) {
				return 2.5 * credits + ",C+";
			} else if (grade.equals("C")) {
				return 2.0 * credits + ",C";
			} else if (grade.equals("D+")) {
				return 1.5 * credits + ",D+";
			} else if (grade.equals("D")) {
				return 1.0 * credits + ",D";
			} else {
				return 0.0 + ",F";
			}
		}
		return -1 + ",F";
	}

	public static double fillClassGradeWeighted(String grade, double credits) {
		if (grade.equals("A")) {
			return 4.0 * credits;
		} else if (grade.equals("B+")) {
			return 3.5 * credits;
		} else if (grade.equals("B")) {
			return 3.0 * credits;
		} else if (grade.equals("C+")) {
			return 2.5 * credits;
		} else if (grade.equals("C")) {
			return 2.0 * credits;
		} else if (grade.equals("D+")) {
			return 1.5 * credits;
		} else if (grade.equals("D")) {
			return 1.0 * credits;
		} else {
			return 0.0;
		}
	}

//	public static double confirmClassGradeWeighted(double credits) {
//		String[] grades = { "A", "B+", "B", "C+", "C", "D+", "D", "F" };
//		ChoiceDialog<String> dialog = new ChoiceDialog<>("Grade", grades);
//		dialog.setTitle("Grade Selection");
//		dialog.setHeaderText("The Grade For The Class Is Required");
//		dialog.setContentText("Choose your letter grade:");
//		Optional<String> result = dialog.showAndWait();
//		String grade = "";
//		if (result.isPresent()){
//		    grade = result.get();
//		    
//		    if (grade.equals("A")) {
//				return 4.0 * credits;
//			} else if (grade.equals("B+")) {
//				return 3.5 * credits;
//			} else if (grade.equals("B")) {
//				return 3.0 * credits;
//			} else if (grade.equals("C+")) {
//				return 2.5 * credits;
//			} else if (grade.equals("C")) {
//				return 2.0 * credits;
//			} else if (grade.equals("D+")) {
//				return 1.5 * credits;
//			} else if (grade.equals("D")) {
//				return 1.0 * credits;
//			} else {
//				return 0.0;
//			}
//		}
//		return -1;
//	}

	public static double confirmClassGradeForRemoval(String grade, double credits) {
		if (grade.equals("A")) {
			return 4.0 * credits;
		} else if (grade.equals("B+")) {
			return 3.5 * credits;
		} else if (grade.equals("B")) {
			return 3.0 * credits;
		} else if (grade.equals("C+")) {
			return 2.5 * credits;
		} else if (grade.equals("C")) {
			return 2.0 * credits;
		} else if (grade.equals("D+")) {
			return 1.5 * credits;
		} else if (grade.equals("D")) {
			return 1.0 * credits;
		} else {
			return 0.0;
		}
	}

//	public static String confirmClassGradeForRemoval(double credits) {
//		String[] grades = { "A", "B+", "B", "C+", "C", "D+", "D", "F" };
//		ChoiceDialog<String> dialog = new ChoiceDialog<>("Grade", grades);
//		dialog.setTitle("Student GPA Adjustment");
//		dialog.setHeaderText("Please Enter the Grade The Student Earned In This Class");
//		dialog.setContentText("Choose the student's letter grade:");
//		Optional<String> result = dialog.showAndWait();
//		String grade = "";
//		if (result.isPresent()){
//		    grade = result.get();
//		    
//		    if (grade.equals("A")) {
//				return 4.0 * credits + ", A";
//			} else if (grade.equals("B+")) {
//				return 3.5 * credits + ", B+";
//			} else if (grade.equals("B")) {
//				return 3.0 * credits + ", B";
//			} else if (grade.equals("C+")) {
//				return 2.5 * credits + ", C+";
//			} else if (grade.equals("C")) {
//				return 2.0 * credits + ", C";
//			} else if (grade.equals("D+")) {
//				return 1.5 * credits + ", D+";
//			} else if (grade.equals("D")) {
//				return 1.0 * credits + ", D";
//			} else {
//				return 0.0 + ", F";
//			}
//		}
//		return -1 + ", F";
//	}

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

	public static boolean showPersonFound() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Data search complete");
		alert.setHeaderText("Item Found Successfully");
		alert.setContentText("Click OK to load the person's data or Cancel to leave your data");
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
