package students;

import java.util.Comparator;

public class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
            return new Float(o1.getGpa()).compareTo(o2.getGpa());
    }

}
