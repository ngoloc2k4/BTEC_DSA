package Student;

import java.util.ArrayList;
import java.util.Comparator;

public class TestData {
    private ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        TestData testData = new TestData();
        testData.runTests();
    }

    private void runTests() {
        // T01: Add Student with valid input
        try {
            addStudent(123, "John Doe", 90, 20);
            System.out.println("Student added successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T02: Add Student with invalid ID
        try {
            addStudent("abc", "John Doe", 90, 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T03: Add Student with out-of-range marks
        try {
            addStudent(124, "Jane Doe", -10, 20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T04: Delete non-existing student
        try {
            deleteStudent(999);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T05: Display students on an empty list
        displayStudents();

        // T06: Add Student with duplicate ID
        try {
            addStudent(125, "Student A", 85, 21);
            addStudent(125, "Student B", 90, 22);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T07: Edit Student (Valid Update)
        try {
            addStudent(126, "Student C", 80, 20);
            editStudent(126, "Student C", 92);
            System.out.println("Student details updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T08: Edit Student (Non-Existent Student)
        try {
            editStudent(999, "Non-Existent", 75);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T09: Search Student by ID
        try {
            addStudent(127, "Student D", 88, 20);
            searchStudentByID(127);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T10: Search Student by Name
        try {
            addStudent(128, "Student E", 93, 22);
            searchStudentByName("Student E");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T11: Search Student by Marks
        try {
            addStudent(129, "Student F", 95, 23);
            searchStudentByMarks(95);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // T12: Sort Students by ID
        try {
            addStudent(130, "Student G", 85, 21);
            addStudent(131, "Student H", 90, 22);
            addStudent(132, "Student I", 88, 20);
            sortStudentsByID();
            displayStudents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addStudent(Object id, String name, float marks, int age) throws Exception {
        if (!(id instanceof Integer)) {
            throw new Exception("Error: Invalid input. Please enter numeric values for ID, marks, and age.");
        }
        int studentID = (Integer) id;
        if (marks < 0 || marks > 100) {
            throw new Exception("Error: Marks must be between 0 and 100");
        }
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                throw new Exception("Student ID already exists");
            }
        }
        students.add(new Student(studentID, name, marks, ""));
    }

    private void deleteStudent(int id) throws Exception {
        boolean removed = students.removeIf(student -> student.getStudentID().equals(id));
        if (!removed) {
            throw new Exception("Error: Student not found");
        }
    }

    private void editStudent(int id, String newName, float newMarks) throws Exception {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                student.setStudentName(newName);
                student.setMarks(newMarks);
                return;
            }
        }
        throw new Exception("Error: Student not found");
    }

    private void searchStudentByID(int id) throws Exception {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                System.out.println("Student found: ID: " + id + ", Name: " + student.getStudentName() + ", Marks: "
                        + student.getMarks());
                return;
            }
        }
        throw new Exception("Error: Student not found");
    }

    private void searchStudentByName(String name) throws Exception {
        for (Student student : students) {
            if (student.getStudentName().equals(name)) {
                System.out.println("Student found: ID: " + student.getStudentID() + ", Name: " + name + ", Marks: "
                        + student.getMarks());
                return;
            }
        }
        throw new Exception("Error: Student not found");
    }

    private void searchStudentByMarks(float marks) throws Exception {
        for (Student student : students) {
            if (student.getMarks() == marks) {
                System.out.println("Student found: ID: " + student.getStudentID() + ", Name: "
                        + student.getStudentName() + ", Marks: " + marks);
                return;
            }
        }
        throw new Exception("Error: Student not found");
    }

    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.getStudentID() + ", Name: " + student.getStudentName() + ", Marks: "
                        + student.getMarks());
            }
        }
    }

    private void sortStudentsByID() {
        students.sort(Comparator.comparing(Student::getStudentID));
    }
}
