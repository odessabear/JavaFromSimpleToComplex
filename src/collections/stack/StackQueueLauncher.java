package collections.stack;

import java.util.Stack;

public class StackQueueLauncher {

    public static void main(String[] args) {
        passengerProcessing();
    }

    private static void passengerProcessing() {
        Stack<Passenger> bus = new Stack<>();

        Passenger passenger = new Passenger("Katerina", "Ivanova");
        bus.push(new Passenger("Alex", "Vasko"));
        bus.push(new Passenger("Alex", "Mikhailov"));
        bus.push(new Passenger("Dmitriy", "Petrov"));
        bus.push(passenger);
        bus.push(new Passenger("Ivan", "Ivanov"));

        System.out.println("Last entered passenger is " + bus.peek());

        System.out.println("Position of passenger is " + bus.search(passenger));

        while (!bus.empty()){
            System.out.println("Passenger : " + bus.pop());
        }
    }

    private static class Passenger {

        private static int number = 1;
        private final int count = number++;
        private final String name;
        private final String surname;

        public Passenger(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public static int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passenger " + count + "  " + name + " " + surname;
        }
    }
}
