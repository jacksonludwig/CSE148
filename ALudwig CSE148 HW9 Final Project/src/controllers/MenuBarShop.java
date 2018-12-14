package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.ClassroomBag;
import model.College;
import model.CourseBag;
import model.DataImporter;
import model.Faculty;
import model.FileSaver;
import model.Person;
import model.PersonBag;
import model.Student;
import model.TextbookBag;
import utilities.Alerts;
import utilities.Utilities;

public class MenuBarShop {
	private College college;

	private Menu fileMenu;
	private MenuItem exitMenuItem;
	private MenuItem saveMenuItem;
	private MenuItem saveAsMenuItem;
	private MenuItem loadMenuItem;
	private MenuItem loadFromMenuItem;
	private Menu importMenu;
	private MenuItem importTextbooks;
	private MenuItem importClassrooms;
	private MenuItem importCourses;
	private MenuItem importFaculty;
	private MenuItem importStudents;
	private Menu exportMenu;
	private MenuItem exportTextbooks;
	private MenuItem exportClassrooms;
	private MenuItem exportCourses;
	private MenuItem exportFaculty;
	private MenuItem exportStudents;

	private Menu studentMenu;
	private MenuItem insertStudentMenuItem;

	private Menu facultyMenu;
	private MenuItem insertFacultyMenuItem;

	private Menu classroomMenu;
	private MenuItem insertClassroomMenuItem;

	private Menu textbookMenu;
	private MenuItem insertTextbookMenuItem;

	private Menu courseMenu;
	private MenuItem insertCourseMenuItem;

	private MenuBar menuBar;

	public MenuBarShop(College college, BorderPane root) {
		this.college = college;
		buildMenuBar();
		buildFileMenu();
		buildStudentMenu();
		buildFacultyMenu();
		buildClassroomMenu();
		buildTextbookMenu();
		buildCourseMenu();
		setCallbacks();
		menuBar.getMenus().addAll(fileMenu, studentMenu, facultyMenu, classroomMenu, textbookMenu, courseMenu);
		root.setTop(menuBar);
	}

	private void buildMenuBar() {
		menuBar = new MenuBar();
	}

	private void buildFileMenu() {
		fileMenu = new Menu("FILE");
		exitMenuItem = new MenuItem("EXIT");
		saveMenuItem = new MenuItem("Save");
		saveAsMenuItem = new MenuItem("Save as...");
		loadMenuItem = new MenuItem("Load");
		loadFromMenuItem = new MenuItem("Load from...");
		importMenu = new Menu("Import...");
		importTextbooks = new MenuItem("Textbooks");
		importClassrooms = new MenuItem("Classrooms");
		importCourses = new MenuItem("Courses");
		importFaculty = new MenuItem("Faculty");
		importStudents = new MenuItem("Students");
		exportMenu = new Menu("Export...");
		exportTextbooks = new MenuItem("Textbooks");
		exportClassrooms = new MenuItem("Classrooms");
		exportCourses = new MenuItem("Courses");
		exportFaculty = new MenuItem("Faculty");
		exportStudents = new MenuItem("Students");
		importMenu.getItems().addAll(importTextbooks, importClassrooms, importCourses, importStudents, importFaculty);
		exportMenu.getItems().addAll(exportTextbooks, exportClassrooms, exportCourses, exportStudents, exportFaculty);
		fileMenu.getItems().addAll(saveMenuItem, saveAsMenuItem, loadMenuItem, loadFromMenuItem, importMenu, exportMenu,
				exitMenuItem);
	}

	private void buildStudentMenu() {
		studentMenu = new Menu("STUDENT");
		insertStudentMenuItem = new MenuItem("EDIT");
		studentMenu.getItems().add(insertStudentMenuItem);
	}

	private void buildFacultyMenu() {
		facultyMenu = new Menu("FACULTY");
		insertFacultyMenuItem = new MenuItem("EDIT");
		facultyMenu.getItems().add(insertFacultyMenuItem);
	}

