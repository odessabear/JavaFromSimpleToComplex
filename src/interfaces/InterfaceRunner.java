package interfaces;

public class InterfaceRunner {
    public static void main(String[] args) {

        Priceable pizza = new Pizza("Neapolitano", 1, 20, Size.L);
        Priceable phone = new CellPhone("Motorola", "XT1573", 1, 250);
        Priceable fridge = new Fridge("LG", "E9090", 1, 300);

        printDeliveryPrice(phone);
        System.out.println();
        printDeliveryPrice(pizza);
        System.out.println();
        printDeliveryPrice(fridge);
    }

    private static void printDeliveryPrice(Priceable del) {
        System.out.println("Delivery price is " + del.calcDeliveryPrice());
        System.out.println("Delivery price is " + del.calcOrderPrice());
        System.out.println("Summary price is " + del.calccPrice());
    }
}
