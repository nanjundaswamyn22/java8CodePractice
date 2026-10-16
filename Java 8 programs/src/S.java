import java.util.*;
import java.util.stream.Collectors;

public class S {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 50000.0, "IT"),
                new Employee(2, "David", 80000.0, "IT"),
                new Employee(3, "Sam", 90000.0, "HR"),
                new Employee(4, "Mike", 70000.0, "HR")
        );

        // Find the second highest Salary of the employee

        Double secondHighestSalary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondHighestSalary : " +secondHighestSalary);

     String employee =  employees.stream().filter(e->e.getSalary().equals(secondHighestSalary)).map(Employee::getName).findFirst().orElse(null);
        System.out.println("Employee : "+employee);

        // second highest salary group by department
        Map<String, Employee> grpByDept =  employees.stream()
                   .collect(
                           Collectors.groupingBy(
                                   Employee::getDepartment, Collectors.collectingAndThen(
                                           Collectors.toList(),
                                           s->s.stream().distinct().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1).findFirst().orElse(null))));

        System.out.println("grpByDept : "+grpByDept);

     // LongestEmployeeName
     Employee longestEmployeeName = employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(s->s.getName().length()))).orElse(null);
        System.out.println("LongestEmployeeName : "+longestEmployeeName.getName());

        Employee secondLongestEmployeeName =  employees.stream().sorted(Comparator.comparingInt((Employee e)->e.getName().length())).skip(1).findFirst().orElse(null);
        System.out.println("secondLongestEmployeeName : "+secondLongestEmployeeName);

     //LongestEmployeeName groupByDept
       Map<String, Employee> LongestEmployeeNameGroupByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                 Collectors.collectingAndThen(Collectors.toList(),
                         e->e.stream().max(Comparator.comparingInt(s -> s.getName().length())).orElse(null))));
        System.out.println("LongestEmployeeNameGroupByDept : "+LongestEmployeeNameGroupByDept);

        //SecondLongestEmployeeName groupByDept
        Map<String,Employee> secondLongestEmployeeNameByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list->list.stream().sorted(Comparator.comparingInt((Employee e)->e.getName().length()).reversed()).skip(1).findFirst().orElse(null))));
        System.out.println("secondLongestEmployeeNameByDept : "+secondLongestEmployeeNameByDept);

       Double salary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
        System.out.println(salary);

        // count the no of employees grp by dept
       Map<String, Long> countByDept =  employees.stream().collect(Collectors.groupingBy(Employee::getDepartment ,Collectors.counting()));
        System.out.println("countByDept : "+countByDept);

      Map<String,Employee> ss =employees.stream().collect(Collectors.groupingBy(
              Employee::getDepartment, Collectors.collectingAndThen(
                      Collectors.toList(),
                      e->e.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).distinct().skip(1).findFirst().orElse(null)
              )
      ));
        System.out.println(ss);
    }


}
