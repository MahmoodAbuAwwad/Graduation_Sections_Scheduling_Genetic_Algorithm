package application;
public class Supervisor extends Instructor{
	
	public Supervisor(String id, String instructorName, Topic prefTopics) {
		super(instructorName, prefTopics);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Supervisor [SupervisorName=" + super.getInstructorName()+ "]";
	}
	
}
