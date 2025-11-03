public class Main {
    public static void main(String[] args) {
        // create course objects
        Course objectedOrientedProgramming = new Course("Object Oriented Programming", "CS230", "Dr. Omar Alaqeeli");
        Course digitalLogicDesign = new Course("Digital Logic Design", "CS231", "Dr. Hamad Alismail");

        // create student objects
        SaudiEStudent riyan = new SaudiEStudent("Riyan", 101);
        SaudiEStudent naif = new SaudiEStudent("Naif", 102);
        SaudiEStudent unknown = new SaudiEStudent("Unknown", 103);

        // add course with grade to student object 
        riyan.addCourse(objectedOrientedProgramming, 100);
        riyan.addCourse(digitalLogicDesign, 100);

        naif.addCourse(objectedOrientedProgramming, 100);
        naif.addCourse(digitalLogicDesign, 100);

        unknown.addCourse(objectedOrientedProgramming, 100);
        unknown.addCourse(digitalLogicDesign, 100);

        // display all student info
        riyan.displayDetails();
        System.out.println("--------------------------------------------------");
        naif.displayDetails();
        System.out.println("--------------------------------------------------");   
        unknown.displayDetails();
    }
}
