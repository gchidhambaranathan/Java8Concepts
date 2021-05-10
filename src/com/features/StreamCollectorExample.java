package com.features;

import com.data.StreamData;
import com.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorExample {

    public static void main(String[] args) {
        List<Employee> employees = StreamData.prepareData();
        StreamCollectorExample collectorExample = new StreamCollectorExample();
        //aggregate list to map contains employees by occupation and join all keys comma seperated
        collectorExample.aggregateEmployeeByOccupation(employees);
    }

    private void aggregateEmployeeByOccupation(List<Employee> employees) {
        Map<String, List<Employee>> stringListMap = employees.stream().collect(Collectors.groupingBy(Employee::getOccupation));

        stringListMap.entrySet().forEach(
                entry -> System.out.println(entry.getKey() + " " + entry.getValue().size())
        );

        String occupations = stringListMap.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.joining(","));

        System.out.println(occupations);
    }
}
