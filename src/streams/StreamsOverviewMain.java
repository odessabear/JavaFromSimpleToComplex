package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOverviewMain {

    private static List<Employee> employeeList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;
    private static List<Employee> secondList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        employeeList.add(new Employee(1, "Alex", "Black", 50000, "IT"));
        employeeList.add(new Employee(2, "John", "Green", 75000, "IT"));
        employeeList.add(new Employee(6, "Sam", "Brown", 80000, "IT"));
        employeeList.add(new Employee(9, "Tony", "Grey", 90000, "IT"));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60000, "IT"));
        employeeList.add(new Employee(11, "Viktoria", "Pink", 75000, "IT"));
        employeeList.add(new Employee(16, "Sean", "Magenta", 80000, "Finance"));
        employeeList.add(new Employee(19, "Kate", "Black", 80000, "Finance"));
        employeeList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60000, "IT"));
        employeeList.add(new Employee(11, "Viktoria", "Pink", 75000, "Finance"));


        secondList.add(new Employee(1, "Alex", "Black", 50000, "Finance"));
        secondList.add(new Employee(2, "John", "Green", 75000, "Finance"));
        secondList.add(new Employee(6, "Sam", "Brown", 80000, "IT"));
        secondList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        secondList.add(new Employee(10, "Mike", "Yellow", 60000, "Finance"));
        secondList.add(new Employee(11, "Viktoria", "Pink", 75000, "IT"));
        secondList.add(new Employee(16, "Sean", "Magenta", 80000, "IT"));
        secondList.add(new Employee(19, "Kate", "Black", 80000, "IT"));
        secondList.add(new Employee(9, "Tony", "Grey", 90000, "Finance"));
        secondList.add(new Employee(10, "Mike", "Yellow", 60000, "Finance"));
        secondList.add(new Employee(11, "Viktoria", "Pink", 75000, "Finance"));

        //testStreamFromList();
        //testStreamFromFile();

        //  testSortAndReduce();

    }

    private static void testSortAndReduce() {
        Employee maxIdEmployee = employeeList.stream()
                .max((e1, e2) -> e1.getId() - e2.getId())
                .get();

        Employee minSalaryEmployee = employeeList.stream()
                .min(StreamsOverviewMain::compare)
                .get();

        employeeList.stream()
                .sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();
        System.out.println("maxIdEmployee is " + maxIdEmployee);
        System.out.println();
        System.out.println("minSalaryEmployee is " + minSalaryEmployee);
        System.out.println();


        Employee identity = new Employee(0, "", "", 0, "");
        Employee reduceEmployee = employeeList.stream()
                .reduce(identity, (e1, e2) -> {
                    e1.setId(e1.getId() + e2.getId());
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    return e1;
                });

        System.out.println("reduceEmployee is " + reduceEmployee);
    }

    private static void testStreamFromList() {
//        employeeList.stream().filter(e -> e.getSalary() > 60000)
//                .filter(e -> e.getId() < 10)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//
//        Stream.of(ids)
//                .map(StreamsOverviewMain::findById)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        Optional<Employee> element = Stream.of(ids)
//                .map(StreamsOverviewMain::findById)
//                .filter(Objects::nonNull)
//                .findFirst();

        Random random = new Random();

        Integer integer = Stream.of(ids)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                //       .limit(1)
                .skip(2)
                .findFirst()
                .orElseGet(() -> random.nextInt());
        System.out.println(integer);

        List<List<Employee>> departments = new ArrayList<>();
        departments.add(employeeList);
        departments.add(secondList);

        //     departments.stream().flatMap(l -> l.stream().map(e -> e.getFirstName())).forEach(System.out::println);

    }

    private static void testStreamFromFile() throws IOException {
        Files.lines(Paths.get("words.txt"))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                //            .distinct()
                //           .sorted()
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::println);
    }

    private static Employee findById(int id) {
        if (employeeMap == null) {
            employeeMap = employeeList.stream().distinct().collect(Collectors.toMap(Employee::getId, e -> e));
        }
        return employeeMap.get(id);
    }

    private static int compare(Employee e1, Employee e2) {
        return e1.getSalary() - e2.getSalary();
    }
}
