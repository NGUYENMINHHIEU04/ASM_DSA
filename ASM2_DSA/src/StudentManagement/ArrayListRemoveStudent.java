package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListRemoveStudent {
    public void removeStudentById(ArrayList<Student> students, String id){
        try {
            boolean found = false; // Flag to check if the student was found
            for (int i = 0; i < students.size(); i++) {
                if (Objects.equals(students.get(i).id, id)) {
                    students.remove(i);
                    // Mark as found
                    found = true;
                    System.out.println("Student with ID = " + id + " removed successfully.");
                    return; // Exit after removal
                }
            }
            // If we reach this point, the student was not found
            throw new IllegalArgumentException("Student with ID " + id + " not found for removal.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while removing the student: " + e.getMessage());
        }
    }
}
