package application;
public class Room {
	private String RoomNumber;

	public Room(String RoomNumber) {
		super();
		this.RoomNumber = RoomNumber;
	}

	public String getNumber() {
		return RoomNumber;
	}

	@Override
	public String toString() {
		return "Room{" +
				"RoomNumber='" + RoomNumber + '\'' +
				'}';
	}
}
