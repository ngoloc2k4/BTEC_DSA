package Student;

import java.util.ArrayList;

// Custom Exception for Duplicate Student ID
class DuplicateStudentIdException extends Exception {
    public DuplicateStudentIdException(String message) {
        super(message);
    }
}

// Custom Exception for Invalid Input
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class Student {
    private Integer studentID;
    private String studentName;
    private float marks;
    private String rank;
    private ArrayList<Student> students = new ArrayList<>();

    // Constructor
    public Student(Integer studentID, String studentName, float marks, String ranks) throws InvalidInputException {
        if (studentID == null || studentName == null || studentName.isEmpty()) {
            throw new InvalidInputException("Student ID and Name cannot be null or empty");
        }
        if (marks < 0 || marks > 100) {
            throw new InvalidInputException("Marks must be between 0 and 100");
        }
        this.studentID = studentID;
        this.studentName = studentName;
        this.marks = marks;
        setRankBasedOnMarks(); // Automatically assign rank on creation
    }

    // Getters and Setters

    public Integer getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public float getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }

    public void setStuentName(String studentName) throws InvalidInputException {
        if (studentName == null || studentName.isEmpty()) {
            throw new InvalidInputException("Name cannot be null or empty");
        }
        this.studentName = studentName;
    }

    public void setMarks(float marks) throws InvalidInputException {
        if (marks < 0 || marks > 100) {
            throw new InvalidInputException("Marks must be between 0 and 100");
        }
        this.marks = marks;
        setRankBasedOnMarks(); // Recalculate rank when marks change
    }

    // Set rank based on marks
    private void setRankBasedOnMarks() {
        if (marks >= 90) {
            rank = "Excellent";
        } else if (marks >= 75) {
            rank = "Very Good";
        } else if (marks >= 65) {
            rank = "Good";
        } else if (marks >= 50) {
            rank = "Medium";
        } else {
            rank = "Fail";
        }
    }

    // Override toString method
    @Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + studentName + ", Marks: " + marks + ", Rank: " + rank;
    }

    // Student Manager Class
    public void StudentManager() {
        students = new ArrayList<>();
    }

    // Add Student
    public void addStudent(Student student) throws DuplicateStudentIdException {
        if (isStudentIdExists(student.getStudentID())) {
            throw new DuplicateStudentIdException("Student ID already exists");
        }
        students.add(student);
    }

    // Edit Student
    public void editStudent(String studentID, String newName, float newMarks) throws InvalidInputException {
        if (newName == null || newName.isEmpty()) {
            throw new InvalidInputException("Name cannot be null or empty");
        }
        if (newMarks < 0 || newMarks > 100) {
            throw new InvalidInputException("Marks must be between 0 and 100");
        }
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                student.setStuentName(newName);
                student.setMarks(newMarks);
                return;
            }
        }
        System.out.println("Student with ID " + studentID + " not found.");
    }

    // Delete Student
    public void deleteStudent(String studentID) {
        students.removeIf(student -> student.getStudentID().equals(studentID));
    }

    // Sort student by marks
    public void sortStudentsByMarks() {
        students.sort((s1, s2) -> Float.compare(s2.getMarks(), s1.getMarks()));
    }

    // Search student by ID
    public Student searchStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null; // Student not found
    }

    // display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    // rank All Strudents
    public void rankAllStudents() {
        for (Student student : students) {
            student.setRankBasedOnMarks();
        }
    }

    // Sort Students by marks using Bubble Sort
    public void bubbleSortStudents() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Students sorted by marks using Bubble Sort:");
    }

    // Sort Students by marks using Merge Sort

    public void mergeSortStudents() {
        mergeSortHelper(0, students.size() - 1);
        System.out.println("Students sorted by marks using Merge Sort:");
    }

    public void mergeSortHelper(int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }

    }

    public void merge(int left, int mid, int right) {
        ArrayList<Student> leftHalf = new ArrayList<>(students.subList(left, mid + 1));
        ArrayList<Student> rightHalf = new ArrayList<>(students.subList(mid + 1, right + 1));
        int i = 0, j = 0, k = left;

        while (i < leftHalf.size() && j < rightHalf.size()) {
            if (leftHalf.get(i).getMarks() < rightHalf.get(j).getMarks()) {
                students.set(k, leftHalf.get(i));
                i++;
            } else {
                students.set(k, rightHalf.get(j));
                j++;
            }
            k++;
        }
        while (i < leftHalf.size()) {
            students.set(k, leftHalf.get(i));
            i++;
            k++;
        }
        while (j < rightHalf.size()) {
            students.set(k, rightHalf.get(j));
        }
    }

    // Search student by ID, Name, or Marks using Quick Search
    public void quickSearch(String searchTerm) {
        boolean found = false;
        for (Student student : students) {
            if (searchTerm.matches("\\d+") && Integer.parseInt(searchTerm) == student.getStudentID()) {
                System.out.println(student);
                found = true;
            } else if (student.getStudentName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(student);
                found = true;
            } else if (String.valueOf(student.getMarks()).equals(searchTerm)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found matching the search term.");
        }
    }

    private boolean isStudentIdExists(int id) {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Logging example
    private void logError(String message) {
        // Simple console logging; replace with a logging framework in production
        System.err.println("ERROR: " + message);
    }

    // Example of using try-catch for error handling
    public void safeAddStudent(Student student) {
        try {
            addStudent(student);
        } catch (DuplicateStudentIdException e) {
            logError(e.getMessage());
        }
    }
}
