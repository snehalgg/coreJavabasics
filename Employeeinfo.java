class Employee {
    String name;
    int yearOfJoining;
    double salary;
    String address;

 

    public Employee(String name, int yearOfJoining, double salary, String address) {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;
    }
}

 

 public class Employeeinfo {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Robert", 1994, 50000.0, "64C- Walls Street");
        Employee employee2 = new Employee("Sam", 2000, 60000.0, "68D- Walls Street");
        Employee employee3 = new Employee("John", 1999, 55000.0, "26B- Walls Street");

 

        System.out.println("Name\n" + employee1.name + "\n" + employee2.name + "\n" + employee3.name + "\n");
        System.out.println("Year of joining\n" + employee1.yearOfJoining + "\n" + employee2.yearOfJoining + "\n" + employee3.yearOfJoining + "\n");
        System.out.println("Address\n" + employee1.address + "\n" + employee2.address + "\n" + employee3.address + "\n");
    }
}