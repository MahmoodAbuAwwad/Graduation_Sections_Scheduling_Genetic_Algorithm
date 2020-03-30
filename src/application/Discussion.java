package application;
import java.util.concurrent.atomic.AtomicInteger;

public class Discussion {

	private int id;
	private Project project;
	private Room room;
	private Discussion_Time Discussion_Time;
	private static final AtomicInteger count = new AtomicInteger(0); //in order to create an auto increament id for discussions.


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Discussion(Project project, Room room, Discussion_Time discussion_Time) {
		this.project = project;
		this.room = room;
		Discussion_Time = discussion_Time;
		this.id = count.incrementAndGet();
	}

	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	public Discussion_Time getDiscussion_Time() {
		return Discussion_Time;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setDiscussion_Time(Discussion_Time discussion_Time) {
		Discussion_Time = discussion_Time;
	}

	@Override
	public String toString() {
		return "Discussion \n\t[Project Name: " + project.getProjectName() + "\n\t" +  "Room: " + room.getNumber() + 
				"\n\t" + "Discussion Time: " + Discussion_Time.getTime() + "\n\tSupervisor: " + project.getSupervisor()  + "\n\t" +
				"Examiners: " + project.getExaminers() + "]\n*******************************************************";
	}
}
