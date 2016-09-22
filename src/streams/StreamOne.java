package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import students.Student;

class StudentStats {
    float sumOfGrades;
    int countOfStudents;
    int sumOfClasses;
    
    public StudentStats() {}
    
    public float getMeanGrade() {
        return sumOfGrades / countOfStudents;
    }
    
    public float getMeanCourseCount() {
        return ((float)sumOfClasses)/countOfStudents;
    }
    
    public void addStudent(Student s) {
        sumOfGrades += s.getGpa();
        sumOfClasses += s.getCourses().size();
        countOfStudents++;
    }
    
    public void addStudentStats(StudentStats s) {
        sumOfGrades += s.sumOfGrades;
        sumOfClasses += s.sumOfClasses;
        countOfStudents += s.countOfStudents;
    }

    @Override
    public String toString() {
        return "StudentStats{" + "Mean Grade=" + getMeanGrade() 
                + ", countOfStudents=" + countOfStudents
                + ", Mean class count=" + getMeanCourseCount() + '}';
    }
    
}

public class StreamOne {

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
                Student.ofNameGpaCourses("William", 3.6F, "Math", "History", "Art", "Geography"),
                Student.ofNameGpaCourses("Jim", 3.2F, "Art", "Journalism")
        );

//          school.stream()
//                  .filter(s->s.getCourses().size() >= 3)
////                  .map(Student::getName)
//                  .map(s->new Object[]{
//                          s.getName(),
//                          s.getGpa()
//                      })
//                  .forEach(o->System.out.println("Name: " + o[0] + ", gpa: " + o[1]));
//            school.stream()
//                .filter(s->s.getGpa() > 3.0F)
//                .flatMap(s->   s.getCourses().stream())
//                .distinct()
//                .sorted()
//                .forEach(System.out::println);
//                ;
//            OptionalInt total = school.stream()
//                    .mapToInt(s->s.getCourses().size())
//                    .reduce((a,b)->a+b);
//            
//            total.ifPresent(v->System.out.println("Total of classes is " + v));
//            System.out.println(school.stream()
//                    .map(s->s.getName())
//                    .reduce("", (a,b)->a + ", " + b));
//                    .reduce((a,b)->a+b)
//                    .ifPresent(v->System.out.println("Total of names is " + v));
        System.out.println(school.stream()
                .collect(StudentStats::new, 
                        StudentStats::addStudent /*(b,s)->b.addStudent(s)*/,
                        StudentStats::addStudentStats));

        Map<String, Double> stats = school.stream()
                .collect(Collectors.groupingBy(
                        Student::getName, 
                        Collectors.averagingDouble(Student::getGpa)));
        stats.forEach((k,v)->System.out.println("Students called " + k + " average " + v));
    }
}
