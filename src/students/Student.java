package students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private float gpa;
    private List<String> courses;

    private Student() {
    }

    public static Student ofNameGpaCourses(String name, float gpa, String... courses) {
        Student self = new Student();
        self.name = name;
        self.gpa = gpa;
        self.courses = Arrays.asList(courses);
        return self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Float.floatToIntBits(this.gpa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Float.floatToIntBits(this.gpa) != Float.floatToIntBits(other.gpa)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
//
//    public static Comparator<Student> getGPAComparator() {
//        return new GPAComparator();
//    }
//    
//    private static class GPAComparator implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("...");
//            return new Float(o1.getGpa()).compareTo(o2.getGpa());
//        }
//    }

//    public static Comparator<Student> getGPAComparator() {
//        return new /*GPAComparator();
//    }
//    
//    private static class GPAComparator implements*/ Comparator<Student>() {
//
//            @Override
//            public int compare(Student o1, Student o2) {
//                System.out.println("...");
//                return new Float(o1.getGpa()).compareTo(o2.getGpa());
//            }
//        };
//    }
//    public static Comparator<Student> getGPAComparator() {
//        return new Comparator<Student>() {
//
//            @Override
//            public int compare(Student o1, Student o2) {
//                System.out.println("+++");
//                return new Float(o1.gpa).compareTo(o2.gpa);
//            }
//        };
//    }
//    public static Comparator<Student> getGPAComparator() {
//        return /*new Comparator<Student>() {
//
//            @Override
//            public int compare*/(Student o1, Student o2) -> {
//                System.out.println("+++");
//                return new Float(o1.gpa).compareTo(o2.gpa);
//            }
//        /*}*/;
//    }
    public static Comparator<Student> getGPAComparator() {
        return (o1, o2) -> new Float(o1.gpa).compareTo(o2.gpa);
    }
    
    public static Comparator<Student> getNameComparator() {
        return (s1, s2)->s1.name.compareTo(s2.name);
    }

    public static Criterion<Student> getSmartnessCriterion(final float threshold) {
//        threshold += 0.1F;
        return s -> s.gpa > threshold;
    }
}
