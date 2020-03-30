package application;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
	private int Studentid;
	private String name;
	private  Department dept;
	private static final AtomicInteger count = new AtomicInteger(0); //in order to create an auto increament id for discussions.

	public Student(String name, Department dept) {
		this.Studentid = count.incrementAndGet();
		this.name = name;
		this.dept = dept;
	}



	public int getStudentid() {
		return Studentid;
	}

	public String getName() {
		return name;
	}

	public Department getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return "Student{" +
				"Studentid='" + Studentid + '\'' +
				", name='" + name + '\'' +
				", dept=" + dept +
				'}';
	}
}
