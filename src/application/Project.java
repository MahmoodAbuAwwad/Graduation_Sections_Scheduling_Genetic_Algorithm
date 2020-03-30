package application;
import java.util.ArrayList;
//course or classes ?
public class Project {
	private String ProjectName;
	private ArrayList<Student> Students;
	private Instructor Supervisor;
	private ArrayList<Instructor> Examiners;
	private Topic Topics;

	public Instructor getSupervisor() {
		return Supervisor;
	}

	public ArrayList<Instructor> getExaminers() {
		return Examiners;
	}
	// private Department department ;

	/*
	 * public Project(String projectName, ArrayList<Instructor> instructors,
	 * ArrayList<Student> students, Instructor supervisor, ArrayList<Instructor>
	 * examiners,Topic topics,Department Depart) { super(); ProjectName =
	 * projectName; Students = students; Supervisor = supervisor; Examiners =
	 * examiners; Topics = topics; department = Depart ; }
	 */

	public Project(String projectName, ArrayList<Student> students, Topic topics) {
		ProjectName = projectName;
		Students = students;
		Topics = topics;

	}

	public String getProjectName() {
		return ProjectName;
	}

	public ArrayList<Student> getStudents() {
		return Students;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public void setStudents(ArrayList<Student> students) {
		Students = students;
	}

	public void setExaminers(ArrayList<Instructor> examiners) {
		Examiners = examiners;
	}

	public void setTopics(Topic topics) {
		Topics = topics;
	}

	/*
	 * public Instructor getSupervisor() { return Supervisor; } public
	 * ArrayList<Instructor> getExaminers() { return Examiners; }
	 * 
	 * public Department getDepartment() { return department; }
	 * 
	 * public void setDepartment(Department department) { this.department =
	 * department; }
	 */
	public void setSupervisor(Instructor supervisor) {
		Supervisor = supervisor;
	}

	public Topic getTopics() {
		return Topics;
	}

	/*
	 * @Override public String toString() { return "Project [ProjectName=" +
	 * ProjectName + "]"; }
	 */

	@Override
	public String toString() {
		return "Project [ProjectName: " + ProjectName +
				"\n\tStudents: " + Students +
				"\n\tSupervisor ID: " + Supervisor.getId() + ", Supervisor Name: " + Supervisor.getInstructorName() +
				"\n\tExaminers:" + Examiners +
				"\n\tTopic: " + Topics.getTopicName() +
			//	", department=" + department +  //
				"]\n---------------------------------------------------------------------------------\n";
	}
}
