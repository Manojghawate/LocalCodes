package com;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SteamAPIClass {

	public static void main(String[] args) {
		List<Integer>numbers = Arrays.asList(80,150,100,90);
		List<String>names = Arrays.asList("Sachin","Zaheer","Ajinkya","Sehwagh");
		List<Employee>empList = Arrays.asList(new Employee(2, "Sachin", 10000),new Employee(1, "Zaheer", 8000),new Employee(3, "Ajinkya", 9000));
		double total = numbers.stream().map(no -> no < 100 ? no : no*1.1).collect(Collectors.summarizingDouble(Double :: doubleValue)).getSum();
		int sum = numbers.stream().reduce(0, (n1,n2)->n1+n2);
//		System.out.println(sum);
//		System.out.println(total);
//		numbers.stream().sorted().forEach(n -> {System.out.print(n + " ");});
//		System.out.println();
//		numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
//		numbers.stream().sorted((n1,n2) -> n1-n2).forEach(System.out :: println);
//		numbers.stream().sorted(Comparator.comparingInt(Integer :: intValue).reversed()).forEach(System.out :: println);
		
		
//		names.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
//		Collections.sort(names,Collections.reverseOrder());
//		names.stream().sorted((name1,name2) ->name2.compareToIgnoreCase(name1)).forEach(System.out :: println);
//		names.stream().sorted(Comparator.comparing(String :: toString).reversed()).forEach(System.out :: println);
		
//		empList.stream().sorted().forEach(e-> {System.out.println(e.toString());});
//		Collections.sort(empList);
//		empList.forEach(e->{System.out.println(e.toString());});
		
//		Collections.sort(empList,new EmpIdComparator());
//		empList.forEach(e->{System.out.println(e.toString());});
		
		
//		empList.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
//		empList.stream().sorted(new EmpIdComparator()).forEach(System.out :: println);
//		empList.stream().sorted((e1,e2) -> e1.getSalary()-e2.getSalary()).forEach(System.out :: println);
//		empList.stream().sorted(Comparator.comparing(Employee :: getName).reversed()).forEach(System.out :: println);
//		Map<Integer, String>empMap = empList.stream().collect(Collectors.toMap(e->e.getId(), e->e.getName()));
//		Map<Integer, Employee>empMap = empList.stream().collect(Collectors.toMap(e->e.getId(), e->e));

//		int totalSal = empList.stream().mapToInt(Employee :: getSalary).sum();
		
//		long totalSala = empList.stream().map(Employee :: getSalary).collect(Collectors.summarizingInt(Integer :: intValue)).getSum();
//		System.out.println(totalSal);
		
//		double avg =  empList.stream().mapToInt(Employee :: getSalary).average().orElse(0);
//		avg = empList.stream().map(Employee :: getSalary).collect(Collectors.summarizingInt(Integer :: intValue)).getAverage();
//		System.out.println(avg);
		
//		System.out.println(empList.stream().count());
//		empList.stream().skip(2).forEach(System.out :: println);
//		empList.stream().limit(2).forEach(System.out :: println);
//		empList.stream().filter(e -> e.getName().equals("Sachin")).forEach(System.out :: println);
		
	
//		Employee emp  = empList.stream().filter(e -> e.getName().equals("Sachin")).findAny().orElse(null);
//		Employee emp1  = empList.stream().filter(e -> e.getName().equals("Sachin")).findFirst().orElse(null);
//
//		System.out.println(empList.stream().allMatch(e -> e.getName().equals("Sachin")));
//		System.out.println(empList.stream().anyMatch(e -> e.getName().equals("Sachin")));
		
//		String concat = empList.stream().reduce("",(e1, e2)->e1.getName()+" >>" + e2.getName());
//		System.out.println(concat);
//		String concat = names.stream().reduce("",(n1, n2)->n1+" >>" + n2);
//		System.out.println(concat);
		
//		String longestString = names.stream().reduce((n1, n2)-> n1.length() > n2.length() ? n1 : n2).orElse(null);
//		System.out.println(longestString);
		
//		Employee longestString = empList.stream().reduce((n1, n2)-> n1.getName().length() > n2.getName().length() ? n1 : n2).orElse(null);
//		System.out.println(longestString);
		
//		names.stream().distinct().forEach(System.out :: println);
//		List<List<String>> listOfLists = Arrays.asList(
//			    Arrays.asList("A", "B"),
//			    Arrays.asList("C", "D"),
//			    Arrays.asList("E", "F")
//			);
//		List<String> flattenedList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
//		System.out.println(flattenedList);

		
		Map<String, Integer>empMap = empList.stream().collect(Collectors.toMap(e->e.getName(), e->e.getSalary()));
		empMap.entrySet().stream().sorted((e1,e2)->e2.getValue() - e1.getValue()).skip(1).limit(1).forEach(System.out :: println);
		
		LinkedHashMap<String, Integer>sortedMap = empMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (oldValue, newValue) -> oldValue,LinkedHashMap :: new));
		//sortedMap.forEach((key,value)-> System.out.println(key + " -> " + value));
		
//        LinkedHashMap<String, Integer> sortedByValue = empMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue()) // Sort by value
//                .collect(Collectors.toMap(
//                    Map.Entry::getKey,
//                    Map.Entry::getValue,
//                    LinkedHashMap::new // This ensures the sorted order is maintained
//                ));
        
        Map<String, Integer> sorted = empMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // Sort by value
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue
                ));
        
       // sorted.forEach((key,value)-> System.out.println(key + " -> " + value));

        LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>();
        empMap.entrySet()
              .stream()
              .sorted(Map.Entry.comparingByValue())
              .forEach(e->{sortedByValue.put(e.getKey(), e.getValue());});
       // sortedByValue.entrySet().forEach(e-> {System.out.println(e.getKey() + " -> " + e.getValue());});
        
      Map<String, Integer>ihm = new IdentityHashMap<String, Integer>();
      Map<String, Integer>hm = new HashMap<String, Integer>();
      String key1 = new String("Key");
      String key2 = new String("Key");
      ihm.put(key1, 1);
      ihm.put(key2, 2);
      hm.put(key1, 1);
      hm.put(key2, 2);
      ihm.forEach((k,v)-> System.out.println("key "+ k + " value "+ v));
      hm.forEach((k,v)-> System.out.println("key "+ k + " value "+ v));
      
		
	}
	
}
class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int salary;
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Employee o) {
		return this.getName().compareTo(o.getName());
	}
}
class EmpIdComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId() -o2.getId();
	}
	
}
