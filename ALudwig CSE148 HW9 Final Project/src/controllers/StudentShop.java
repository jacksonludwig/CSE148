package controllers;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Course;
import model.CourseBag;
import model.PersonBag;
import model.Student;
import utilities.Alerts;
import view.StudentPane;

// What needs to happen:
// Classes taken with Fs in search need to be auto moved back to "to take."

// Math regarding GPA must be fixed (most important): 
// have GPA be completely redone when something is moved; now that all classes have a grade with them,
// it can be easily done by reading each class under the taken category, searching for them to get their credits, and using the total credits
// and total gpa to get the overall gpa. 

// Search/filter menu for listview must be added
// Also all other tabs must be corrected search so that it fills in data fields (to be done last).

public class StudentShop {
	private StudentPane studentPane;
	private MenuBarShop menuBarShop;
	private PersonBag studentBag;
	private CourseBag courseBag;
	private BorderPane root;
	private ObservableList<String> allCoursesList;
	private ObservableList<String> coursesToTakeList;
	private ObservableList<String> coursesTakingList;
	private ObservableList<String> coursesTakenList;
	private double weightedGpa;
	private int credits;

	public StudentShop(PersonBag studentBag, CourseBag courseBag, MenuBarShop menuBarShop, BorderPane root) {
		weightedGpa = 0;
		credits = 0;
		HashSet<String> allCourses = new HashSet<String>();
		HashSet<String> coursesToTake = new HashSet<String>();
		HashSet<String> coursesTaking = new HashSet<String>();
		HashSet<String> coursesTaken = new HashSet<String>();
		for (int i = 0; i < courseBag.getnElems(); i++) {
			allCourses.add(courseBag.getCourse(i).getCourseTitleShort());
		}
		allCoursesList = FXCollections.observableArrayList(allCourses);
		coursesToTakeList = FXCollections.observableArrayList(coursesToTake);
		coursesTakingList = FXCollections.observableArrayList(coursesTaking);
		coursesTakenList = FXCollections.observableArrayList(coursesTaken);
		FXCollections.sort(allCoursesList);
		studentPane = new StudentPane(allCoursesList, coursesToTakeList, coursesTakingList, coursesTakenList);
		this.menuBarShop = menuBarShop;
		this.studentBag = studentBag;
		this.courseBag = courseBag;
		this.root = root;
		setCallbacks();
	}

	public Pane getStudentPane() {
		return studentPane.getStudentPane();
	}

	private void setCallbacks() {
		menuBarShop.getInsertStudentMenuItem().setOnAction(e -> {
			root.setCenter(studentPane.getStudentPane());
		});

		studentPane.getMoveClassNearRightButton().setOnAction(e -> {
			String potential = studentPane.getCoursesListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesListView().getSelectionModel().clearSelection();
				allCoursesList.remove(potential);
				coursesToTakeList.add(potential);
				sortLists();
			}
		});

		studentPane.getMoveClassNearLeftButton().setOnAction(e -> {
			String potential = studentPane.getCoursesToTakeListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesToTakeListView().getSelectionModel().clearSelection();
				coursesToTakeList.remove(potential);
				allCoursesList.add(potential);
				sortLists();
			}
		});

		studentPane.getMoveClassRightButton().setOnAction(e -> {
			String potential = studentPane.getCoursesToTakeListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesToTakeListView().getSelectionModel().clearSelection();
				coursesToTakeList.remove(potential);
				coursesTakingList.add(potential);
				sortLists();
			}
		});

		studentPane.getMoveClassLeftButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesTakingListView().getSelectionModel().clearSelection();
				coursesTakingList.remove(potential);
				coursesToTakeList.add(potential);
				sortLists();
			}
		});

