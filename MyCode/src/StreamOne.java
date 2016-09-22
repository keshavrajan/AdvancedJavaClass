import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StudentStats {
	double sumOfGrades;
	int countOfStudents;
	int sumOfClasses;
	
	public StudentStats() {}
	
	public double getMeanGrade(){
		return sumOfGrades/countOfStudents;
	}
	
	public double getMeanCourseCount() {
		return (double)sumOfClasses/countOfStudents;
	}

	public void addStudent(Student s) {
		sumOfGrades += s.getGPA();
		sumOfClasses += s.getCourses().size();
		countOfStudents++;
	}

	public void addStudentStats(StudentStats s) {
		sumOfGrades += s.sumOfGrades;
		sumOfClasses += s.sumOfClasses;
		countOfStudents+=s.countOfStudents;
	}

	@Override
	public String toString() {
		return "StudentStats [countOfStudents=" + countOfStudents
				+ ", getMeanGrade()=" + getMeanGrade()
				+ ", getMeanCourseCount()=" + getMeanCourseCount() + "]";
	}
	
	
}

public class StreamOne {
	public static void foo()
	{
		List<Student> school = Arrays.asList(
				new Student("Sheila", 3.1, "Math", "Astronomy", "Statistics", "Chemistry"),
				new Student("William", 2.9, "Electronic Engineering", "Mechanical Engineering"),
				new Student("Fred", 2.2, "Math", "Physics", "Chemistry"),
				new Student("Sheila", 3.6, "Math", "Chemistry", "Physics"),
				new Student("Elizabeth", 3.8, "Astronomy", "Physics"),
				new Student("William", 2.1, "Statistics", "Mechanical Engineering"),
				new Student("Jennifer", 3.5, "Math", "Physics", "Chemistry"),
				new Student("Sheila", 2.1, "Art", "PoliSci"),
				new Student("William", 3.6, "Math", "History", "Art", "Geography"),
				new Student("Jim", 3.2, "Art", "Journalism")
				);

//		school.stream()
//			.filter(s->s.getCourses().size() > 3)
//			//.map(s->s.getName())
//			.map(s->new Object[]{
//					s.getName(),
//					s.getGPA()
//				})
//			.forEach(o->System.out.println(o[0] + " : " + o[1]));
//
//		school.stream()
//			.filter(s->s.getGPA() > 3.0)
//			.flatMap(s->s.getCourses().stream())
//			.distinct()
//			.sorted()
//			.forEach(System.out::println);
//		
//		school.stream()
//			.mapToDouble(s->s.getGPA())
//			.forEach(o->System.out.println(o));
//		
//		Stream.of(school)
//			.filter(s->s.get(0).getGPA() > 3.0)
//			.forEach(o->System.out.println(o));
//		
//		Stream.iterate(school.get(0), s->s)
//			.limit(5)
//			.forEach(o->System.out.println(o));
		Stream.generate(() -> (Math.random() * 100))
			.limit(10)
			.forEach(o->System.out.println(o));
//	
//		OptionalInt total = school.stream()
//				.mapToInt(s->s.getCourses().size())
//				.reduce((a,b)->a+b);
//				
//		total.ifPresent(o->System.out.println(o));
//		
//		System.out.println(school.stream()
//				.map(s->s.getName())
//				.reduce((a,b)->a+b)
//		);
//		
//		System.out.println(school.stream()
//			.collect(StudentStats::new, 
//					StudentStats::addStudent/*(b,s)->b.addStudent(s)*/, 
//					StudentStats::addStudentStats/*(b,s)->b.addStudentStats(s)*/));
//		
//		Map<String, Double> stats = school.stream()
//			.collect(Collectors.groupingBy(
//					Student::getName, 
//					Collectors.averagingDouble(Student::getGPA)));
//		
//		stats.forEach((k,v)->System.out.println("Students called " + k + " average "+ v));
		
	}
}
