package application;
public class Examiner extends Instructor{

	public Examiner(String id, String instructorName, Topic prefTopics) {
		super(instructorName, prefTopics);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Examiner [ExaminerName=" + super.getInstructorName() + "]";
	}
	
}
