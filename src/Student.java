class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareEach(Student other) {
        return this.name.compareEach(other.name);
    }

    @Override
    public String toString() {
        return name + " " + score;
    }
}