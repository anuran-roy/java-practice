import java.io.*;
import java.util.*;

public class Student implements Serializable {
    public Student(String nm, String reg) {
        name = nm;
        regno = reg;
    }

    /*
    The following methods are synchronized because
    they are used by multiple threads, but need to 
    have a single source of truth.
     */
    
    public synchronized void addMarksToCourse(String subject, int marks) {
        courseMap.get(subject).put("Marks", marks);
    }

    public synchronized void addCreditsToCourse(String subject, int credits) {
        courseMap.get(subject).put("Credits", credits);
    }

    public synchronized void setSemester(String subject, int semester) {
        HashMap<String, Integer> internal = new HashMap<String, Integer>();

        internal.put("semester", semester);
        courseMap.put(subject, internal);
    }

    public synchronized int getMarks(String subject) {
        return courseMap.get(subject).get("Marks");
    }

    public synchronized int getCredits(String subject) {
        return courseMap.get(subject).get("Credits");
    }

    public synchronized int getSemester(String subject) {
        return courseMap.get(subject).get("semester");
    }

    public void showMap(HashMap<String, HashMap<String, Integer>> courseData) {
        for(Map.Entry<String, HashMap<String, Integer>> e: courseData.entrySet()) {
            System.out.println(e.getKey() + " : ");

            for(Map.Entry<String, Integer> k: e.getValue().entrySet()) {
                System.out.println(k.getKey() + " : " + k.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return name + "'s Student Profile (" + regno + ")";
    }

    public void display() {
        System.out.println("\nName of student: "+ name);
        System.out.println("\nRegistration Number of student: "+ regno);

        System.out.println("\nSubjects taken: ");

        for(Map.Entry<String, HashMap<String, Integer>> e: courseMap.entrySet()) {
            System.out.println("Subject Details:\t" + e.getKey());

            for(Map.Entry<String, Integer> e2: e.getValue().entrySet()) {
                System.out.println(e2.getKey()+":\t"+e2.getValue());
            }
        }
    }

    HashMap<String, HashMap<String, Integer>> courseMap = new HashMap<String, HashMap<String, Integer>>();
    String name;
    String regno;
    int sem;
}
