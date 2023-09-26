import java.util.ArrayList;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.IOException;

class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<Student>;

    public ScoreTrakker() {
        students = new ArrayList<>();
    }
    
    public void loadDataFile(string fileName) {
        FileReader reader = new FileReader(fileName);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());
            students.add(new Student(name, score));
        }
       
        scanner.close();
        reader.close();
    }

    public void printInOrder() {
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void processFiles() {
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}