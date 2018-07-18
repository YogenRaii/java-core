package com.eprogrammerz.examples.java8.collectors;

import java.text.DecimalFormat;
import java.util.*;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

/**
 * @author Yogen Rai
 */
public class CollectorsExample {
    public static void main(String[] args) {

        Employee john = new Employee("E123", "John Nhoj", 200.99, "IT");
        Employee south = new Employee("E223", "South Htuos", 299.99, "Sales");
        Employee reet = new Employee("E133", "Reet Teer", 300.99, "IT");
        Employee prateema = new Employee("E143", "Prateema Rai", 300.99, "Benefits");
        Employee yogen = new Employee("E323", "Yogen Rai", 200.99, "Sales");

        List<Employee> employees = Arrays.asList(john, south, reet, prateema, yogen);

        // calculating average
        Double averageSalary = employees.stream().collect(averagingDouble(Employee::getSalary));
        System.out.println(averageSalary);

        // calculating total salary
        Double totalSalary = employees.stream().collect(summingDouble(Employee::getSalary));
        System.out.println(totalSalary);

        // calculating all statistics at one shot
        DoubleSummaryStatistics statistics = employees.stream().collect(summarizingDouble(Employee::getSalary));
        System.out.println("Average: " + statistics.getAverage() + ", Total: " + statistics.getSum() + ", Max: " + statistics.getMax() + ", Min: "+ statistics.getMin());

        // calculating max salary
        Double maxSalary = employees.stream().collect(collectingAndThen(maxBy(comparingDouble(Employee::getSalary)), emp -> emp.get().getSalary()));
        System.out.println(maxSalary);

        // formatting result with collectingAndThen
        String avgSalary = employees.stream()
                .collect(collectingAndThen(averagingDouble(Employee::getSalary), new DecimalFormat("'$'0.000")::format));
        System.out.println(avgSalary);

        // mapping data
        List<String> employeeNames = employees.stream().collect(mapping(Employee::getName, toList())); //employees.stream().map(Employee::getName).collect(toList());
        System.out.println(employeeNames);

        // collecting data into string
        String employeeNamesStr = employees.stream().map(Employee::getName).collect(joining(","));
        System.out.println(employeeNamesStr);

        // collecting data into string with more format
        employeeNamesStr = employees.stream().map(Employee::getName).collect(joining(", ", "Employees = {", "}"));
        System.out.println(employeeNamesStr);

        // grouping data with criteria
        Map<String, List<Employee>> deptEmps = employees.stream().collect(groupingBy(Employee::getDepartment));
        System.out.println(deptEmps);

        // grouping data with criteria counting them
        Map<String, Long> deptEmpsCount = employees.stream().collect(groupingBy(Employee::getDepartment, counting()));
        System.out.println(deptEmpsCount);

        // grouping data with criteria and averaging value sorted with key
        Map<String, Double> averageSalaryDeptSorted = employees.stream().collect(groupingBy(Employee::getDepartment, TreeMap::new, averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryDeptSorted);

        // leveraging multi-core architectures; but return type would be ConcurrentHashMap
        System.out.println(employees.stream().collect(groupingByConcurrent(Employee::getDepartment, counting())));

        // finding max
        Optional<Employee> employeeWithMaxSalary = employees.stream().collect(maxBy(comparingDouble(Employee::getSalary)));
        employeeWithMaxSalary.ifPresent(System.out::println);

        // partitioning data
        Map<Boolean, List<Employee>> portionedEmployees = employees.stream().collect(partitioningBy(e -> e.getSalary() > averageSalary));
        System.out.println(portionedEmployees);
    }
}

class Employee {
    private String empId;
    private String name;
    private Double salary;
    private String department;

    public Employee(String empId, String name, Double salary, String department) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
