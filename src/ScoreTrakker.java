import java.util.ArrayList;
import java.io.FileReader;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;

class ScoreTrakker {
    private ArrayList<Student> students = new ArrayList<Student>();
    private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

    public ScoreTrakker() {
        students = new ArrayList<>();
    }

    public void loadDataFile(String fileName) throws IOException {
        String line = "";
        FileReader reader = null;
        Scanner scanner = null;

        try {
            reader = new FileReader(fileName);
            scanner = new Scanner(reader);
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
            if (scanner != null) {
                scanner.close();
            }
            if (reader != null) {
                reader.close();
            }
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

    