package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.CourseBag;
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

	public StudentShop(PersonBag studentBag, CourseBag courseBag, MenuBarShop menuBarShop, BorderPane root) {
		weightedGpa = 0;
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
					resetCourseLists();
				}
			}
		});

		studentPane.getSearchBtn().setOnAction(e -> {
			String id;
			try {
				id = Alerts.searchForPerson();
			} catch (NoSuchElementException e2) {
				id = null;
			}
			if (id != null) {
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
						resetCourseLists();
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
			}

		});

		studentPane.getUpdateBtn().setOnAction(e -> {
			String first = studentPane.getFirst();
			String last = studentPane.getLast();
			String phoneNumber = studentPane.getPhoneNumber();
			String major = studentPane.getMajor();

			String id;
			try {
				id = Alerts.searchForPersonUpdate();
			} catch (NoSuchElementException e2) {
				id = null;
			}
			if (id != null && studentBag.findById(id) != null) {
				Student student = (Student) studentBag.deleteById(id);

				if (!(first.equals(""))) {
					student.setFirstName(first);
				}
				if (!(last.equals(""))) {
					student.setLastName(last);
				}
				if (!(phoneNumber.equals(""))) {
					student.setPhoneNumber(phoneNumber);
				}
				if (major != "" || major != null) {
					student.setMajor(major);
				}
				if (coursesToTakeList.size() > 0) {
					ArrayList<String> coursesToTake = new ArrayList<>();
					for (int i = 0; i < coursesToTakeList.size(); i++) {
						coursesToTake.add(coursesToTakeList.get(i));
					}
					student.setCoursesToTake(coursesToTake);
				}
				if (coursesTakingList.size() > 0) {
					ArrayList<String> coursesTaking = new ArrayList<>();
					for (int i = 0; i < coursesTakingList.size(); i++) {
						coursesTaking.add(coursesTakingList.get(i));
					}
					student.setCoursesTaking(coursesTaking);
				}
				if (coursesTakenList.size() > 0) {
					ArrayList<String> coursesTaken = new ArrayList<>();
					for (int i = 0; i < coursesTakenList.size(); i++) {
						coursesTaken.add(coursesTakenList.get(i));
					}
					student.setCoursesTaken(coursesTaken);
				}
				studentBag.insert(student);
				if (Alerts.showPersonUpdatedWithID(student.getId())) {
					studentPane.clearAllFields();
					resetCourseLists();
				}
			} else {
				Alerts.showPersonNotFound();
			}
		});

		studentPane.getDeleteBtn().setOnAction(e -> {
			String id;
			try {
				id = Alerts.searchForPersonDelete();
			} catch (NoSuchElementException e2) {
				id = null;
			}
			if (id != null) {
				Student searchedStudent = null;
				try {
					searchedStudent = (Student) studentBag.deleteById(id);
				} catch (ClassCastException e1) {
					Alerts.showWrongPerson();
				}

				if (searchedStudent != null && Alerts.keepDeletedDataOrNot()) {
					coursesToTakeList.clear();
					coursesTakingList.clear();
					coursesTakenList.clear();
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
				} else {
					Alerts.showPersonNotFound();
				}
			}

		});

		studentPane.getFilterInput().textProperty().addListener(e -> {
			String filter = studentPane.getFilterInput().getText();
			if (filter == null || filter.length() == 0) {
				studentPane.getCoursesList().setPredicate(l -> true);
			} else {
				studentPane.getCoursesList().setPredicate(l -> l.contains(filter));
			}
		});
		
		studentPane.getResetListsBtn().setOnAction(e -> {
			resetCourseLists();
			studentPane.setDynamicGpa(0.0);
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

			if (classCredits != 0) {
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

		}
		if (totalCredits <= 0 || totalPoints <= 0) {
			studentPane.setDynamicGpa(0.0);
		} else {
			weightedGpa = (totalPoints / totalCredits);
			String gpa = String.format("%.2f", weightedGpa);
			studentPane.setDynamicGpa(Double.parseDouble(gpa));
			sortLists();
		}

	}

	public void resetCourseLists() {
		if (coursesToTakeList.size() > 0) {
			for(int i = 0; i < coursesToTakeList.size(); i++) {
				allCoursesList.add(coursesToTakeList.get(i));
				coursesToTakeList.remove(i);
				i--;
			}
		}
		if (coursesTakingList.size() > 0) {
			for(int i = 0; i < coursesTakingList.size(); i++) {
				allCoursesList.add(coursesTakingList.get(i));
				coursesTakingList.remove(i);
				i--;
			}
		}
		if (coursesTakenList.size() > 0) {
			for(int i = 0; i < coursesTakenList.size(); i++) {
				allCoursesList.add(coursesTakenList.get(i).substring(0, 6));
				coursesTakenList.remove(i);
				i--;
			}
		}
		weightedGpa = 0.0;
	}

	public void sortLists() {
		FXCollections.sort(allCoursesList);
		FXCollections.sort(coursesToTakeList);
		FXCollections.sort(coursesTakingList);
		FXCollections.sort(coursesTakenList);
	}
}
