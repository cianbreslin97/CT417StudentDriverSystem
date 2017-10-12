package CT417StudentDriverSystem;

import java.util.ArrayList;
import org.joda.time.DateTime;

import CT417StudentRegistrationSystem.Course;
import CT417StudentRegistrationSystem.Module;
import CT417StudentRegistrationSystem.Student;

public class TestDriver {

	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Module> allModules = new ArrayList<Module>();

	public static void main(String args[]) {
		//initialise all students into modules and course
		initStudents(); 
		
		// print details for all students
		for (Student student : allStudents) {
			System.out.println("Student Details:\n-----------------------------------------------\n" + 
								student + "\nCourse Details: "+ student.getCourse());
			System.out.print("Modules Attending: \n");
			// not all students attend every module (some are optional)
			for (Module module : allModules) {
				if (module.containsStudent(student)) {
					System.out.println(module);
				}
			}
			System.out.println("\n");
		}

	}

	public static void initStudents() {
		Student s1 = new Student("Charles McHugh", 21, "21/02/1996");
		Student s2 = new Student("Cian Brennan", 22, "25/02/1995");
		Student s3 = new Student("Jamie Coyle", 21, "05/12/1996");
		Student s4 = new Student("Eoghan Sweeney", 22, "12/07/1995");
		Student s5 = new Student("Shannon Byrne", 19, "25/12/1997");
		Student s6 = new Student("Adrian Ward", 22, "05/08/1995");
		Student s7 = new Student("Shane Sweeney", 20, "17/04/1997");
		Student s8 = new Student("Shaun Breslin", 20, "12/07/1997");

		allStudents.add(s1);
		allStudents.add(s2);
		allStudents.add(s3);
		allStudents.add(s4);
		allStudents.add(s5);
		allStudents.add(s6);
		allStudents.add(s7);
		allStudents.add(s8);
		ArrayList<Student> m1Students = new ArrayList<Student>();
		m1Students.add(s1);
		m1Students.add(s2);
		m1Students.add(s3);
		m1Students.add(s4);
		m1Students.add(s5);
		m1Students.add(s6);
		m1Students.add(s7);
		m1Students.add(s8);
		ArrayList<Student> m2Students = new ArrayList<Student>();
		m2Students.add(s1);
		m2Students.add(s2);
		m2Students.add(s3);
		m2Students.add(s4);
		m2Students.add(s6);
		m2Students.add(s8);
		ArrayList<Student> m3Students = new ArrayList<Student>();
		m3Students.add(s1);
		m3Students.add(s2);
		m3Students.add(s3);
		m3Students.add(s4);
		m3Students.add(s5);
		m3Students.add(s6);
		m3Students.add(s8);

		Module m1 = new Module("Software Engineering", "CT417", m1Students);
		Module m2 = new Module("Modern Information Management", "CT422", m2Students);
		Module m3 = new Module("Advanced Professional Skills", "CT436", m3Students);
		allModules.add(m1);
		allModules.add(m2);
		allModules.add(m3);

		ArrayList<Module> courseModules = new ArrayList<Module>();
		courseModules.add(m1);
		courseModules.add(m2);
		courseModules.add(m3);

		DateTime courseStartDate = new DateTime(2017, 07, 29, 0, 0);
		DateTime courseEndDate = new DateTime(2018, 06, 20, 0, 0);
		Course course = new Course("Computer Science & IT", courseModules, courseStartDate, courseEndDate);

		// register all students
		for (Student student : allStudents) {
			course.register(student);
		}
	}
}
