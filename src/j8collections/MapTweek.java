package j8collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import students.Student;

public class MapTweek {

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
        
        Map<String, Float> map = new HashMap<>();
        
        BiFunction<Student, Float, Float> bfsf = (s,v) -> s.getGpa();
        school.forEach(s -> 
                map.compute(
                    s.getName(), 
                    (k,v) -> s.getGpa()
//                    ((BiFunction<String, Float, Float>)((k,v) -> s.getGpa()))
                )
        );
        
        map.forEach((k,v)->System.out.println(k + ": " + v));
        
        Function<String, Integer> tifs = (s)-> s.length();
        int x = tifs.apply("Hello");
        System.out.println("x is " + x);
        
        // NEED CONTEXT!!!
//        System.out.println("length is " + (s->s.length()).apply("Hello"));
    }
}
