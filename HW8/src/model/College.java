package model;

public class College {
	private PersonBag personBag;
	private ClassroomBag classroomBag;
	private CourseBag courseBag;
	private TextbookBag textbookBag;

	public College(PersonBag personBag, ClassroomBag classroomBag, CourseBag courseBag, TextbookBag textbookBag) {
		super();
		this.personBag = personBag;
		this.classroomBag = classroomBag;
		this.courseBag = courseBag;
		this.textbookBag = textbookBag;
	}

}
