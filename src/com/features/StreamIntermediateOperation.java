package com.features;

import com.data.StreamData;
import com.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamIntermediateOperation {

    public static void main(String[] args) {

        List<Employee> employees = StreamData.prepareData();
        List<List<Employee>> allEmps = StreamData.prepareListOfListEmployees();

        // Filter age greater than 40 and print
        StreamIntermediateOperation intermediateOperation = new StreamIntermediateOperation();
        intermediateOperation.listFilterByValue(employees);

        //Map only names
        intermediateOperation.listMapOnlyEmployeeName(employees);

        // flat into single list from list of list employee
        intermediateOperation.flatListEmployee(allEmps);

        //Count distinct Junior developer (There are two after applying distinct count should be 1
        intermediateOperation.distinctJuniorDeveloperFromList(employees);

        //Sort employee list (Default) sort by name
        intermediateOperation.sortEmployeeDefault(employees);

        //Sort employee by age
        intermediateOperation.sortEmployeeAge(employees);

        //peek employee age greater than 40
        intermediateOperation.peekAgeAboveFourtyAndPrintNameInUpperCase(employees);

        // sort by age in asecnd-order and limit the output of 2
        intermediateOperation.sortByAgeAndLimitLowerTwoAges(employees);

        // sort by age in asecnd-order and skip and limit the output of 2
        intermediateOperation.sortByAgeAndLimitSKipTwoLowerTwoAges(employees);

        //Map to integer age of employee and calculate average age
        intermediateOperation.mapToPrimitiveType(employees);
    }


    private void listFilterByValue(List<Employee> employees) {
        employees.stream().filter(employee -> employee.getAge() > 40)
                          .forEach(employee -> System.out.println(employee.toString()));
    }

    private void listMapOnlyEmployeeName(List<Employee> employees) {
        System.out.println("***************");
        List<String> names = employees.stream().map(employee -> employee.getName()).collect(Collectors.toList());

        names.stream().forEach( s -> System.out.println(s));
    }

    private void flatListEmployee(List<List<Employee>> allEmployees) {
        System.out.println("***************");
        List<Employee> employees = allEmployees.stream().flatMap(allEmps -> allEmps.stream()).collect(Collectors.toList());

        employees.stream().forEach(employee -> System.out.println(employee.toString()));
    }

    private void distinctJuniorDeveloperFromList(List<Employee> employees) {
        System.out.println("***************");
        long count = employees.stream().filter(employee -> employee.getOccupation().equals("Junior Developer"))
                          .map(employee -> employee.getOccupation()).distinct().count();
        System.out.println(count);
    }

    private void sortEmployeeDefault(List<Employee> employees) {
        System.out.println("***************");
        employees.stream().sorted().forEach(employee -> System.out.println(employee.toString()));
    }

    private void sortEmployeeAge(List<Employee> employees) {
        System.out.println("***************");
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(employee -> System.out.println(employee.toString()));
    }

    private void peekAgeAboveFourtyAndPrintNameInUpperCase(List<Employee> employees) {
        System.out.println("***************");
        List<String> names = employees.stream().filter( employee -> employee.getAge() > 40)
                .peek(employee -> System.out.println(employee.toString()))
                .map(employee -> employee.getName())
                .map(String::toUpperCase).collect(Collectors.toList());

        names.forEach(s -> System.out.println(s));
    }

    private void sortByAgeAndLimitLowerTwoAges(List<Employee> employees) {
        System.out.println("***************");
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).limit(2)
                .forEach(employee -> System.out.println(employee.toString()));
    }

    private void sortByAgeAndLimitSKipTwoLowerTwoAges(List<Employee> employees) {
        System.out.println("***************");
        employees.stream().sorted(Comparator.comparing(Employee::getAge)).skip(2).limit(2)
                .forEach(employee -> System.out.println(employee.toString()));
    }

    private void mapToPrimitiveType(List<Employee> employees) {
        System.out.println("***************");
        OptionalDouble optionalDouble = employees.stream().mapToInt(value -> value.getAge()).average();
        System.out.println(optionalDouble.getAsDouble());
    }
}
