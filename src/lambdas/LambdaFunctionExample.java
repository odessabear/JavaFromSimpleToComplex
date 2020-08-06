package lambdas;

import lambdas.model.Employee;
import lambdas.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

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
        System.out.println(findMatch(people, e -> e.getAge() > 30));

        //Function
        System.out.println("Total salary - " + calcSum(employees, Employee::getSalary));
        System.out.println("Total age - " + calcSum(people, Person::getAge));

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
}
