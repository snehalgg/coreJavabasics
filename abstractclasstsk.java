import java.util.ArrayList;

abstract class Course {
    protected String courseName;
    protected String instructorName;
    protected ArrayList<String> studentsEnrolled;

    public Course(String courseName, String instructorName) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.studentsEnrolled = new ArrayList<>();
    }

  
    public abstract void enrollStudent(String studentName);
    public abstract void dropStudent(String studentName);

    public void displayEnrollmentDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Students Enrolled: " + studentsEnrolled);
        System.out.println();
    }
}


class MathCourse extends Course {
    private int maxStudents;

    public MathCourse(String courseName, String instructorName, int maxStudents) {
        super(courseName, instructorName);
        this.maxStudents = maxStudents;
    }

    @Override
    public void enrollStudent(String studentName) {
        if (studentsEnrolled.size() < maxStudents) {
            studentsEnrolled.add(studentName);
            System.out.println(studentName + " enrolled in " + courseName);
        } else {
            System.out.println("Enrollment for " + courseName + " is full.");
        }
    }

    @Override
    public void dropStudent(String studentName) {
        if (studentsEnrolled.contains(studentName)) {
            studentsEnrolled.remove(studentName);
            System.out.println(studentName + " dropped from " + courseName);
        } else {
            System.out.println(studentName + " is not enrolled in " + courseName);
        }
    }
}

class ScienceCourse extends Course {
    private String labAssistant;

    public ScienceCourse(String courseName, String instructorName, String labAssistant) {
        super(courseName, instructorName);
        this.labAssistant = labAssistant;
    }

    @Override
    public void enrollStudent(String studentName) {
        studentsEnrolled.add(studentName);
        System.out.println(studentName + " enrolled in " + courseName);
    }

    @Override
    public void dropStudent(String studentName) {
        if (studentsEnrolled.contains(studentName)) {
            studentsEnrolled.remove(studentName);
            System.out.println(studentName + " dropped from " + courseName);
        } else {
            System.out.println(studentName + " is not enrolled in " + courseName);
        }
    }

    public void displayLabAssistant() {
        System.out.println("Lab Assistant: " + labAssistant);
    }
}


class HistoryCourse extends Course {
    private String period;

    public HistoryCourse(String courseName, String instructorName, String period) {
        super(courseName, instructorName);
        this.period = period;
    }

    @Override
    public void enrollStudent(String studentName) {
        studentsEnrolled.add(studentName);
        System.out.println(studentName + " enrolled in " + courseName);
    }

    @Override
    public void dropStudent(String studentName) {
        if (studentsEnrolled.contains(studentName)) {
            studentsEnrolled.remove(studentName);
            System.out.println(studentName + " dropped from " + courseName);
        } else {
            System.out.println(studentName + " is not enrolled in " + courseName);
        }
    }

    public void displayPeriod() {
        System.out.println("Period: " + period);
    }
}

public class abstractclasstsk {
    public static void main(String[] args) {
      
        Course mathCourse = new MathCourse("Mathematics", "Mafia Itachi", 30);
        Course scienceCourse = new ScienceCourse("Science", "Muazzam Baka", "Bunny");
        Course historyCourse = new HistoryCourse("History", "Muazzam nalla", "Medieval");

        mathCourse.enrollStudent("Ayush");
        mathCourse.enrollStudent("Dhruv");
        mathCourse.dropStudent("Snehal");
        mathCourse.enrollStudent("Monis");

        scienceCourse.enrollStudent("Kalpesh");
        scienceCourse.enrollStudent("Manoj");
        scienceCourse.enrollStudent("Saima");

        historyCourse.enrollStudent("JAgruti");
        historyCourse.enrollStudent("Samruddhi");
        historyCourse.dropStudent("RUtika");

        mathCourse.displayEnrollmentDetails();
        scienceCourse.displayEnrollmentDetails();
        historyCourse.displayEnrollmentDetails();

        ((ScienceCourse) scienceCourse).displayLabAssistant();
        ((HistoryCourse) historyCourse).displayPeriod();
    }
}
