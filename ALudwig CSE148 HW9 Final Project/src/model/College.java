package model;

import java.io.Serializable;

import utilities.Utilities;

// TO BE FINISHED IN HW9

public class College implements Serializable {
	private PersonBag personBag;
	private ClassroomBag classroomBag;
	private TextbookBag textbookBag;
	private CourseBag courseBag;

	private static final int PERSON_BAG_SIZE = 2010;
	private static final int CLASSROOM_BAG_SIZE = 250;
	private static final int TEXTBOOK_BAG_SIZE = 300;
	private static final int COURSE_BAG_SIZE = 250;

	public College() {
		super();
		this.personBag = new PersonBag(PERSON_BAG_SIZE);
		this.classroomBag = new ClassroomBag(CLASSROOM_BAG_SIZE);
		this.textbookBag = new TextbookBag(TEXTBOOK_BAG_SIZE);
		this.courseBag = new CourseBag(COURSE_BAG_SIZE);
		Utilities.load(this, "savedFiles/allBags.dat");
	}

	public College(PersonBag people, ClassroomBag classrooms, TextbookBag textbooks, CourseBag courses) {
		super();
		this.personBag = people;
		this.classroomBag = classrooms;
		this.textbookBag = textbooks;
		this.courseBag = courses;
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public ClassroomBag getClassroomBag() {
		return classroomBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public CourseBag getCourseBag() {
		return courseBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public void setClassroomBag(ClassroomBag classroomBag) {
		this.classroomBag = classroomBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}

	public void setCourseBag(CourseBag courseBag) {
		this.courseBag = courseBag;
	}

	@Override
	public String toString() {
		return "person=" + personBag + ", classroomBag=" + classroomBag + ", textbookBag=" + textbookBag
				+ ", courseBag=" + courseBag;
	}

}