//		studentPane.getMoveClassFarRightButton().setOnAction(e -> {
//			String potential = studentPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
//			if (potential != null) {
//				Course course = courseBag.findByCourseTitleShort(potential);
//				String grade = Alerts.confirmClassGradeWeighted(course.getNumberOfCredits());
//				if (Double.parseDouble(grade.substring(0, 3)) > 0) {
//					studentPane.getCoursesTakingListView().getSelectionModel().clearSelection();
//					coursesTakingList.remove(potential);
//					if (grade.substring(4).charAt(0) == ',') {
//						coursesTakenList.add(potential + grade.substring(4));
//					} else {
//						coursesTakenList.add(potential + ',' + grade.substring(4));
//					}
//					adjustGpa(coursesTakenList);
//					sortLists();
//					System.out.println(weightedGpa);
//				} else {
//					Alerts.showClassFailed();
//				}
//			}
//		});

		studentPane.getMoveClassFarRightButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				String grade = Alerts.confirmClassGrade();
				if (!(grade.equals("F"))) {
					studentPane.getCoursesTakingListView().getSelectionModel().clearSelection();
					coursesTakingList.remove(potential);
					coursesTakenList.add(potential + grade);
					adjustGpa(coursesTakenList);
					sortLists();
					System.out.println(weightedGpa);
				} else {
					Alerts.showClassFailed();
				}
			}
		});

		studentPane.getMoveClassFarLeftButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakenListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				studentPane.getCoursesTakenListView().getSelectionModel().clearSelection();
				coursesTakenList.remove(potential);
				coursesTakingList.add(potential.substring(0, 6));
				adjustGpa(coursesTakenList);
				sortLists();
			}
		});

		studentPane.getInsertBtn().setOnAction(e -> {
			String first = studentPane.getFirst();
			String last = studentPane.getLast();
			String phoneNumber = studentPane.getPhoneNumber();
			String major = studentPane.getMajor();

			if (first.equals("") || last.equals("") || phoneNumber.equals("")) {
				Alerts.showFillAllFields();
			} else if (major == null) {
				Alerts.showMajorNotChosen();
			} else {
				ArrayList<String> coursesToTake = new ArrayList<>();
				for (int i = 0; i < coursesToTakeList.size(); i++) {
					coursesToTake.add(coursesToTakeList.get(i));
				}
				ArrayList<String> coursesTaking = new ArrayList<>();
				for (int i = 0; i < coursesTakingList.size(); i++) {
					coursesTaking.add(coursesTakingList.get(i));
				}
				ArrayList<String> coursesTaken = new ArrayList<>();
				for (int i = 0; i < coursesTakenList.size(); i++) {
					coursesTaken.add(coursesTakenList.get(i));
				}
				Student student = null;
				do {
					student = new Student(first, last, phoneNumber, major, coursesToTake, coursesTaking, coursesTaken,
							weightedGpa);
				} while (studentBag.findById(student.getId()) != null);

				studentBag.insert(student);
				if (Alerts.showItemInsertedAndId(student.getId())) {
					studentPane.clearAllFields();
				}
			}
		});

		studentPane.getSearchBtn().setOnAction(e -> {
			String id = Alerts.searchForPerson();
			Student searchedStudent = null;
			try {
				searchedStudent = (Student) studentBag.findById(id);
			} catch (ClassCastException e1) {
				Alerts.showWrongPerson();

			}

			if (searchedStudent != null) {
				coursesToTakeList.clear();
				coursesTakingList.clear();
				coursesTakenList.clear();
				if (Alerts.showPersonFound()) {
					studentPane.clearAllFields();
				} else {
					studentPane.setFirstNameField(searchedStudent.getFirstName());
					studentPane.setLastNameField(searchedStudent.getLastName());
					studentPane.setPhoneNumberField(searchedStudent.getPhoneNumber());
					studentPane.setIdField(searchedStudent.getId());
					studentPane.setMajorBox(searchedStudent.getMajor());

					for (int i = 0; i < searchedStudent.getCoursesToTake().size(); i++) {
						String course = searchedStudent.getCoursesToTake().get(i);
						allCoursesList.remove(course);
						coursesToTakeList.add(course);
					}
					for (int i = 0; i < searchedStudent.getCoursesTaking().size(); i++) {
						String course = searchedStudent.getCoursesTaking().get(i);
						coursesTakingList.add(course);
					}
					int failedCourseCount = 0;
					for (int i = 0; i < searchedStudent.getCoursesTaken().size(); i++) {
						String course = searchedStudent.getCoursesTaken().get(i);
						if (course.substring(7).equals("F")) {
							coursesToTakeList.add(course.substring(0, 6));
							failedCourseCount++;
						} else {
							coursesTakenList.add(course);
						}

					}
					adjustGpa(coursesTakenList);
					if (failedCourseCount > 0) {
						Alerts.showFailedCourseAutoMoved(failedCourseCount);
					}
					sortLists();
				}
			} else {
				Alerts.showPersonNotFound();
			}
		});

		studentPane.getUpdateBtn().setOnAction(e -> {
//			String title = studentPane.getTitle();
//			String isbn = studentPane.getIsbn();
//			String authorFirst = studentPane.getAuthorFirst();
//			String authorLast = studentPane.getAuthorLast();
//			double price = studentPane.getPrice();
//			Student student = new Student(title, isbn, authorFirst, authorLast, price);
//
//			Student temp = studentBag.findByTitle(title);
//			if (temp != null) {
//				studentBag.deleteByTitle(temp.getTitle());
//				studentBag.insert(student);
//				if (Alerts.showItemUpdated()) {
//					studentPane.clearAllFields();
//				}
//			} else {
//				if (Alerts.showItemNotUpdated()) {
//					studentPane.clearAllFields();
//				}
//			}
		});

		studentPane.getDeleteBtn().setOnAction(e -> {
//			String title = studentPane.getTitle();
//			if (studentBag.findByTitle(title) != null) {
//				studentBag.deleteByTitle(title);
//				if (Alerts.showItemDeleted()) {
//					studentPane.clearAllFields();
//				}
//			} else {
//				if (Alerts.showItemNotDeleted()) {
//					studentPane.clearAllFields();
//				}
//			}
		});
	}

	public void adjustGpa(ObservableList<String> coursesWithGrades) {
		double totalPoints = 0;
		int totalCredits = 0;
		for (int i = 0; i < coursesWithGrades.size(); i++) {
			String courseAndGrade = coursesWithGrades.get(i);
			double classCredits;
			try {
				classCredits = courseBag.findByCourseTitleShort(courseAndGrade.substring(0, 6)).getNumberOfCredits();
			} catch (NullPointerException e) {
				classCredits = 0;
			}
			if (courseAndGrade.substring(7).equals("A")) {
				totalPoints += (4.0 * classCredits);
				totalCredits += classCredits;
			} else if (courseAndGrade.substring(7).equals("B+")) {
				totalPoints += (3.5 * classCredits);
				totalCredits += classCredits;
			} else if (courseAndGrade.substring(7).equals("B")) {
				totalPoints += (3.0 * classCredits);
				totalCredits += classCredits;
			} else if (courseAndGrade.substring(7).equals("C+")) {
				totalPoints += (2.5 * classCredits);
				totalCredits += classCredits;
			} else if (courseAndGrade.substring(7).equals("C")) {
				totalPoints += (2.0 * classCredits);
				totalCredits += classCredits;
			} else if (courseAndGrade.substring(7).equals("D+")) {
				totalPoints += (1.5 * classCredits);
				totalCredits += classCredits;
			} else if (courseAndGrade.substring(7).equals("D")) {
				totalPoints += (1.0 * classCredits);
				totalCredits += classCredits;
			} else {
				totalPoints += (0.0 * classCredits);
				totalCredits += classCredits;
			}
		}
		weightedGpa = (totalPoints / totalCredits);
		String gpa = String.format("%.2f", weightedGpa);
		studentPane.setDynamicGpa(Double.parseDouble(gpa));
		if (totalCredits <= 0 || totalPoints <= 0) {
			studentPane.setDynamicGpa(0.0);
		}
	}

	public void sortLists() {
		FXCollections.sort(allCoursesList);
		FXCollections.sort(coursesToTakeList);
		FXCollections.sort(coursesTakingList);
		FXCollections.sort(coursesTakenList);
	}
}