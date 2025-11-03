    
    
    public class CourseEnrollment {
        Course course;
        double grade;
        
        public CourseEnrollment(Course course, double grade){
            this.course = course;
            this.grade = grade;
        }

        public boolean isPass() {
        return grade >= 60;
         }

    }