	private void buildClassroomMenu() {
		classroomMenu = new Menu("CLASSROOM");
		insertClassroomMenuItem = new MenuItem("EDIT");
		classroomMenu.getItems().add(insertClassroomMenuItem);
	}

	private void buildTextbookMenu() {
		textbookMenu = new Menu("TEXTBOOK");
		insertTextbookMenuItem = new MenuItem("EDIT");
		textbookMenu.getItems().add(insertTextbookMenuItem);
	}

	private void buildCourseMenu() {
		courseMenu = new Menu("COURSE");
		insertCourseMenuItem = new MenuItem("EDIT");
		courseMenu.getItems().add(insertCourseMenuItem);
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public MenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public MenuItem getInsertStudentMenuItem() {
		return insertStudentMenuItem;
	}

	public MenuItem getInsertFacultyMenuItem() {
		return insertFacultyMenuItem;
	}

	public MenuItem getInsertClassroomMenuItem() {
		return insertClassroomMenuItem;
	}

	public MenuItem getInsertTextbookMenuItem() {
		return insertTextbookMenuItem;
	}

	public MenuItem getInsertCourseMenuItem() {
		return insertCourseMenuItem;
	}

	private void setCallbacks() {
		saveMenuItem.setOnAction(e -> {
			FileSaver.saveAllBags(college.getPersonBag(), college.getClassroomBag(), college.getTextbookBag(),
					college.getCourseBag(), "savedFiles/allBags.dat");
			Alerts.showAllSaved();
		});

		saveAsMenuItem.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save Binary File");
			File initialDir = new File("savedFiles");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary Files (*.dat)", "*.dat");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				FileSaver.saveAllBags(college.getPersonBag(), college.getClassroomBag(), college.getTextbookBag(),
						college.getCourseBag(), file.getAbsolutePath());
				Alerts.showNewSaved();
			}
		});

		loadMenuItem.setOnAction(e -> {
			Utilities.load(college, "savedFiles/allBags.dat");
			Alerts.showAllLoaded();
		});
		
		loadFromMenuItem.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Load Binary File");
			File initialDir = new File("savedFiles");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary Files (*.dat)", "*.dat");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				Utilities.load(college, file.getAbsolutePath());
				Alerts.showNewLoaded();
			}
		});

		importTextbooks.setOnAction(e -> {
			TextbookBag newTextBag = new TextbookBag(500);
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Import Textbook File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				DataImporter.importTextbooks(newTextBag, file.getAbsolutePath());
				if (Alerts.updateOrReplaceCheck()) {
					college.setTextbookBag(newTextBag);
				} else {
					for (int i = 0; i < newTextBag.getnElems(); i++) {
						if (college.getTextbookBag().findByTitle(newTextBag.getArr()[i].getTitle()) == null) {
							college.getTextbookBag().insert(newTextBag.getArr()[i]);
						}
					}
				}
				Alerts.showFileImported();
			}
		});

		exportTextbooks.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Export Textbook File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < college.getTextbookBag().getnElems(); i++) {
					pw.println(college.getTextbookBag().getArr()[i].getTitle() + "*"
							+ college.getTextbookBag().getArr()[i].getAuthorFirstName() + "*"
							+ college.getTextbookBag().getArr()[i].getAuthorLastName() + "*"
							+ college.getTextbookBag().getArr()[i].getISBN() + "*"
							+ college.getTextbookBag().getArr()[i].getPrice() + "*");
				}
				pw.close();
				Alerts.showFileExported();
			}
		});

		importClassrooms.setOnAction(e -> {
			ClassroomBag newClassBag = new ClassroomBag(500);
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Import Classroom File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				DataImporter.importClassrooms(newClassBag, file.getAbsolutePath());
				if (Alerts.updateOrReplaceCheck()) {
					college.setClassroomBag(newClassBag);
				} else {
					for (int i = 0; i < newClassBag.getnElems(); i++) {
						if (college.getClassroomBag().findByRoom(newClassBag.getArr()[i].getRoomNumber()) == null) {
							college.getClassroomBag().insert(newClassBag.getArr()[i]);
						}
					}
				}
				Alerts.showFileImported();
			}
		});

		exportClassrooms.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Export Classroom File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < college.getClassroomBag().getnElems(); i++) {
					pw.println(college.getClassroomBag().getArr()[i].getRoomNumber() + "*"
							+ college.getClassroomBag().getArr()[i].getBuildingName() + "*"
							+ college.getClassroomBag().getArr()[i].getNumberOfSeats() + "*"
							+ college.getClassroomBag().getArr()[i].getNumberOfComputers() + "*"
							+ college.getClassroomBag().getArr()[i].isProjectorOrNot() + "*");
				}
				pw.close();
				Alerts.showFileExported();
			}
		});

		importCourses.setOnAction(e -> {
			CourseBag newCourseBag = new CourseBag(4000);
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Import Course File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				DataImporter.importCourses(newCourseBag, file.getAbsolutePath());
				if (Alerts.updateOrReplaceCheck()) {
					college.setCourseBag(newCourseBag);
				} else {
					for (int i = 0; i < newCourseBag.getnElems(); i++) {
						if (college.getCourseBag()
								.findByCourseTitleShort(newCourseBag.getArr()[i].getCourseTitleShort()) == null) {
							college.getCourseBag().insert(newCourseBag.getArr()[i]);
						}
					}
				}
				Alerts.showFileImported();
			}
		});

		exportCourses.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Export Course File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < college.getCourseBag().getnElems(); i++) {
					pw.println(college.getCourseBag().getArr()[i].getCourseTitleShort() + "* "
							+ college.getCourseBag().getArr()[i].getCourseTitleLong() + "* "
							+ college.getCourseBag().getArr()[i].getCourseDescription() + "* "
							+ college.getCourseBag().getArr()[i].getNumberOfCredits() + "* "
							+ college.getCourseBag().getArr()[i].getFacultyID() + "* "
							+ college.getCourseBag().getArr()[i].getClassroom() + "* "
							+ college.getCourseBag().getArr()[i].getTextbookISBN() + "* ");
				}
				pw.close();
				Alerts.showFileExported();
			}
		});

		importFaculty.setOnAction(e -> {
			PersonBag newFacultyBag = new PersonBag(4000);
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Import Faculty File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				DataImporter.importFaculty(newFacultyBag, file.getAbsolutePath());
				if (Alerts.updateOrReplaceCheck()) {
					for (int i = 0; i < college.getPersonBag().getnElems(); i++) {
						boolean isFaculty;
						try {
							Person testPerson = (Faculty) college.getPersonBag()
									.findById(college.getPersonBag().getArr()[i].getId());
							isFaculty = true;
						} catch (ClassCastException e1) {
							isFaculty = false;
						}
						if (isFaculty) {
							college.getPersonBag().deleteById(college.getPersonBag().getArr()[i].getId());
						}
					}
					for (int i = 0; i < newFacultyBag.getnElems(); i++) {
						college.getPersonBag().insert((Faculty) newFacultyBag.getArr()[i]);
					}
				} else {
					for (int i = 0; i < newFacultyBag.getnElems(); i++) {
						if (college.getPersonBag().findById(newFacultyBag.getArr()[i].getId()) == null) {
							college.getPersonBag().insert((Faculty) newFacultyBag.getArr()[i]);
						}
					}
				}
				Alerts.showFileImported();
			}
		});

		exportFaculty.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Export Faculty File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < college.getPersonBag().getnElems(); i++) {
					boolean isFaculty;
					try {
						Person testPerson = (Faculty) college.getPersonBag()
								.findById(college.getPersonBag().getArr()[i].getId());
						isFaculty = true;
					} catch (ClassCastException e1) {
						isFaculty = false;
					}
					if (isFaculty) {
						Faculty faculty = (Faculty) college.getPersonBag().getArr()[i];
						String coursesTeaching = "";
						for (int j = 0; j < faculty.getCoursesTeaching().size(); j++) {
							coursesTeaching += faculty.getCoursesTeaching().get(j) + ",";
						}
						pw.println(faculty.getFirstName() + "*" + faculty.getLastName() + "*" + faculty.getId() + "*"
								+ faculty.getPhoneNumber() + "*" + faculty.getDepartment() + "*" + coursesTeaching + "*"
								+ faculty.getSalary() + "*");
					}
				}
				pw.close();
				Alerts.showFileExported();
			}
		});

		importStudents.setOnAction(e -> {
			PersonBag newStudentBag = new PersonBag(4000);
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Import Student File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showOpenDialog(null);
			if (file != null) {
				DataImporter.importStudents(newStudentBag, file.getAbsolutePath());
				if (Alerts.updateOrReplaceCheck()) {
					for (int i = 0; i < college.getPersonBag().getnElems(); i++) {
						boolean isStudent;
						try {
							Person testPerson = (Student) college.getPersonBag()
									.findById(college.getPersonBag().getArr()[i].getId());
							isStudent = true;
						} catch (ClassCastException e1) {
							isStudent = false;
						}
						if (isStudent) {
							college.getPersonBag().deleteById(college.getPersonBag().getArr()[i].getId());
						}
					}
					for (int i = 0; i < newStudentBag.getnElems(); i++) {
						college.getPersonBag().insert((Student) newStudentBag.getArr()[i]);
					}
				} else {
					for (int i = 0; i < newStudentBag.getnElems(); i++) {
						if (college.getPersonBag().findById(newStudentBag.getArr()[i].getId()) == null) {
							college.getPersonBag().insert((Student) newStudentBag.getArr()[i]);
						}
					}
				}
				Alerts.showFileImported();
			}
		});

		exportStudents.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Export Student File");
			File initialDir = new File("outputData");
			fileChooser.setInitialDirectory(initialDir);
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				PrintWriter pw = null;
				try {
					pw = new PrintWriter(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < college.getPersonBag().getnElems(); i++) {
					boolean isStudent;
					try {
						Person testPerson = (Student) college.getPersonBag()
								.findById(college.getPersonBag().getArr()[i].getId());
						isStudent = true;
					} catch (ClassCastException e1) {
						isStudent = false;
					}
					if (isStudent) {
						Student student = (Student) college.getPersonBag().getArr()[i];
						String coursesToTake = "";
						for (int j = 0; j < student.getCoursesToTake().size(); j++) {
							coursesToTake += student.getCoursesToTake().get(j) + ",";
						}
						String coursesTaking = "";
						for (int j = 0; j < student.getCoursesTaking().size(); j++) {
							coursesTaking += student.getCoursesTaking().get(j) + ",";
						}
						String coursesTaken = "";
						for (int j = 0; j < student.getCoursesTaken().size(); j++) {
							coursesTaken += student.getCoursesTaken().get(j) + ",";
						}
						pw.println(student.getFirstName() + "*" + student.getLastName() + "*" + student.getId() + "*"
								+ student.getPhoneNumber() + "*" + student.getMajor() + "*" + coursesToTake + "*"
								+ coursesTaking + "*" + coursesTaken + "*" + student.getGpa() + "*");
					}
				}
				pw.close();
				Alerts.showFileExported();
			}
		});

		exitMenuItem.setOnAction(e -> {
			if (Alerts.closeCheck()) {
				final FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save Binary File");
				File initialDir = new File("savedFiles");
				fileChooser.setInitialDirectory(initialDir);
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Binary Files (*.dat)", "*.dat");
				fileChooser.getExtensionFilters().add(extFilter);
				File file = fileChooser.showSaveDialog(null);
				if (file != null) {
					FileSaver.saveAllBags(college.getPersonBag(), college.getClassroomBag(), college.getTextbookBag(),
							college.getCourseBag(), file.getAbsolutePath());
					Alerts.showNewSaved();
				}
			}
			Platform.exit();
		});
	}

}
