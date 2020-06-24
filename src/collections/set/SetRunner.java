package collections.set;

import java.util.*;

public class SetRunner {

    public static void main(String[] args) {

//        String[] cars = {"Mini", "Mercedes-Benz", "Audi", "VW", "Smart", "Toyota", "Porsche"};
//        String[] otherCars = {"Audi", "Ford", "GMC", "Toyota", "Chevrolet"};
//
//        Set<String> carSet = new TreeSet<>(Arrays.asList(cars));
//
//        Set<String> otherCarSet = new TreeSet<>(Arrays.asList(otherCars));
//
//        Set<String> uniqueCars = new TreeSet<>(carSet);
//        uniqueCars.addAll(otherCarSet);
//
//        print(uniqueCars);

        Set<Car> sixCars = new HashSet<>();
        sixCars.add(new Car("VW", "Golf", 45));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VW", "Polo", 35));
        sixCars.add(new Car("BMW", "Z4", 120));
        sixCars.add(new Car("BMW", "404i", 200));

        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota", "Auris", 40));
        europaCars.add(new Car("Reno", "Clio", 30));
        europaCars.add(new Car("Reno", "Megan", 50));
        europaCars.add(new Car("VW", "Golf", 45));
        europaCars.add(new Car("VW", "Polo", 35));

        NavigableSet<Car> uniqCars = new TreeSet<>(sixCars);
        uniqCars.addAll(europaCars);
//
//        print(uniqCars);
//        System.out.println();
//
//        sixCars.removeAll(europaCars);
//        print(sixCars);
//        System.out.println();
//
//        europaCars.removeAll(sixCars);
//        print(europaCars);

//        sixCars.retainAll(europaCars);
//        uniqCars.removeAll(sixCars);

        SortedSet<Car> cars = uniqCars.subSet(new Car("Toyota", "Auris", 40), true, new Car("Audi", "A3", 60), true);


        print(uniqCars);

        System.out.println("Higher");
        System.out.println(uniqCars.higher(new Car("Toyota", "Auris", 40)));

        System.out.println();
        System.out.println("Lower");
        System.out.println(uniqCars.lower(new Car("Toyota", "Auris", 40)));
    }

    private static void print(Set<Car> cars) {
        System.out.printf("%-20s %-20s %-20s \n", "Car brand", "Model", "Price per day");

        for (Car car : cars) {
            System.out.printf("%-20s %-20s %-20s \n", car.getCarBrand(), car.getModel(), car.getPricePerDay());
        }
    }
}
