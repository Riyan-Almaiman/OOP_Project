import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // console colors
    static String GREEN = "\u001B[32m";
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";

    public static void main(String[] args) {

        ArrayList<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isMenuOpen = true;

        // Sample Data
        
        // Sample Student 1 (Pass)
        persons.add(new SaudiEStudent("Radwan Alghawi", 1, "CS230", 98.5));

        // Sample Student 2 (Fail)
        persons.add(new SaudiEStudent("Naif Hani", 2, "CS230", 42));

        //sample student 3 (fail)
         persons.add(new SaudiEStudent("Riyan Almaiman", 2, "CS230", 49));

        
        // Sample Full-Time Employee
        persons.add(new FullTimeEmployee("Dr. Omar Alaqeeli", 101, 35000));
        
        // Sample Part-Time Employee
        persons.add(new PartTimeEmployee("Dr. Mohammad", 202, 120, 15));

        // End of sample data

        while (isMenuOpen) {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Full-Time Employee");
            System.out.println("3. Add Part-Time Employee");
            System.out.println("4. Display All Records");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner, persons);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;

                case "2":
                    addFullTimeEmployee(scanner, persons);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;
                case "3":
                    addPartTimeEmployee(scanner, persons);
                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("All Records:");

                    for (Person person : persons) {
                        System.out.println("----------------");
                        person.displayDetails();
                        System.out.println("----------------");
                    }

                    System.out.println("Enter to continue...");
                    scanner.nextLine();
                    break;

                case "5":
                    isMenuOpen = false;
                    break;

                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    break;
            }
        }

    }

    public static void addStudent(Scanner scanner, ArrayList<Person> persons) {
        int studentId;
        String studentName;
        String courseName;
        double grade;

        // get name input
        System.out.println("Enter Name:");
        studentName = scanner.nextLine();

        // get id by looping until valid input (incase user enters string)
        while (true) {

            System.out.println("Enter ID:");

            try {
                studentId = scanner.nextInt();
                scanner.nextLine(); // clear newline

                // Check if ID already exists
                if (checkifIdExists(persons, studentId)) {
                    System.out.println(RED + "This ID already exists. Please enter a different one." + RESET);
                    continue; // go back to start of loop
                }

                break; // valid input break out of loop
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine(); // clear invalid input
            }
        }
        // get course name and grade
        System.out.println("Enter Course Name:");
        courseName = scanner.nextLine();

        // get grade by looping until valid input (incase user enters string)
        while (true) {
            System.out.println("Enter Grade:");

            try {
                grade = scanner.nextDouble();
                scanner.nextLine();

                // grade validation 0-100
                if (grade < 0 || grade > 100) {
                    System.out.println(RED + "Grade must be from 0 to 100." + RESET);
                    continue; // go back to loop
                }
                break;
            } catch (Exception e) {
                System.out.println(RED + "Please enter a valid number for grade." + RESET);
                scanner.nextLine();
            }
        }
        // create student and add to list of persons
        SaudiEStudent student = new SaudiEStudent(studentName, studentId, courseName, grade);
        persons.add(student);
        System.out.println(GREEN + "Added student: " + studentName + RESET);
    }

    public static void addFullTimeEmployee(Scanner scanner, ArrayList<Person> persons) {
        int employeeId;
        String fullTimeEmployeeName;
        double monthlySalary;

        System.out.println("Enter Name:");
        fullTimeEmployeeName = scanner.nextLine();

        // loop until valid input (incase user enters string)
        while (true) {
            System.out.println("Enter Employee ID:");

            try {
                employeeId = scanner.nextInt();
                scanner.nextLine();
                // Check if ID already exists
                if (checkifIdExists(persons, employeeId)) {
                    System.out.println(RED + "This ID already exists. Please enter a different one." + RESET);
                    continue; // go back to start of loop
                }
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                // not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }

        // loop until valid input (incase user enters string)
        while (true) {
            try {
                System.out.println("Enter Monthly Salary:");
                monthlySalary = scanner.nextDouble();
                scanner.nextLine();

                // salary validation
                if (monthlySalary < 0) {
                    System.out.println(RED + "Enter a valid monthly salary." + RESET);
                    continue; // go back to loop
                }

                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                // not valid try again
                System.out.println(RED + "Please enter a valid number for salary." + RESET);
                scanner.nextLine();
            }
        }

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(fullTimeEmployeeName, employeeId, monthlySalary);
        persons.add(fullTimeEmployee);
        System.out.println(GREEN + "Added full-time employee: " + fullTimeEmployeeName + RESET);
    }

    public static void addPartTimeEmployee(Scanner scanner, ArrayList<Person> persons) {
        double hourlyRate;
        String partTimeEmployeeName;
        int employeeId;
        int hoursWorked;
        System.out.println("Enter Name:");
        partTimeEmployeeName = scanner.nextLine();
        // loop until valid input (incase user enters string)
        while (true) {
            System.out.println("Enter ID:");

            try {
                employeeId = scanner.nextInt();
                scanner.nextLine();
                // Check if ID already exists
                if (checkifIdExists(persons, employeeId)) {
                    System.out.println(RED + "This ID already exists. Please enter a different one." + RESET);
                    continue; // go back to start of loop
                }
                
                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                // not valid try again
                System.out.println(RED + "Please enter an integer." + RESET);
                scanner.nextLine();
            }
        }
        // loop until valid input (incase user enters string)

        while (true) {
            try {
                System.out.println("Enter Hourly Rate:");
                hourlyRate = scanner.nextDouble();
                scanner.nextLine();

                // hourly rate validation
                if (hourlyRate < 0) {
                    System.out.println(RED + "Enter a valid hourly rate." + RESET);
                    continue; // go back to loop
                }

                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                // not valid try again
                System.out.println(RED + "Please enter a valid number for hourly rate." + RESET);
                scanner.nextLine();
            }
        }

        // loop until valid input (incase user enters string)
        while (true) {
            try {
                System.out.println("Enter Hours Worked:");
                hoursWorked = scanner.nextInt();
                scanner.nextLine();

                // hours worked validation
                if (hoursWorked < 0) {
                    System.out.println(RED + "Enter a valid number of hours worked." + RESET);
                    continue; // go back to loop
                }

                break; // when it reaches here that means number is valid so we break
            } catch (Exception e) {
                // not valid try again
                System.out.println(RED + "Please enter a valid integer for hours worked." + RESET);
                scanner.nextLine();
            }
        }

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(partTimeEmployeeName, employeeId, hourlyRate,
                hoursWorked);
        persons.add(partTimeEmployee);
        System.out.println(GREEN + "Added part-time employee: " + partTimeEmployeeName + RESET);
    }

    public static boolean checkifIdExists(ArrayList<Person> persons, int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
