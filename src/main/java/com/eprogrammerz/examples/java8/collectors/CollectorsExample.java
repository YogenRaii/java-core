package com.eprogrammerz.examples.java8.collectors;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * @author Yogen Rai
 */
public class CollectorsExample {
    public static void main(String[] args) {

        Employee john = new Employee("E123", "John Nhoj", 200.99);
        Employee south = new Employee("E223", "South Htuos", 299.99);
        Employee reet = new Employee("E133", "Reet Teer", 300.99);
        Employee prateema = new Employee("E143", "Prateema Rai", 300.99);
        Employee yogen = new Employee("E323", "Yogen Rai", 200.99);

        List<Employee> employees = Arrays.asList(john, south, reet, prateema, yogen);
        Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(averageSalary);

        Double totalSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(totalSalary);

        DoubleSummaryStatistics statistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average: " + statistics.getAverage() + ", Total: " + statistics.getSum() + ", Max: " + statistics.getMax() + ", Min: "+ statistics.getMin());

        List<String> employeeNames = employees.stream().collect(Collectors.mapping(Employee::getName, Collectors.toList()));
        System.out.println(employeeNames);

        String employeeNamesStr = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(employeeNamesStr);

        employeeNamesStr = employees.stream().map(Employee::getName).collect(Collectors.joining(", ", "Employees = {", "}"));
        System.out.println(employeeNamesStr);

        Map<Double, List<Employee>> equalIncomeEmps = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(equalIncomeEmps);

        Map<Double, Long> equalIncomeEmpsCount = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));
        System.out.println(equalIncomeEmpsCount);

        Map<Double, Long> equalIncomeEmpsSorted = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, TreeMap::new, Collectors.counting()));
        System.out.println(equalIncomeEmpsSorted);

        System.out.println(employees.stream().collect(Collectors.groupingByConcurrent(Employee::getSalary)));

        Optional<Employee> employeeWithMaxSalary = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        employeeWithMaxSalary.ifPresent(System.out::println);

        Map<Boolean, List<Employee>> portionedEmployees = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > averageSalary));
        System.out.println(portionedEmployees);
    }
}

class Employee {
    private String empId;
    private String name;
    private Double salary;

    public Employee(String empId, String name, Double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
