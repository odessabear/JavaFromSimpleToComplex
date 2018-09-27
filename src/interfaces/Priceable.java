package interfaces;

public interface Priceable extends Deliverable, Orderable {

    default int calccPrice() {
        return calcOrderPrice() + calcDeliveryPrice();
    }

}
