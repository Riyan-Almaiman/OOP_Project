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
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }


    public static void addStudent(Scanner scanner, ArrayList<SaudiEStudent> students) {
        System.out.println("Enter Name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter ID:");
        int studentId;
        while (true) {
            try {
                studentId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer." + RESET);
            }
        }
        SaudiEStudent student = new SaudiEStudent(studentName, studentId);
        students.add(student);
        System.out.println(GREEN + "Added student: " + studentName + RESET);
    }

    public static void enrollStudentInCourse(Scanner scanner, ArrayList<SaudiEStudent> students,
            ArrayList<Course> courses) {
        if (students.size() == 0) {
            System.out.println(RED + "No students available to enroll." + RESET);
            return;
        }

        System.out.println("Select a student to enroll in a course:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        int studentIndex;
        while (true) {
            try {
                studentIndex = Integer.parseInt(scanner.nextLine()) - 1;
                if (studentIndex >= 0 && studentIndex < students.size()) {
                    break;
                } else {
                    System.out.println(RED + "Please select a valid student number." + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer." + RESET);
            }
        }

        SaudiEStudent selectedStudent = students.get(studentIndex);

        System.out.println("Select a course to enroll in:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
        }
        int courseIndex;
        while (true) {
            try {
                courseIndex = Integer.parseInt(scanner.nextLine()) - 1;
                if (courseIndex >= 0 && courseIndex < courses.size()) {
                    break;
                } else {
                    System.out.println(RED + "Please select a valid course number." + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer." + RESET);
            }
        }

        Course selectedCourse = courses.get(courseIndex);

        System.out.println("Enter grade for the course:");
        double grade;
        while (true) {
            try {
                grade = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter a valid number for grade." + RESET);
            }
        }

        selectedStudent.addCourse(selectedCourse, grade);
        System.out.println(
                GREEN + "Enrolled " + selectedStudent.getName() + " in " + selectedCourse.getCourseName() + RESET);
    }

    public static void addFullTimeEmployee(Scanner scanner, ArrayList<Employee> employees) {
        System.out.println("Enter Name:");
        String fullTimeEmployeeName = scanner.nextLine();
        System.out.println("Enter ID:");
        int employeeId;
        while (true) {
            try {
                employeeId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer." + RESET);
            }
        }
        double monthlySalary;
        while (true) {
            try {
                System.out.println("Enter Monthly Salary:");
                monthlySalary = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter a valid number for salary." + RESET);
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
        while (true) {
            try {
                employeeId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer." + RESET);
            }
        }
        double hourlyRate;
        while (true) {
            try {
                System.out.println("Enter Hourly Rate:");
                hourlyRate = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter a valid number for hourly rate." + RESET);
            }
        }
        int hoursWorked;
        while (true) {
            try {
                System.out.println("Enter Hours Worked:");
                hoursWorked = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter a valid integer for hours worked." + RESET);
            }
        }

        PartTimeEmployee ptEmployee = new PartTimeEmployee(partTimeEmployeeName, employeeId, hourlyRate, hoursWorked);
        employees.add(ptEmployee);
        System.out.println(GREEN + "Added part-time employee: " + partTimeEmployeeName + RESET);
    }

}
