package application;

public class Department {
	private String name;
	public Department(String name) {
		super();
		this.name = name;

	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Department{" +
				"name='" + name + '\'' +
				'}';
	}
}


