package exercise1;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmpolyees {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")};

        //转成list
        List<Employee> employees1 = Arrays.asList(employees);
        employees1.forEach(System.out::println);
        System.out.println();

        //工资在4000-到6000以内,并根据工资排序. 创建一个Predicate 函数
        Predicate<Employee> fourToSixThousand = e -> (e.getSalary()>=4000)&&(e.getSalary()<=6000);

        Function<Employee,Double> empolyeeSalary = e -> e.getSalary();
        employees1.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(empolyeeSalary))
                .forEach(System.out::println);

        //获取员工姓和名
        employees1.stream()
                .map(e -> e.getLastName() + " " + e.getFirstName())
                .forEach(System.out::println);
        //先按照名,再按照姓排倒序
        employees1.stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .forEach(System.out::println);
        Employee emp = employees1.stream()
                                .filter(fourToSixThousand)
                                .findFirst()
                                .get();

        //定义Function
        Function<Employee,String> byFirstName = e -> e.getFirstName();
        Function<Employee,String> byLastName = e -> e.getLastName();

        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);

        //找出不重复的姓并排序(倒序)
        employees1.stream()
                .map(byLastName)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //Group Employees by department
        //并计算总人数
        System.out.println();
        Map<String,Long> groupedByDepartment =
                employees1.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        //按组打印
        groupedByDepartment.forEach(
                (department, count) ->{
                    System.out.printf("Department: %s\tNumbers:%d\n",department,count);
                }
        );

        System.out.println();
        Map<String,List<Employee>> groupedByDepartment2 =
                employees1.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment2.forEach((department, employeesInDepartment) ->{
            System.out.println(department);
            employeesInDepartment.forEach(
                    employee -> System.out.printf("\t%s%n", employees)
            );
        });

        //sum of Employee salaries with DoubleStream sum method
        double sum1 = employees1.stream()
                                .map(Employee::getSalary)
                                .reduce(0.0,(x,y) -> x +y);

        //sum of salaries

        double sum2 = employees1.stream()
                                .mapToDouble(Employee::getSalary)
                                .sum();

        double average2 = employees1.stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .getAsDouble();
    }
}
