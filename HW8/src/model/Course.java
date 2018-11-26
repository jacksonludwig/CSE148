package model;

public class Course {
	private String courseTitleShort;
	private String courseTitleLong;
	private String courseDescription;
	private int numberOfCredits;
	
	public Course(String filename) {
		String dataLine = Utilities.formatRandomCourse(filename);
		
	}
	
//	public String generateCourseTitleShortFromFile(String line) {
//		
//	}
//	
//	public String generateCourseTitleLongFromFile(String line) {
//		
//	}
//	
//	public String generateCourseDescriptionFromFile(String line) {
//		
//	}
//	
//	public int generateNumberOfCreditsFromFile(String line) {
//		
//	}
}
