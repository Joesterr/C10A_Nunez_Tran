import java.util.ArrayList;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.IOException;

class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<Student>;
    private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

    public ScoreTrakker() {
        students = new ArrayList<>();
    }
    
    public void loadDataFile(string fileName) throws IOException {
        String line = "";
        String name = "";

        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                String scoreError = scanner.nextLine();
                try {
                    int score = Integer.parseInt(scanner.nextLine());
                    students.add(new Student(name, score));
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect Format for " + name + " not a valid score: " + scoreError);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't open file: " + fileName);
        } finally {
            scanner.close();
            reader.close();
        }
    }

    public void printInOrder() {
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void processFiles() {
        for (String fileName : files) {
            try {
                loadDataFile(fileName);
                printInOrder();
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
            } catch (IOException e) {
                System.out.println("Error processing file: " + fileName);
            }
        }
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}

    