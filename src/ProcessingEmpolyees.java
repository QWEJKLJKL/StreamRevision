import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmpolyees {
    public static void main(String[] args){
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")};

        List<Employee> list = Arrays.asList(employees);

        System.out.println("Complete Employee list: ");
        list.stream().forEach(System.out::println);

        //Predicate that returns true for salaries in the range $4000-$6000

        Predicate<Employee> fourToSixThousand =
                e ->((e.getSalary()>=4000) && (e.getSalary()<=6000));

        System.out.println();
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        System.out.println();

        Employee emp = list.stream()
                .filter(fourToSixThousand)
                .findFirst()
                .get();

        System.out.println(emp);

        //Functions for getting first and last names from an Employee
        Function<Employee,String> byFirstName = (employee -> employee.getFirstName());
        Function<Employee,String> byLastName = Employee::getLastName;


        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byFirstName).thenComparing(byFirstName);
        //sort employees in descending order by last name, then first name
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        System.out.println("\nDescending order");
        //descending order
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        //display unique employee last names sorted
        //找出不重复的姓并排序(倒序)
        list.stream()
                .map(byLastName)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println();

        //display only first and last names
        list.stream()
                .map((e) -> e.getLastName() +" "+ e.getFirstName())
                .sorted()
                .forEach(System.out::println);
//----------------------------------------------------------------------------------------------------------------------
        //group Employees by department
        //并且打印
        System.out.println();
        Map<String,List<Employee>> groupedByDepartment =
                list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(groupedByDepartment);

        groupedByDepartment.forEach(
                (department,employeesInDepartment) -> {
                    System.out.println(department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("\t%s%n",employees)
                    );
                }
        );
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        //count number of Employees in each department
        Map<String,Long> employeeCountByDepartment =
                list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        employeeCountByDepartment.forEach(
                (department,count) -> System.out.printf(
                        "%s has %d employee(s)%n",department,count
                )
        );
//----------------------------------------------------------------------------------------------------------------------
        System.out.println();
        //sum of Employee salaries with DoubleStream sum method
        double sum1 = list.stream()
                        .map(Employee::getSalary)
                        .reduce(0.0,(x,y) -> x + y);
        double sum2 = list.stream()
                            .mapToDouble(Employee::getSalary)
                            .sum();

        System.out.println(sum1 + " " + sum2);


        //average of Employee salaries
        System.out.println();
        double result = list.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }

}
