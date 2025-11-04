public abstract class Employee extends Person {
 

    public Employee(String name, int id) {
        super(name, id);
    
    }

    public abstract double calculateSalary();
}
