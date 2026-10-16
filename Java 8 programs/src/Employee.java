
public class Employee {

    private int id;
    private String name;
    private Double salary;
    private String department;

    public Employee(int id, String name, Double salary, String department) {
        this.id =id;
        this.name =name;
        this.salary = salary;
        this.department = department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSalary(Double salary){
        this.salary =salary;
    }

    public Double getSalary(){
        return salary;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    public String toString(){
        return "Employee{name='" +name+ "',department='" +department+"'}";
    }
}
