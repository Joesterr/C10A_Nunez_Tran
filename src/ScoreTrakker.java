import java.util.ArrayList;
import java.io.FileReader;

class ScoreTrakker {
    private ArrayList<Student> studentRecord = new ArrayList<Student>();

    public void loadDataFile(string fileName) {

    }

    public void printInOrder() {

    }
    
    public void processFiles() {
        loadDataFile("scores.txt")
        printInOrder()
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}