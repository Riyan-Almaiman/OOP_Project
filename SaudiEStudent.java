

public class SaudiEStudent extends Person {


    private CourseEnrollment[] courses;
    private int courseCount = 0;


        public SaudiEStudent(String name, int id) {
            super(name, id);
            this.courses = new CourseEnrollment[10]; // assume max 10 courses for 1 semester
            this.courseCount = 0;
        }

        public void addCourse(Course course, double grade) {
            if (courseCount < courses.length) {
                courses[courseCount] = new CourseEnrollment(course, grade);
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

                
                System.out.println("----------------");

                System.out.println("  Course: " + courses[i].course.getCourseName());
                System.out.println("  Code: " + courses[i].course.getCourseCode());
                System.out.println("  Professor: " + courses[i].course.getProfessorName());
                System.out.println("  Grade: " + courses[i].grade);
                System.out.println("  Pass or Fail: " + (courses[i].isPass() ? "Pass" : "Fail"));
                System.out.println("----------------");
            }
        }
    }
}
