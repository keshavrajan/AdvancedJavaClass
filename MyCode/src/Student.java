import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Student implements Comparable<Student> {
	private String Name;
	private double GPA;
	private Collection<String> Courses;

	public Student(String name, double gpa, String... courses) {
		this.Name = name;
		this.GPA = gpa;
		this.Courses = Arrays.asList(courses);
	}

	public double getGPA() {
		return this.GPA;
	}

	public String getName() {
		return this.Name;
	}

	public Collection<String> getCourses() {
		return this.Courses;
	}

	@Override
	public int compareTo(Student o) {
		return this.Name.compareTo(o.Name);
	}
	
	@Override
	public String toString()
	{
		return "Name:" + this.Name + "GPA:" + this.GPA + "Courses:" + this.Courses;
	}
	
	public static Comparator<Student> getGPAComparator()
	{
		return (o1, o2) -> new Double(o1.GPA).compareTo(o2.GPA);
	}
	
	public static Comparator<Student> getNameComparator()
	{
		return (s1, s2) -> s1.Name.compareTo(s2.Name);
	}
	
	public static Criterion<Student> getSmartnessCriterion(final double threshold)
	{
		return s -> s.GPA > threshold;
	}
	
	public static Criterion<Student> getNameInFirstHalfOfAlphabetCriterion()
	{
		return s -> s.Name.charAt(0) < 'N';
	}
	
	public static String hello()
	{
		return "Hello";
	}
}
