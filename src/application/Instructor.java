package application;
import java.util.concurrent.atomic.AtomicInteger;

public class Instructor implements Comparable<Instructor> {
    private int id;
    private String InstructorName;
    private Topic prefTopics;
    private int SupervisingProjects;
    private int ExaminingProjects;
    private static final AtomicInteger count = new AtomicInteger(0); //in order to create an auto increament id for discussions.


    public Instructor(String instructorName, Topic prefTopics) {

        this.id =count.incrementAndGet();;
        InstructorName = instructorName;
        this.prefTopics = prefTopics;
        ExaminingProjects = 0;
        SupervisingProjects = 0;
    }

    public int getId() {
        return id;
    }

    public int getSupervisingProjects() {
        return SupervisingProjects;
    }

    public void setSupervisingProjects(int supervisingProjects) {
        SupervisingProjects = supervisingProjects;
    }

    public int getExaminingProjects() {
        return ExaminingProjects;
    }

    public void setExaminingProjects(int examiningProjects) {
        ExaminingProjects = examiningProjects;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public Topic getPrefTopics() {
        return prefTopics;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id='" + id + '\'' +
                ", InstructorName='" + InstructorName + '\'' +
                ", prefTopics=" + prefTopics +
                ", SupervisingProjects=" + SupervisingProjects +
                ", ExaminingProjects=" + ExaminingProjects +
                '}';
    }
    ///////////////////////////////////////////////////////////////////////////////


    @Override
    public int compareTo(Instructor instructor) {
        if (this.getExaminingProjects() > instructor.getExaminingProjects())
            return 1;
        else if (this.getExaminingProjects() < instructor.getExaminingProjects())
            return -1;
        return 0;
    }

///////////////////////////////////////////////////////////////////////////////

}
