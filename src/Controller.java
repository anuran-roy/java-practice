import java.util.*;

public class Controller extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World!");
        try {
            Manager manager = new Manager();
            ArrayList<Student> students  = new ArrayList<Student>();

            students = manager.getStudentsFromFile();

            manager.displayAllDetails(students);

            manager.bulkSaveStudentInfo(students);
        }
        catch (Exception e) {
            System.out.println("Error occured in thread. Stack Trace:\n");
            e.printStackTrace();
        };
    }
}
