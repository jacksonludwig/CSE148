package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Course;
import model.CourseBag;
import model.Person;
import model.PersonBag;
import model.Student;
import utilities.Alerts;
import view.StudentPane;

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

		studentPane.getMoveClassFarRightButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				Course course = courseBag.findByCourseTitleShort(potential);
				String grade = Alerts.confirmClassGradeWeighted(course.getNumberOfCredits());
				if (Double.parseDouble(grade.substring(0, 3)) > 0) {
					studentPane.getCoursesTakingListView().getSelectionModel().clearSelection();
					coursesTakingList.remove(potential);
					if (grade.substring(4).charAt(0) == ',') {
						coursesTakenList.add(potential + grade.substring(4));
					} else {
						coursesTakenList.add(potential + ',' + grade.substring(4));
					}
					adjustGpaAdd(Double.parseDouble(grade.substring(0, 3)), course.getNumberOfCredits());
					sortLists();
					System.out.println(weightedGpa);
				} else {
					Alerts.showClassFailed();
				}
			}
		});

		studentPane.getMoveClassFarLeftButton().setOnAction(e -> {
			String potential = studentPane.getCoursesTakenListView().getSelectionModel().getSelectedItem();
			Course course = courseBag.findByCourseTitleShort(potential.substring(0, 6));
			double grade = Alerts.confirmClassGradeForRemoval(potential.substring(7), course.getNumberOfCredits());

			if (potential != null) {
				if (grade > 0) {
					studentPane.getCoursesTakenListView().getSelectionModel().clearSelection();
					coursesTakenList.remove(potential);
					coursesTakingList.add(potential.substring(0, 6));
					adjustGpaRemove(grade, course.getNumberOfCredits());
					sortLists();
					System.out.println(weightedGpa);
				} else {
					Alerts.showClassWrongGradeEntered();
				}
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
			Student searchedStudent = (Student) studentBag.findById(id);
			// ArrayList<String> includedCourses = new ArrayList<>();
			if (searchedStudent != null) {
				coursesToTakeList.clear();
				coursesTakingList.clear();
				coursesTakenList.clear();
				if (Alerts.showItemFound()) {
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
					for (int i = 0; i < searchedStudent.getCoursesTaken().size(); i++) {
						String course = searchedStudent.getCoursesTaken().get(i);
						coursesTakenList.add(course);
					}
					for (int i = 0; i < coursesTakenList.size(); i++) {
					//	System.out.println(coursesTakenList.get(i).substring(0, 6));
						String grade = coursesTakenList.get(i).substring(7);
						Course searchedCourse = courseBag
								.findByCourseTitleShort(coursesTakenList.get(i).substring(0, 6));
				//		System.out.println(searchedCourse);
						adjustGpaAdd(Alerts.fillClassGradeWeighted(grade, searchedCourse.getNumberOfCredits()),
								searchedCourse.getNumberOfCredits());
					}

					sortLists();
				}
			} else {
				if (Alerts.showItemNotFound()) {
					studentPane.clearAllFields();
				}
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

	public void adjustGpaAdd(double weightedGrade, double credits) {
		weightedGpa *= this.credits;
		weightedGpa += weightedGrade;
		this.credits += credits;
		weightedGpa /= this.credits;
		weightedGpa = Double.parseDouble(String.format("%.2f", weightedGpa));
		studentPane.setDynamicGpa(weightedGpa);
	}

	public void adjustGpaRemove(double weightedGrade, double credits) {
		weightedGpa *= this.credits;
		weightedGpa -= weightedGrade;
		this.credits -= credits;
		weightedGpa /= this.credits;
		weightedGpa = Double.parseDouble(String.format("%.2f", weightedGpa));
		if (this.credits <= 0) {
			weightedGpa = 0.0;
		}
		if (!(weightedGpa > 0)) {
			weightedGpa = 0.0;
		}
		studentPane.setDynamicGpa(weightedGpa);
	}

	public void sortLists() {
		FXCollections.sort(allCoursesList);
		FXCollections.sort(coursesToTakeList);
		FXCollections.sort(coursesTakingList);
		FXCollections.sort(coursesTakenList);
	}
}