import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // console colors
    static String GREEN = "\u001B[32m";
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";


    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<SaudiEStudent> students = new ArrayList<>();

        courses.add(new Course("Object Oriented Programming", "CS230", "Dr. Omar Alaqeeli"));
        courses.add(new Course("Digital Logic Design", "CS231", "Dr. Hamad Alismail"));
        courses.add(new Course("Physics 1", "SCI101", "Dr. Yousef Kareri"));

        Scanner scanner = new Scanner(System.in);
        boolean isMenuOpen = true;

        while (isMenuOpen) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Full-Time Employee");
            System.out.println("3. Add Part-Time Employee");
            System.out.println("4. Display All Records");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner, students);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;

                case "2":
                    addFullTimeEmployee(scanner, employees);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;
                case "3":
                    addPartTimeEmployee(scanner, employees);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();  
                    break;
                case "4":
                    System.out.println("------------- Employees ---------------------");
                    if (employees.size() == 0) {
                        System.out.println(RED + "No employees to display." + RESET);
                    }
                    for (Employee employee : employees) {
                        employee.displayDetails();
                        System.out.println("----------------");
                    }
                    System.out.println("------------- Students ---------------------");
                    if (students.size() == 0) {
                        System.out.println(RED + "No students to display." + RESET);
                    }
                    for (SaudiEStudent student : students) {
                        student.displayDetails();
                        System.out.println("----------------");
                    }
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;
                case "5":
                    enrollStudentInCourse(scanner, students, courses);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;
                case "6":
                    isMenuOpen = false;
                    break;

                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    break;
            }
        }

    }


    public static void addStudent(Scanner scanner, ArrayList<SaudiEStudent> students) {
        System.out.println("Enter Name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter ID:");
        int studentId;

        //loop until valid input (incase user enters string)
        while (true) {
            try {
                studentId = scanner.nextInt();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }
        SaudiEStudent student = new SaudiEStudent(studentName, studentId);
        students.add(student);
        System.out.println(GREEN + "Added student: " + studentName + RESET);
    }

    public static void enrollStudentInCourse(Scanner scanner, ArrayList<SaudiEStudent> students,
            ArrayList<Course> courses) {
        //if no students in the list return
        if (students.size() == 0) {
            System.out.println(RED + "No students available to enroll." + RESET);
            return;
        }
        //create menu from list 
        System.out.println("Select a student to enroll in a course:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        int studentIndex;
        //loop until valid input (incase user enters string)
        while (true) {
            try {
                //get user input (index starts from 0 subtract 1)
                studentIndex = scanner.nextInt() - 1;
                //check if input is in range of the list (must be greater than or equal to 0 and less than size)
                if (studentIndex >= 0 && studentIndex < students.size()) {
                    break; // valid input so break the loop
                } else {
                    System.out.println(RED + "Please select a valid student number." + RESET);
                }
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }
        //find selected student from the list
        SaudiEStudent selectedStudent = students.get(studentIndex);

        System.out.println("Select a course to enroll in:");
        //create menu from course list
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }
        int courseIndex;
        //loop until valid input (incase user enters string)
        while (true) {
            try {
                //get user input (index starts from 0 subtract 1)
                courseIndex = scanner.nextInt() - 1;
                //check if input is in range of the list (must be greater than or equal to 0 and less than size)
                if (courseIndex >= 0 && courseIndex < courses.size()) {
                    break; // valid input so break the loop
                } else {
                    System.out.println(RED + "Please select a valid course number." + RESET);
                }
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }

        //find selected course from the list
        Course selectedCourse = courses.get(courseIndex);

        System.out.println("Enter grade for the course:");
        double grade;
        //loop until valid input (incase user enters string)
        while (true) {
            try {
                grade = scanner.nextDouble();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter a valid number for grade." + RESET);
                scanner.nextLine();
            }
        }

        selectedStudent.addCourse(selectedCourse, grade);
        System.out.println(GREEN + "Enrolled " + selectedStudent.getName() + " in " + selectedCourse.getCourseName() + RESET);
    }

    public static void addFullTimeEmployee(Scanner scanner, ArrayList<Employee> employees) {
        System.out.println("Enter Name:");
        String fullTimeEmployeeName = scanner.nextLine();
        System.out.println("Enter ID:");
        int employeeId;
         //loop until valid input (incase user enters string)
        while (true) {
            try {
                employeeId = scanner.nextInt();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }
        double monthlySalary;

         //loop until valid input (incase user enters string)
        while (true) {
            try {
                System.out.println("Enter Monthly Salary:");
                monthlySalary = scanner.nextDouble();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter a valid number for salary." + RESET);
                scanner.nextLine();
            }
        }
        FullTimeEmployee ftEmployee = new FullTimeEmployee(fullTimeEmployeeName, employeeId, monthlySalary);
        employees.add(ftEmployee);
        System.out.println(GREEN + "Added full-time employee: " + fullTimeEmployeeName + RESET);
    }

    public static void addPartTimeEmployee(Scanner scanner, ArrayList<Employee> employees) {
        System.out.println("Enter Name:");
        String partTimeEmployeeName = scanner.nextLine();
        System.out.println("Enter ID:");
        int employeeId;
        //loop until valid input (incase user enters string)
        while (true) {
            try {
                employeeId = scanner.nextInt();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }
        double hourlyRate;
        //loop until valid input (incase user enters string)

        while (true) {
            try {
                System.out.println("Enter Hourly Rate:");
                hourlyRate = scanner.nextDouble();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter a valid number for hourly rate." + RESET);
                scanner.nextLine();
            }
        }
        int hoursWorked;
        //loop until valid input (incase user enters string)

        while (true) {
            try {
                System.out.println("Enter Hours Worked:");
                hoursWorked = scanner.nextInt();
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                //not valid try again
                System.out.println(RED + "Please enter a valid integer for hours worked." + RESET);
                scanner.nextLine();
            }
        }

        PartTimeEmployee ptEmployee = new PartTimeEmployee(partTimeEmployeeName, employeeId, hourlyRate, hoursWorked);
        employees.add(ptEmployee);
        System.out.println(GREEN + "Added part-time employee: " + partTimeEmployeeName + RESET);
    }

}
