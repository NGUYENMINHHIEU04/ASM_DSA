package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListEditStudent {
    public void editStudent(ArrayList<Student> students, int position, Student object){
        try {
            // Validate input parameters
            if (object == null) {
                throw new IllegalArgumentException("Cannot edit with a null student object.");
            }
            if (position < 0 || position >= students.size()) {
                throw new IndexOutOfBoundsException("Position is out of bounds");
            }
            students.set(position, object);
            System.out.println("Student edited successfully: " + object);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while editing the student: " + e.getMessage());
        }
    }

    public void editStudentById(ArrayList<Student> students, String id, Student data){
        try {
            boolean found = false; // Flag to check if the student was found
            for (int i = 0; i < students.size(); i++) {
                if (Objects.equals(students.get(i).id, id)) {
                    students.set(i, data);
                    found = true; // Mark as found
                    System.out.println("Student with ID = " + id + " edited successfully.");
                    break; // Exit loop after editing
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Student with ID " + id + " not found.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while editing the student by ID: " + e.getMessage());
        }








    }
}
