package interfaces;

public class InterfaceRunner {
    public static void main(String[] args) {

        Deliverable pizza = new Pizza("Neapolitano", 1, 20, Size.L);
        Deliverable phone = new CellPhone("Motorola", "XT1573", 1, 250);
        Deliverable fridge = new Fridge("LG", "E9090", 1, 300);

        printDeliveryPrice(phone);
        printDeliveryPrice(pizza);
        printDeliveryPrice(fridge);
    }

    private static void printDeliveryPrice(Deliverable del) {
        System.out.println("Delivery price is " + del.calcDeliveryPrice());
    }
}
