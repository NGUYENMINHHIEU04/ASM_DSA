package StudentManagement;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListAddStudent {
    public void addStudent(ArrayList<Student> students, Student objectData){
        try {
            // Check for null student object
            if (objectData == null) {
                throw new IllegalArgumentException("Cannot add a null student object.");
            }
            // Check for null or empty ID
            if (objectData.id == null) {
                throw new IllegalArgumentException("Cannot add student with null ID");
            }
            if (objectData.id.isEmpty()) {
                throw new IllegalArgumentException("Cannot add student with empty ID");
            }

            // Check for duplicate ID
            for (Student student : students) {
                if (Objects.equals(student.id, objectData.id)) {
                    throw new IllegalArgumentException("Cannot add student with duplicate ID: " + objectData.id);
                }
            }

            // Add the student to the list
            students.add(objectData);
            System.out.println("Student added successfully:  " + objectData);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while adding the student: " + e.getMessage());
        }
    }
}

