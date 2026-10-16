import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        String s = "nanjundaswamy";
    // Reverse a String
        StringBuilder builder = new StringBuilder(s).reverse();
        System.out.println(builder);
        s.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
    // Print Duplicates
        Set<Character> set = new HashSet<>();
        s.chars().mapToObj(c -> (char) c).filter(n -> !set.add(n)).forEach(System.out::println);
    //No Of Occurances
        Map<Character, Long> countChar = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(countChar);
        // use java 8
        String reversed = s.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a);
        System.out.println(reversed);

        // duplicate characters in a given string
        Set<Character> seen = new HashSet<>();
        s.chars().mapToObj(c -> (char) c).filter(c -> !seen.add(c)).forEach(System.out::println);

    //Find Second Highest Number
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        Integer secondHighestNum = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);

        System.out.println(secondHighestNum);

        //
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 50000.0, "IT"),
                new Employee(2, "David", 80000.0, "IT"),
                new Employee(3, "Sam", 90000.0, "HR"),
                new Employee(4, "Mike", 70000.0, "HR")
        );
        // second highest salary

        Employee sHs = employees.stream().distinct().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null);

        System.out.println(sHs.getSalary());

        Map<String, Optional<Employee>> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        slry -> slry.stream()
                                                .sorted(Comparator.comparing(Employee::getSalary)
                                                        .reversed())
                                                .skip(1)
                                                .findFirst()
                                )
                        ));

        System.out.println(result.toString());

// second highest salary group by department
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        t -> t.stream().distinct().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst())));

//
     Map<String, String> longestEmpNameByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(e->e.getName().length())), e->e.get().getName())));

     System.out.println("longestEmpNameByDept : "+longestEmpNameByDept);

    employees.stream().collect(Collectors.groupingBy
            (Employee::getDepartment, Collectors.collectingAndThen
                    (Collectors.maxBy(Comparator.comparing(e->e.getName().length())
                    ),e->e.get().getName())));


  Optional<Employee> name = employees.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.getName().length())));
        System.out.println("name: "+name);
  String longestEmpName   =  employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(e->e.getName().length()))).map(Employee::getName).orElse("");

        System.out.println("LongestEmpName: "+longestEmpName);

        // secondlongestName
      String secondlongestName =  employees.stream().map(Employee::getName).sorted(Comparator.comparingInt(String::length).reversed()).skip(1).findFirst().orElse(null);
        System.out.println("secondlongestName: "+secondlongestName);

       Double salary =  employees.stream().map(Employee::getSalary).sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
        System.out.println("Salary: "+salary);
        Optional<Employee> salary1 =                                                                                                                                                                                                   employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
        System.out.println("salary1: "+salary1);


        String str = "stress";

        str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
                .findFirst()
                .ifPresent(System.out::println);


    }



}



