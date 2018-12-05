package project;

public class College {
	private PersonBag personBag;
	private TextbookBag textbookBag;
	private final int PERSONBAG_MAXSIZE = 50;
	private final int TEXTBOOKBAG_MAXSIZE = 50;
	
	public College() {
		personBag = new PersonBag(PERSONBAG_MAXSIZE);
		textbookBag = new TextbookBag(TEXTBOOKBAG_MAXSIZE);
		load();
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}
	
	public void save() {
		personBag.save();
		textbookBag.save();
	}
	
	public void load() {
		personBag.load();
		textbookBag.load();
	}
	
}
