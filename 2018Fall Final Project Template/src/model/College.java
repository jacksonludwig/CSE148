package model;

import java.io.IOException;
import java.io.Serializable;

import utilities.Utils;

public class College implements Serializable {
	private static final int PERSON_BAG_SIZE = 2010;
	private static final int COURSE_BAG_SIZE = 250;
	private static final int CLASSROOM_BAG_SIZE = 55;
	private static final int TEXTBOOK_BAG_SIZE = 310;

	private PersonBag personBag;
	private ClassroomBag classroomBag;
	private TextbookBag textbookBag;
	private CourseBag courseBag;

	public College() throws ClassNotFoundException, IOException {
		super();
		this.personBag = new PersonBag(PERSON_BAG_SIZE);
		this.classroomBag = new ClassroomBag(CLASSROOM_BAG_SIZE);
		this.textbookBag = new TextbookBag(TEXTBOOK_BAG_SIZE);
		this.courseBag = new CourseBag(TEXTBOOK_BAG_SIZE);
		// Utils.load(this);
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

}
