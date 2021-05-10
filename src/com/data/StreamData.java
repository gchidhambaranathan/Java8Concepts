package com.data;

import com.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class StreamData {

    public static List<Employee> prepareData() {
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

    public static List<List<Employee>> prepareListOfListEmployees()  {

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


        Employee employee8 = new Employee(8, "Emp8",35, "Senior Developer");
        Employee employee9 = new Employee(9, "Emp9",40, "Lead Developer");
        Employee employee10 = new Employee(10, "Emp10",20, "Junior Developer");
        Employee employee11 = new Employee(11, "Emp11",28, "UI Developer");
        Employee employee12 = new Employee(12, "Emp12",42, "Software Architect");
        Employee employee13 = new Employee(13, "Emp13",27, "Junior Developer");

        List<Employee> employees1 = new ArrayList<>();

        employees1.add(employee8);
        employees1.add(employee9);
        employees1.add(employee10);
        employees1.add(employee11);
        employees1.add(employee12);
        employees1.add(employee13);

        List<List<Employee>> allEmployee = new ArrayList<>();
        allEmployee.add(employees);
        allEmployee.add(employees1);

        return allEmployee;
    }
}
