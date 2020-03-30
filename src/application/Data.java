package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Data {
	ArrayList<Instructor> ExaminersWithSameTopic = new ArrayList<>();
	ArrayList<Instructor> ExaminersAssigned;
	private ArrayList<Room> rooms;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Instructor> instructors = new ArrayList<Instructor>();
	// private ArrayList<Instructor> examiners;
	private ArrayList<Project> projects = new ArrayList<Project>();
	private ArrayList<Discussion_Time> discusission_times;
	private ArrayList<Topic> topics;
	private ArrayList<Department> departments;
	private int numberOfProjects = 0;

	public Data() throws IOException {
		// read from files here
		Initialize();
	}

	// return data instance
	private Data Initialize() throws IOException {

		File excelFile = new File(
				"C:\\Users\\ALBARQNET\\Desktop\\eclipse projects\\GraduationScehdulingGUI\\src\\application\\Graduation_List.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);

		// We create an XSSF workbook object for our XLSX Excel File
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// We get sheets
		XSSFSheet studentsSheet = workbook.getSheetAt(0);
		XSSFSheet Staff = workbook.getSheetAt(1);
		XSSFSheet Dep_ENCS = workbook.getSheetAt(2);
		XSSFSheet Dep_ENEE = workbook.getSheetAt(3);

		Iterator<Row> rowIterator = studentsSheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();
			String studentName = cell.getStringCellValue();
			cell = cellIterator.next();
			Department dep = new Department(cell.getStringCellValue());
			Student student = new Student(studentName, dep);
			students.add(student);
		}

		rowIterator = Staff.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();
			String staffName = cell.getStringCellValue();
			cell = cellIterator.next();
			Topic topic = new Topic(cell.getStringCellValue());
			Instructor staff = new Instructor(staffName, topic);
			instructors.add(staff);
		}

		rowIterator = Dep_ENCS.iterator();
		// iterating over each row
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();
			String projectName = cell.toString();
			while (cellIterator.hasNext()) {
				cell = cellIterator.next();
				String studentNames[] = cell.toString().split(",");
				ArrayList<Student> studentList = new ArrayList<Student>();
				for (int i = 0; i < studentNames.length; i++) {
					for (int k = 0; k < students.size(); k++) {
						if (studentNames[i].trim().compareTo(students.get(k).getName()) == 0) {
							studentList.add(students.get(k));
						}
					}
				}
				cell = cellIterator.next();
				String topic = cell.toString();
				Topic topicname = new Topic(topic);
				// System.out.println(studentList.get(1).toString());
				Project project = new Project(projectName, studentList, topicname);
				projects.add(project);
			}
		}

		//////////////////////////////////////////////////////
		rowIterator = Dep_ENEE.iterator();
		// iterating over each row
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String projectName = cell.toString();
				cell = cellIterator.next();
				String studentNames[] = cell.toString().split(",");

				ArrayList<Student> studentList1 = new ArrayList<Student>();
				for (int i = 0; i < studentNames.length; i++) {
					for (int k = 0; k < students.size(); k++) {
						if (studentNames[i].trim().compareTo(students.get(k).getName()) == 0) {
							studentList1.add(students.get(k));
						}
					}
				}
				cell = cellIterator.next();
				String topic = cell.toString();
				Topic topicname = new Topic(topic);
				Project project = new Project(projectName, studentList1, topicname);
				projects.add(project);
			}
		}

		///////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////

		workbook.close();
		fis.close();
		// ******************************************************************************************//
		Discussion_Time Meet1 = new Discussion_Time("1", "9:00-10:00");
		Discussion_Time Meet2 = new Discussion_Time("2", "10:00-11:00");
		Discussion_Time Meet3 = new Discussion_Time("3", "11:00-12:00"); // Meetings time
		Discussion_Time Meet4 = new Discussion_Time("4", "12:00-1:00");
		Discussion_Time Meet5 = new Discussion_Time("5", "1:00-2:00");

		discusission_times = new ArrayList<Discussion_Time>(Arrays.asList(Meet1, Meet2, Meet3, Meet4, Meet5));
		// ******************************************************************************************//
		Room room1 = new Room("106");
		Room room2 = new Room("202");
		Room room3 = new Room("404"); // Room Numbers
		Room room4 = new Room("204");
		Room room5 = new Room("304");

		Room room6 = new Room("306");
		Room room7 = new Room("302");
		Room room8 = new Room("406");
		Room room9 = new Room("108");
		Room room10 = new Room("109");
		Room room11 = new Room("110");
		Room room12 = new Room("206");

		rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3, room4, room5,room6,room7,room8,room9,room10,room12,room11));
		// ******************************************************************************************//

		// ******************************************************************************************//
		// *********************Assign Examiners And Supervisors to Projects
		// ***********************//
		for (int i = 0; i < projects.size(); i++) {
			for (int j = 0; j < instructors.size(); j++) { // getting an Arraylist with Examiners which have the same
															// topic as Prefered

				if ((instructors.get(j).getPrefTopics().getTopicName()
						.compareTo(projects.get(i).getTopics().getTopicName()) == 0)) {
					ExaminersWithSameTopic.add(instructors.get(j));
				}
			}
			Collections.sort(ExaminersWithSameTopic); // Sorting Array to Make Balancing in Examiners

			for (int N = 0; N < ExaminersWithSameTopic.size(); N++) { // Remove Examiners with maximum Projects
				if (ExaminersWithSameTopic.get(N).getExaminingProjects() > 6)
					ExaminersWithSameTopic.remove(ExaminersWithSameTopic.get(N));
			}

			ExaminersAssigned = new ArrayList<Instructor>(
					Arrays.asList(ExaminersWithSameTopic.get(0), ExaminersWithSameTopic.get(1)));

			// These are the 2 Examiners assigned

			// assign Examiners to Project
			projects.get(i).setExaminers(ExaminersAssigned);
			ExaminersAssigned.get(0).setExaminingProjects((ExaminersAssigned.get(0).getExaminingProjects() + 1));
			ExaminersAssigned.get(1).setExaminingProjects((ExaminersAssigned.get(1).getExaminingProjects() + 1));
			// ************************************************************//
			// ********** Assigning A Supervisor for the Project **********//
			int RandomNumber = new Random().nextInt(instructors.size());

			int flag = 0;

			while (flag == 0) {
				RandomNumber = new Random().nextInt(instructors.size());
				for (int z = 0; z < ExaminersAssigned.size(); z++) {
					if (instructors.get(RandomNumber).getId() != (ExaminersAssigned.get(z).getId())) // edited bc id now
																										// int
						flag = 1;
				}
			}
			projects.get(i).setSupervisor(instructors.get(RandomNumber));
			instructors.get(RandomNumber)
					.setSupervisingProjects(instructors.get(RandomNumber).getSupervisingProjects() + 1);

			// ************************************************************//
			// ************************************************************//

			ExaminersWithSameTopic = new ArrayList<>();
			ExaminersAssigned = new ArrayList<>();

		}

		// *******************************************************************************************//
		// *******************************************************************************************//

		return this;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public ArrayList<Instructor> getIntructors() {
		return instructors;
	}

	/*
	 * public ArrayList<Instructor> getExaminers() { return examiners; }
	 */

	public ArrayList<Discussion_Time> getDiscusission_times() {
		return discusission_times;
	}

	public int getNumberOfProjects() {
		return numberOfProjects;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

}
