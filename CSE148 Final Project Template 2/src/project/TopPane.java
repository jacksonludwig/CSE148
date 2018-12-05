package project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TopPane {
	private MenuBar menuBar;

	private Menu fileMenu;
	private Menu operationMenu;
	private Menu importMenu;
	private Menu exportMenu;

	private MenuItem saveMenuItem;
	private MenuItem loadMenuItem;
	private MenuItem studentMenuItemImport;
	private MenuItem facultyMenuItemImport;
	private MenuItem classroomMenuItemImport;
	private MenuItem courseMenuItemImport;
	private MenuItem textbookMenuItemExport;
	private MenuItem studentMenuItemExport;
	private MenuItem facultyMenuItemExport;
	private MenuItem classroomMenuItemExport;
	private MenuItem courseMenuItemExport;
	private MenuItem textbookMenuItemImport;
	private MenuItem exitMenuItem;
	private MenuItem studentMenuItem;
	private MenuItem facultyMenuItem;
	private MenuItem textbookMenuItem;
	private MenuItem courseMenuItem;
	private MenuItem classroomMenuItem;

	private PersonBag personBag;
	private TextbookBag textbookBag;

	// private Desktop desktop = Desktop.getDesktop();

	public TopPane(College college) {
		buildFileMenu();
		buildOperationMenu();
		buildMenuBar();
		personBag = college.getPersonBag();
		textbookBag = college.getTextbookBag();
	}

	private void buildMenuBar() {
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, operationMenu);
	}

	private void buildFileMenu() {
		final FileChooser fileChooser = new FileChooser();
		Stage stage = new Stage();

		fileMenu = new Menu("File");
		saveMenuItem = new MenuItem("Save");
		saveMenuItem.setOnAction(e -> {
			saveAll();
		});
		loadMenuItem = new MenuItem("Load");
		loadMenuItem.setOnAction(e -> {
			loadAll();
		});

		importMenu = new Menu("Import...");
		studentMenuItemImport = new MenuItem("Student");
		studentMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {

						Scanner scanner = new Scanner(file);

						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							String[] tokens = line.split(", ");
							Person s = new Person(tokens[0], tokens[1]);
							personBag.insert(s);
							
						}
					} catch (FileNotFoundException e1) {
					}

				}
			}
		});
		facultyMenuItemImport = new MenuItem("Faculty");
		facultyMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
						// System.out.println(scanner.nextLine());
					} catch (FileNotFoundException e1) {
					}

				}
			}
		});
		classroomMenuItemImport = new MenuItem("Classroom");
		classroomMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
						// System.out.println(scanner.nextLine());
					} catch (FileNotFoundException e1) {
					}

				}
			}
		});
		courseMenuItemImport = new MenuItem("Course");
		courseMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
						// System.out.println(scanner.nextLine());
					} catch (FileNotFoundException e1) {
					}

				}
			}
		});
		textbookMenuItemImport = new MenuItem("Textbook");
		textbookMenuItemImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					try {
						Scanner scanner = new Scanner(file);
						// System.out.println(scanner.nextLine());
					} catch (FileNotFoundException e1) {
						Util.failureAlert("Failure importing textbooks.txt file");
					}
				}
			}
		});
		importMenu.getItems().addAll(studentMenuItemImport, facultyMenuItemImport, classroomMenuItemImport,
				courseMenuItemImport, textbookMenuItemImport);
		exportMenu = new Menu("Export...");
		studentMenuItemExport = new MenuItem("Student");
		studentMenuItemExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				FileChooser fileChooser = new FileChooser();

				// Set extension filter
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);

				// Show save file dialog
				File file = fileChooser.showSaveDialog(stage);

				if (file != null) {
					try {
						PrintWriter pw = new PrintWriter(file);
						for (int i = 0; i < personBag.getPersonArray().length; i++) {
							pw.println(personBag.getPersonArray()[i].getName() + ": " 
									+ personBag.getPersonArray()[i].getId() );
						}
						pw.close();
					} catch (FileNotFoundException e) {
						Util.failureAlert("Failure exporting persons.txt file");
					}
				}
			}
		});
		facultyMenuItemExport = new MenuItem("Faculty");
		classroomMenuItemExport = new MenuItem("Classroom");
		courseMenuItemExport = new MenuItem("Course");
		textbookMenuItemExport = new MenuItem("Textbook");
		exportMenu.getItems().addAll(studentMenuItemExport, facultyMenuItemExport, classroomMenuItemExport,
				courseMenuItemExport, textbookMenuItemExport);
		exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setOnAction(e -> {
			saveAll();
			Platform.exit();
		});

		fileMenu.getItems().addAll(saveMenuItem, loadMenuItem, new SeparatorMenuItem(), importMenu, exportMenu,
				new SeparatorMenuItem(), exitMenuItem);
	}

	private void buildOperationMenu() {
		operationMenu = new Menu("Opeartion");
		studentMenuItem = new MenuItem("Student");
		facultyMenuItem = new MenuItem("Faculty");
		classroomMenuItem = new MenuItem("Classroom");
		courseMenuItem = new MenuItem("Course");
		textbookMenuItem = new MenuItem("Textbook");

		operationMenu.getItems().addAll(studentMenuItem, facultyMenuItem, new SeparatorMenuItem(), classroomMenuItem,
				courseMenuItem, textbookMenuItem);
	}

	public void saveAll() {
		personBag.save();
		textbookBag.save();
	}

	public void loadAll() {
		personBag.load();
		textbookBag.load();
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public MenuItem getSaveMenuItem() {
		return saveMenuItem;
	}

	public void setSaveMenuItem(MenuItem saveMenuItem) {
		this.saveMenuItem = saveMenuItem;
	}

	public MenuItem getLoadMenuItem() {
		return loadMenuItem;
	}

	public void setLoadMenuItem(MenuItem loadMenuItem) {
		this.loadMenuItem = loadMenuItem;
	}

	public MenuItem getImportMenu() {
		return importMenu;
	}

	public void setImportMenuItem(Menu importMenu) {
		this.importMenu = importMenu;
	}

	public MenuItem getExportMenu() {
		return exportMenu;
	}

	public void setExportMenuItem(Menu exportMenu) {
		this.exportMenu = exportMenu;
	}

	public MenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	public void setExitMenuItem(MenuItem exitMenuItem) {
		this.exitMenuItem = exitMenuItem;
	}

	public MenuItem getStudentMenuItem() {
		return studentMenuItem;
	}

	public void setStudentMenuItem(MenuItem studentMenuItem) {
		this.studentMenuItem = studentMenuItem;
	}

	public MenuItem getFacultyMenuItem() {
		return facultyMenuItem;
	}

	public void setFacultyMenuItem(MenuItem facultyMenuItem) {
		this.facultyMenuItem = facultyMenuItem;
	}

	public MenuItem getTextbookMenuItem() {
		return textbookMenuItem;
	}

	public void setTextbookMenuItem(MenuItem textbookMenuItem) {
		this.textbookMenuItem = textbookMenuItem;
	}

	public MenuItem getCourseMenuItem() {
		return courseMenuItem;
	}

	public void setCourseMenuItem(MenuItem courseMenuItem) {
		this.courseMenuItem = courseMenuItem;
	}

	public MenuItem getClassroomMenuItem() {
		return classroomMenuItem;
	}

	public void setClassroomMenuItem(MenuItem classroomMenuItem) {
		this.classroomMenuItem = classroomMenuItem;
	}
	//
	// private void openFile(File file) {
	// try {
	// desktop.open(file);
	// } catch (IOException ex) {
	// Logger.getLogger(TopPane.class.getName()).log(Level.SEVERE, null, ex);
	// }
	// }
}
