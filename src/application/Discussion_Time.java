package application;

public class Discussion_Time {
	private String id;
	private String time;
	public Discussion_Time(String id, String time) {
		super();
		this.id = id;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Discussion Time: " + time;
	}
}
