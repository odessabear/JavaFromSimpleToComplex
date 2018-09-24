package inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
     Bus truck = new Bus("Mercedes","Sprinter",EngineType.DIESEL);

        System.out.println(truck.getProducer());
        System.out.println(truck.getModel());
    }
}
