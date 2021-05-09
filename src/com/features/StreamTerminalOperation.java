package com.features;

import com.model.Employee;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalOperation {

    public static void main(String[] args) {

        StreamTerminalOperation terminalOperation = new StreamTerminalOperation();

        //data to play
        List<Employee> employees = terminalOperation.prepareData();

        //foreach
        terminalOperation.listStreamForEach(employees);

        //all match list of employees age are less than 60
        terminalOperation.listAllMatch(employees);


        //any match -> match only Junior Developer
        terminalOperation.listAnyMatch(employees);

        //none match -> none of employees of prouct owner as occupation
        terminalOperation.listNoneMatch(employees);

        //reduce - get only occupations and print comma separated.
        terminalOperation.listReduceAverageAge(employees);

        //count - number of employee greater than age 30
        terminalOperation.listEmployeeCountGreaterThanThirty(employees);

        //collect - print all names
        terminalOperation.collectAllEmployeeNameAsList(employees);

        //min - get Minimum age employee
        terminalOperation.getMinAgeEmployee(employees);

        //max - get Maximum age employee
        terminalOperation.getMaxAgeEmployee(employees);

    }

    private List<Employee> prepareData() {
        Employee employee1 = new Employee(1, "Emp1",35, "Senior Developer");
        Employee employee2 = new Employee(2, "Emp2",40, "Lead Developer");
        Employee employee3 = new Employee(3, "Emp3",20, "Junior Developer");
        Employee employee4 = new Employee(4, "Emp4",55, "Manager");
        Employee employee5 = new Employee(5, "Emp5",28, "UI Developer");
        Employee employee6 = new Employee(6, "Emp6",42, "Software Architect");
        Employee employee7 = new Employee(7, "Emp7",27, "Junior Developer");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);


        return  employees;
    }

    private void listStreamForEach(List<Employee> employees){

        employees.stream().forEach(
                employee -> System.out.println(employee.toString())
        );
    }

    private void listAllMatch(List<Employee> employees) {
        boolean isAllAgeAbove60 = employees.stream().allMatch(
                employee -> employee.getAge() < 60
        );

        System.out.println(isAllAgeAbove60);
    }

    private void listAnyMatch(List<Employee> employees) {
        boolean isAllAgeAbove60 = employees.stream().anyMatch(
                employee -> employee.getOccupation().equals("Junior Developer")
        );

        System.out.println(isAllAgeAbove60);
    }

    private void listNoneMatch(List<Employee> employees) {
        boolean isAllAgeAbove60 = employees.stream().noneMatch(
                employee -> employee.getOccupation().equals("Product Owner")
        );

        System.out.println(isAllAgeAbove60);
    }


    private void listReduceAverageAge(List<Employee> employees) {

        Optional<String> allOccups = employees.stream().
                map(employee -> employee.getName()).
                reduce((name1, name2) -> name1+ " ," +  name2);


        System.out.println(allOccups.get());

    }

    private void listEmployeeCountGreaterThanThirty(List<Employee> employees) {
        long count  = employees.stream().filter(employee -> employee.getAge() > 30).count();
        System.out.println(count);
    }


    private void collectAllEmployeeNameAsList(List<Employee> employees) {

        List<String> names = employees.stream().map(employee -> employee.getName()).collect(Collectors.toList());
        System.out.println("All names :" + names );

    }

    private void getMinAgeEmployee(List<Employee> employees){
        Optional<Employee> employee = employees.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println(employee.toString());
    }

    private void getMaxAgeEmployee(List<Employee> employees){
        Optional<Employee> employee = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        System.out.println(employee.toString());
    }

}
