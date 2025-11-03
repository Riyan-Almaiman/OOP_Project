public class Course {
    
    private String courseName;
    private String courseCode;
    private String professorName;

    public Course(String courseName, String courseCode, String professorName) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.professorName = professorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getProfessorName() {
        return professorName;
    }


}
