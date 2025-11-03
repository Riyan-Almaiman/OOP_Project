

public class SaudiEStudent extends Person {


    private CourseWithGrade[] courses;
    private int courseCount = 0;

    public class CourseWithGrade {
        Course course;
        double grade;
        public CourseWithGrade(Course course, double grade){
            this.course = course;
            this.grade = grade;
        }

        public boolean isPass() {
        return grade >= 60;
         }

    }
    public SaudiEStudent(String name, int id) {
        super(name, id);
        this.courses = new CourseWithGrade[10]; // assume max 10 courses for 1 semester
        this.courseCount = 0;
    }

    public void addCourse(Course course, double grade) {
        if (courseCount < courses.length) {
            courses[courseCount] = new CourseWithGrade(course, grade);
            courseCount++;
        } else {
            System.out.println("Cannot add more courses for " + getName());
        }
    }

        
  
    public void displayDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getId());
        System.out.println("Courses:");

        if (courseCount == 0) {
            System.out.println("No courses.");
        } 
        else
        {
         for (int i = 0; i < courseCount; i++) {
                CourseWithGrade courseWithGrade = courses[i];
                System.out.println("----------------");

                System.out.println("  Course: " + courseWithGrade.course.getCourseName());
                System.out.println("  Code: " + courseWithGrade.course.getCourseCode());
                System.out.println("  Professor: " + courseWithGrade.course.getProfessorName());
                System.out.println("  Grade: " + courseWithGrade.grade);
                System.out.println("  Pass or Fail: " + (courseWithGrade.isPass() ? "Pass" : "Fail"));
                System.out.println("----------------");
            }
        }
    }
}
