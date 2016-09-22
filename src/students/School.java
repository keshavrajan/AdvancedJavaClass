package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Criterion<E> {
    boolean test(E s);
}

public class School {
//    public static List<Student> getSmartStudents(List<Student> input) {
//        List<Student> output = new ArrayList<>();
//        for (Student s : input) {
//            if (s.getGpa() > 3.0F) {
//                output.add(s);
//            }
//        }
//        return output;
//    }
    
    public static <E> void showList(List<E> data) {
        for (E e : data) {
            System.out.println("> " + e);
        }
              
    }
    
    public static <E> List<E> filterList(Criterion<E> criterion, List<E> input) {
        List<E> output = new ArrayList<>();
        for (E s : input) {
            if (criterion.test(s)) {
                output.add(s);
            }
        }
        return output;
    }
    
    public static <E> Comparator<E> andThenComparing(Comparator<E> first, Comparator<E> second) {
        return (o1, o2) -> {
            int rv = first.compare(o1, o2);
            if (rv == 0) rv = second.compare(o1, o2);
            return rv;
        };
    }

    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                Student.ofNameGpaCourses("Sheila", 3.1F, "Math", "Astronomy", "Statistics", "Chemistry"),
                Student.ofNameGpaCourses("William", 2.9F, "Electronic Engineering", "Mechanical Engineering"),
                Student.ofNameGpaCourses("Fred", 2.2F, "Math", "Physics", "Chemistry"),
                Student.ofNameGpaCourses("Sheila", 3.6F, "Math", "Chemistry", "Physics"),
                Student.ofNameGpaCourses("Elizabeth", 3.8F, "Astronomy", "Physics"),
                Student.ofNameGpaCourses("William", 2.1F, "Statistics", "Mechanical Engineering"),
                Student.ofNameGpaCourses("Jennifer", 3.5F, "Math", "Physics", "Chemistry"),
                Student.ofNameGpaCourses("Sheila", 2.1F, "Art", "PoliSci"),
                Student.ofNameGpaCourses("William", 3.6F, "Math", "History", "Art"),
                Student.ofNameGpaCourses("Jim", 3.2F, "Art", "Journalism")
        );

//        System.out.println("> " + school);
//        
//        Collections.sort(school);
//        System.out.println(">> " + school);
//        
//        Collections.sort(school, Student.getGPAComparator());
//        System.out.println(">>> " + school);
        
//        Criterion<Student> cs = s->s.getGpa() > 3.0F;
        List<Student> smart = filterList(
                Student.getSmartnessCriterion(3.5F),
                school);
        
        System.out.println("smart students: " + smart);
        
//        System.out.println("shortStrings: " + filterList(s->{return s.length() < 3;}, 
//                Arrays.asList("Fred", "X", "Banana", "A", "I")
//                ));
        
        System.out.println("shortStrings: " + filterList(s->s.length() < 3, 
                Arrays.asList("Fred", "X", "Banana", "A", "I")
                ));

        System.out.println("-------------------------------");
        Collections.sort(school, 
                andThenComparing(Student.getNameComparator(), Student.getGPAComparator()));
        showList(school);
    }
}
