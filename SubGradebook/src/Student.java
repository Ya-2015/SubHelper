import java.util.Date;


public class Student {
	private int studentID;
	private String studentName;
	private String assignment;
	private String assignmentType;
	private Date assignmentDate;
	private int grade;
	private double average;
	private double max_grade;
	private double low_grade;
	
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getAssignmentType() {
		return assignmentType;
	}
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	public Date getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public double getMax_grade() {
		return max_grade;
	}
	public void setMax_grade(double max_grade) {
		this.max_grade = max_grade;
	}
	public double getLow_grade() {
		return low_grade;
	}
	public void setLow_grade(double low_grade) {
		this.low_grade = low_grade;
	}

}


