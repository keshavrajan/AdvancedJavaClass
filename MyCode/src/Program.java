import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Program{
	public static void main(String[] args) throws IOException, InterruptedException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException 
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
				new Student("William", 3.6, "Math", "History", "Art"),
				new Student("Jim", 3.2, "Art", "Journalism")
				);

//		System.out.println("\nOriginal List");
//		showList(school);
//		
//		System.out.println("\nSorted by Name");
//		Collections.sort(school);		
//		showList(school);
//		
//		System.out.println("\nSorted by GPA");
//		Collections.sort(school, Student.getGPAComparator());		
//		showList(school);
//		
//		System.out.println("\nFilter by GPA > 3.0");
//		List<Student> output = getFilterList(school, Student.getSmartnessCriterion(3.0));
//		showList(output);
//		
//		System.out.println("\nFilter by GPA > 3.0 AND Name in A-M");
//		output = getFilterList(school, 
//				logicalAndCriterion(Student.getSmartnessCriterion(3.0), Student.getNameInFirstHalfOfAlphabetCriterion()));
//		showList(output);
//		
//		System.out.println("\nFilter by GPA > 3.0 OR Name in A-M");
//		output = getFilterList(school, 
//				logicalOrCriterion(Student.getSmartnessCriterion(3.0), Student.getNameInFirstHalfOfAlphabetCriterion()));
//		showList(output);
//
//		StreamOne.foo();
//		
//		
//		WordMap.getWordMapFromTextFile(Paths.get("/Users/keshav.rajan/Desktop/Java class/PrideAndPrejudice.txt"));
//		
//		RunnablesOne.startThreads();
		
		Reflection.foo();
	}
	

    public static <E> void showList(List<E> data) {
        for (E e : data) {
            System.out.println("> " + e);
        }
    }
    
//	public static List<Student> getSmartStudents(List<Student> input, double threshold)
//	{
//		List<Student> smartStudents = new ArrayList<>();
//		
//		for(Student s : input)
//		{
//			if(s.getGPA() > threshold)
//			{
//				smartStudents.add(s);
//			}
//		}
//		
//		return smartStudents;
//	}
    
	public static <E> List<E> getFilterList(List<E> input, Criterion<E> criterion)
	{
		List<E> output = new ArrayList<>();
		
		for(E s : input)
		{
			if(criterion.test(s))
			{
				output.add(s);
			}
		}
		
		return output;
	}
	
	public static <E> Criterion <E> logicalAndCriterion(Criterion<E> first, Criterion<E> second)
	{
		return (o) -> {
			return first.test(o) && second.test(o);	
		};
	}
	
	public static <E> Criterion <E> logicalOrCriterion(Criterion<E> first, Criterion<E> second)
	{
		return (o) -> {
			return first.test(o) || second.test(o);	
		};
	}
}

interface Criterion<E>
{
	boolean test(E s);
}

