package oop;

public class Dog {

    private static int dogsCount;

    private int paws = 4;
    private int tale = 1;
    private String name;
    private String breed;
    private String size;

    public Dog(){
        dogsCount++;
        System.out.println("Dog's count is " + dogsCount);
    }

    public static int getDogsCount(){
        return dogsCount;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size.equalsIgnoreCase("big")||
                size.equalsIgnoreCase("average")||
                size.equalsIgnoreCase("small")) {
            this.size = size;
        }else
            System.out.println("Size should be one of these : Big , Average or Small!");
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPaws(int paws){
        if (paws == 4) {
            this.paws = paws;
        }else {
            System.out.println("User tried to assign " + paws + " paws for a dog");
            System.out.println("Correct number is 4!");
        }
    }

    public int getPaws(){
        return paws;
    }

    public int getTale() {

        return tale;
    }

    public void setTale(int tale) {
        if (tale == 1){
        this.tale = tale;}
        else {
            this.tale = 1;
            System.out.println("User tried to assign " + tale + " tails for dog");
            System.out.println("Correct number is 1 !!!");
        }
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark(){
        if (size.equalsIgnoreCase("Big")){
            System.out.println("woof-woof");
        }else if (size.equalsIgnoreCase("Average")){
            System.out.println("raf-raf");
        }else {
            System.out.println("tiaf-tiaf");
        }

    }

    public void bite(){
        if (dogsCount>2){
            System.out.println("Dogs are biting you");
        }else bark();
    }
}
