package StudentManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student  {
    public String fullName;
    public String id;
    public double mark;
    public String rank;

    public Student(String id, String fullName, double mark){
        this.id = id;
        this.fullName = fullName;
        this.mark = mark;
        if(this.mark >= 0 && this.mark <5){
            this.rank = "Fail";
        } else if (this.mark >=5 && this.mark < 6.5) {
            this.rank = "Medium";
        } else if (this.mark >= 6.5 && this.mark < 7.5) {
            this.rank = "Good";
        } else if (this.mark >= 7.5 && this.mark < 9) {
            this.rank = "Very Good";
        } else if(this.mark >= 9 && this.mark <= 10){
            this.rank = "Excellent";
        } else {
            this.rank = null;
        }
    }
    //getter and setter java for fullname
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public double getMark(){
        return mark;
    }
    public void setMark(double mark){
        this.mark = mark;
    }


    public static Comparator<Student> IdStudentComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String idStu1 = o1.getId().toUpperCase();
            String idStu2 = o2.getId().toUpperCase();
            return  idStu1.compareTo(idStu2);
        }
    };
    public static Comparator<Student> FullNameStduComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String fullName1 = o1.getFullName().toUpperCase();
            String fullName2 = o2.getFullName().toUpperCase();
            return fullName1.compareTo(fullName2);
        }
    };

    public static Comparator<Student> MarkStduComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            double mark1 = o1.getMark();
            double mark2 = o2.getMark();
            if(mark1 < mark2){
                return -1;
            } else if (mark2 < mark1) {
                return 1;
            }
            return 0;
        }
    };

    @Override
    public String toString() {
        return "[ID = "+ id +" , fullName = " + fullName + ", mark = " + mark + " , rank  = " + rank + " ]";
    }

    public void bubbleSort(List<Student> students) {
        int n = students.size();
        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for bubbling up the largest element
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent elements
                if (students.get(j).getMark() > students.get(j + 1).getMark()) {
                    // Swap if they are in the wrong order
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true; // A swap occurred
                }
            }

            // If no two elements were swapped, the list is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public void insertionSortById(ArrayList<Student> students) {
        int n = students.size();

        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            Student key = students.get(i);
            int j = i - 1;

            // Move elements of students[0..i-1] that are greater than key.id
            // to one position ahead of their current position
            while (j >= 0 && students.get(j).getId().compareToIgnoreCase(key.getId()) > 0) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
    }
}
    /*
    @Override
    public int compareTo(Student compareStu) {
        if(this.mark < compareStu.getMark()){
            return  -1;
        } else if (compareStu.getMark() < this.mark) {
            return 1;
        }
        return 0;
    }



     */
