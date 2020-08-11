package lambdas;

import lambdas.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctionExample {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", "Black", 50000));
        employees.add(new Employee("John", "Green", 75000));
        employees.add(new Employee("Sam", "Brown", 80000));
        employees.add(new Employee("Tony", "Grey", 90000));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alex", "Smith", 25));
        people.add(new Person("John", "Green", 30));
        people.add(new Person("Sam", "Brown", 32));
        people.add(new Person("Tony", "Grey", 34));

        //Predicate
        System.out.println(findMatch(employees, e -> e.getSalary() > 80000));
        // the same method with reference method
        //System.out.println(findMatch(employees, LambdaFunctionExample::test));

        System.out.println(findMatch(people, e -> e.getAge() > 30));


        //Function
        System.out.println("Total salary - " + calcSum(employees, Employee::getSalary));
        // the same method with lambdas
        //System.out.println("Total salary - " + calcSum(employees, employee -> employee.getSalary()));

        System.out.println("Total age - " + calcSum(people, Person::getAge));

        BinaryOperator<Integer> combiner = (n1, n2) -> n1 + n2;
        // the same method with reference method
        // BinaryOperator<Integer> combiner = Integer::sum;

        Integer zeroElement = 0;
        System.out.println("Combine salaries : " + combine(employees, zeroElement, Employee::getSalary, combiner));

        //Consumer
        employees.forEach(e -> e.setSalary(e.getSalary() * 11 / 10));
        employees.forEach(System.out::println);

        //Supplier
        Supplier[] shapes = {Circle::new, Rectangle::new, Square::new};

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(3);
            Supplier supplier = shapes[index];
            supplier.get();
        }

    }

    private static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction) {
        for (T e : elements) {
            if (predicateFunction.test(e)) {
                return e;
            }
        }
        return null;
    }

    private static <T> int calcSum(List<T> elements, Function<T, Integer> function) {
        int sum = 0;
        for (T e :
                elements) {
            sum = sum + function.apply(e);
        }
        return sum;
    }

    private static <T, R> R combine(List<T> elements, R zeroElement, Function<T, R> function, BinaryOperator<R> combiner) {

        for (T e :
                elements) {
            zeroElement = combiner.apply(zeroElement, function.apply(e));
        }
        return zeroElement;
    }


}
