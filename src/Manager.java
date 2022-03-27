import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileReader;

public class Manager {
    
    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter registration number:");
        String regno = sc.next();

        System.out.println("Enter number of subjects:");
        int num = sc.nextInt();

        Student ob = new Student(name, regno);

        for(int i = 0; i < num; i++) {
            System.out.println("Enter subject name:");
            String sub = sc.next();
            System.out.println("Enter marks in "+sub+":");
            int marks = sc.nextInt();
            System.out.println("Pushing the pair ("+sub+","+marks+")...");
            ob.addMarksToCourse(sub, marks);

            System.out.println("Enter credits in "+sub+":");
            int creds = sc.nextInt();
            ob.addCreditsToCourse(sub, creds);
        }
        sc.close();
        return ob;
    }
    
    public ArrayList<Student> getStudentsFromFile() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(new FileReader("data.csv"));

        sc.useDelimiter("\n");

        while(sc.hasNext()) {
            List<String> entries = new ArrayList<>();
            entries = Arrays.asList(sc.next().split(","));

            Student std = new Student(entries.get(0), entries.get(1));

            std.setSemester(entries.get(2), Integer.parseInt(entries.get(3)));
            std.addCreditsToCourse(entries.get(2), Integer.parseInt(entries.get(4)));
            std.addMarksToCourse(entries.get(2), Integer.parseInt(entries.get(5)));

            students.add(std);
        }

        return students;
    } 

    public void displayAllDetails(ArrayList<Student> students) {
        for(Student e: students) {
            e.display();
            // System.out.println(e);
        }
    }

    public void saveStudentInfo(Student std) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data.ser"));

        oos.writeObject(std);
    }

    public void bulkSaveStudentInfo(ArrayList<Student> students) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data.ser"));

        System.out.println("\n\nWriting " + students.size() + " student logs to file...");
        for(Student std: students) {
            oos.writeObject(std);
        }
    }

    public void startJob() throws Exception {
        System.out.println("Hello, World!");

        Manager self = new Manager();
        // Student std = self.createStudent();
    }
}
