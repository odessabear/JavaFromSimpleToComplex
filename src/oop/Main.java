package oop;

public class Main {
    public static void main(String[] args) {

        System.out.println("Dog's count "+ Dog.getDogsCount());

        Dog lab = new Dog();
        lab.setPaws(4);
        lab.setTale(1);
        lab.setName("Charley");
        lab.setBreed("Labrador");
        lab.setSize("Average");
        lab.bark();


        Dog sheppard = new Dog();
        sheppard.setPaws(4);
        sheppard.setTale(1);
        sheppard.setName("Mike");
        sheppard.setBreed("Sheppard");
        sheppard.setSize("Big");
        sheppard.bark();

        Dog doberman = new Dog();
        doberman.setPaws(4);
        doberman.setTale(1);
        doberman.setBreed("Doberman");
        doberman.setName("Jack");
        doberman.bite();


    }
}
