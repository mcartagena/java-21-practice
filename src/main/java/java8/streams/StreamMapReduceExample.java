package java8.streams;

import java8.functional.interfaces.StudentDataBase;

public class StreamMapReduceExample {
    public static int noOfNotebooks(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel() > 3)
                .filter(student -> student.getGender().equals("female"))
                .map(student -> student.getNotebooks())
                .reduce(0, (a, b) -> a + b);
    }
    public static void main(String[] args) {
        System.out.println("No of Notebooks: " +  noOfNotebooks());
    }
}
