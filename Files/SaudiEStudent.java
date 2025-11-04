
public class SaudiEStudent extends Person {

    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";

    String courseName;

    double grade;

    public SaudiEStudent(String name, int id, String courseName, double grade) {
        super(name, id);
        this.courseName = courseName;
        this.grade = grade;
    }
    public boolean isPass() {
        return grade >= 50;
    }
    @Override
    public void displayDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getId());
        System.out.println("Course Name: " + courseName);
        System.out.println("Grade: " +  grade);
        System.err.println("Pass/Fail: " + (isPass() ? GREEN + "Pass" + RESET : RED + "Fail" + RESET));
    }
}
