package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.CourseBag;
import model.Faculty;
import model.PersonBag;
import utilities.Alerts;
import view.FacultyPane;

public class FacultyShop {
	private FacultyPane facultyPane;
	private MenuBarShop menuBarShop;
	private PersonBag facultyBag;
	private BorderPane root;
	private ObservableList<String> allCoursesList;
	private ObservableList<String> coursesTakingList;

	public FacultyShop(PersonBag facultyBag, CourseBag courseBag, MenuBarShop menuBarShop, BorderPane root) {
		HashSet<String> allCourses = new HashSet<String>();
		HashSet<String> coursesTaking = new HashSet<String>();
		for (int i = 0; i < courseBag.getnElems(); i++) {
			allCourses.add(courseBag.getCourse(i).getCourseTitleShort());
		}
		allCoursesList = FXCollections.observableArrayList(allCourses);
		coursesTakingList = FXCollections.observableArrayList(coursesTaking);
		FXCollections.sort(allCoursesList);
		facultyPane = new FacultyPane(allCoursesList, coursesTakingList);
		this.menuBarShop = menuBarShop;
		this.facultyBag = facultyBag;
		this.root = root;
		setCallbacks();
	}

	public Pane getFacultyPane() {
		return facultyPane.getFacultyPane();
	}

	private void setCallbacks() {
		menuBarShop.getInsertFacultyMenuItem().setOnAction(e -> {
			root.setCenter(facultyPane.getFacultyPane());
		});

		facultyPane.getMoveClassNearRightButton().setOnAction(e -> {
			String potential = facultyPane.getCoursesListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				facultyPane.getCoursesListView().getSelectionModel().clearSelection();
				allCoursesList.remove(potential);
				coursesTakingList.add(potential);
				sortLists();
			}
		});

		facultyPane.getMoveClassNearLeftButton().setOnAction(e -> {
			String potential = facultyPane.getCoursesTakingListView().getSelectionModel().getSelectedItem();
			if (potential != null) {
				facultyPane.getCoursesTakingListView().getSelectionModel().clearSelection();
				coursesTakingList.remove(potential);
				allCoursesList.add(potential);
				sortLists();
			}
		});

		facultyPane.getInsertBtn().setOnAction(e -> {
			String first = facultyPane.getFirst();
			String last = facultyPane.getLast();
			String major = facultyPane.getDepartment();

			if (first.equals("") || last.equals("")) {
				Alerts.showFillAllFields();
			} else if (major == null) {
				Alerts.showMajorNotChosen();
			} else {
				ArrayList<String> coursesTaking = new ArrayList<>();
				for (int i = 0; i < coursesTakingList.size(); i++) {
					coursesTaking.add(coursesTakingList.get(i));
				}
				Faculty faculty = null;
				do {
					faculty = new Faculty(first, last, major, coursesTaking);
				} while (facultyBag.findById(faculty.getId()) != null);

				facultyBag.insert(faculty);
				if (Alerts.showItemInsertedAndId(faculty.getId())) {
					facultyPane.clearAllFields();
				}
			}
		});

		facultyPane.getSearchBtn().setOnAction(e -> {
			String id;
			try {
				id = Alerts.searchForPerson();
			} catch (NoSuchElementException e2) {
				id = null;
			}
			if (id != null) {
				Faculty searchedFaculty = null;
				try {
					searchedFaculty = (Faculty) facultyBag.findById(id);
				} catch (ClassCastException e1) {
					Alerts.showWrongPersonFaculty();
				}

				if (searchedFaculty != null) {
					coursesTakingList.clear();
					if (Alerts.showPersonFound()) {
						facultyPane.clearAllFields();
					} else {
						facultyPane.setFirstNameField(searchedFaculty.getFirstName());
						facultyPane.setLastNameField(searchedFaculty.getLastName());
						facultyPane.setIdField(searchedFaculty.getId());
						facultyPane.setDepartmentBox(searchedFaculty.getDepartment());

						for (int i = 0; i < searchedFaculty.getCoursesTeaching().size(); i++) {
							String course = searchedFaculty.getCoursesTeaching().get(i);
							coursesTakingList.add(course);
						}

						sortLists();
					}
				} else {
					Alerts.showPersonNotFoundFaculty();
				}
			}

		});

		facultyPane.getUpdateBtn().setOnAction(e -> {
			String first = facultyPane.getFirst();
			String last = facultyPane.getLast();
			String major = facultyPane.getDepartment();

			String id;
			try {
				id = Alerts.searchForPersonUpdate();
			} catch (NoSuchElementException e2) {
				id = null;
			}
			if (id != null && facultyBag.findById(id) != null) {
				Faculty faculty = (Faculty) facultyBag.deleteById(id);

				if (!(first.equals(""))) {
					faculty.setFirstName(first);
				}
				if (!(last.equals(""))) {
					faculty.setLastName(last);
				}
				if (major != "" || major != null) {
					faculty.setDepartment(major);
				}
				if (coursesTakingList.size() > 0) {
					ArrayList<String> coursesTaking = new ArrayList<>();
					for (int i = 0; i < coursesTakingList.size(); i++) {
						coursesTaking.add(coursesTakingList.get(i));
					}
					faculty.setCoursesTeaching(coursesTaking);
				}
				facultyBag.insert(faculty);
				if (Alerts.showPersonUpdatedWithID(faculty.getId())) {
					facultyPane.clearAllFields();
				}
			}
		});

		facultyPane.getDeleteBtn().setOnAction(e -> {
			String id;
			try {
				id = Alerts.searchForPersonDelete();
			} catch (NoSuchElementException e2) {
				id = null;
			}
			if (id != null) {
				Faculty searchedFaculty = null;
				try {
					searchedFaculty = (Faculty) facultyBag.deleteById(id);
				} catch (ClassCastException e1) {
					Alerts.showWrongPersonFaculty();
				}

				if (searchedFaculty != null && Alerts.keepDeletedDataOrNot()) {
					coursesTakingList.clear();
					facultyPane.setFirstNameField(searchedFaculty.getFirstName());
					facultyPane.setLastNameField(searchedFaculty.getLastName());
					facultyPane.setIdField(searchedFaculty.getId());
					facultyPane.setDepartmentBox(searchedFaculty.getDepartment());

					for (int i = 0; i < searchedFaculty.getCoursesTeaching().size(); i++) {
						String course = searchedFaculty.getCoursesTeaching().get(i);
						coursesTakingList.add(course);
					}

					sortLists();
				} else {
					Alerts.showPersonNotFoundFaculty();
				}
			}

		});

		facultyPane.getFilterInput().textProperty().addListener(e -> {
			String filter = facultyPane.getFilterInput().getText();
			if (filter == null || filter.length() == 0) {
				facultyPane.getCoursesList().setPredicate(l -> true);
			} else {
				facultyPane.getCoursesList().setPredicate(l -> l.contains(filter));
			}
		});
	}

	public void sortLists() {
		FXCollections.sort(allCoursesList);
		FXCollections.sort(coursesTakingList);
	}
}
