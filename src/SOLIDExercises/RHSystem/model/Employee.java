package SOLIDExercises.RHSystem.model;

public class Employee {
    private String name;
    private String role;
    private double salary;

    public Employee(String name, String role, double salary){
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String getEmployeeName() { return this.name; }
    public String getEmployeeRole() { return this.role; }
    public double getEmployeeSalary() { return this.salary; }

    public void setEmployeeName(String name) { this.name = name; }
    public void setEmployeeRole(String role) { this.role = role; }
    public void setEmployeeSalary(double salary) { this.salary = salary; }
}
