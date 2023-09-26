/**
 * Student - Represents a student with a name and a score.
 */
class Student implements Comparable<Student> {
    private String name; // Student's name
    private int score;   // Student's score

    /**
     * Constructor to initialize a Student object with a name and a score.
     *
     * @param name  The name of the student.
     * @param score The score of the student.
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * CompareTo method to allow sorting of Student objects based on their names.
     *
     * @param other The other Student object to compare to.
     */
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    /**
     * toString method to provide a string representation of the Student object.
     *
     * @return A string containing the student's name and score.
     */
    @Override
    public String toString() {
        return name + " " + score;
    }
}

