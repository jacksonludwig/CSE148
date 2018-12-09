package controllers;

// ADD IMPORT/EXPORT FOR EACH ITEM UNDER FILE CATEGORY

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import model.College;
import model.FileSaver;

public class MenuBarShop {
	private College college;
	
	private Menu fileMenu;
	private MenuItem exitMenuItem;

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
		fileMenu.getItems().add(exitMenuItem);
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
		// Save, show alerts, etc. here.
		exitMenuItem.setOnAction(e -> {
			FileSaver.saveAllBags(college.getPersonBag(), college.getClassroomBag(), college.getTextbookBag(),
					college.getCourseBag(), "savedFiles/allBags.dat");
			Platform.exit();
		});
	}

}