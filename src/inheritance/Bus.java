package inheritance;

public class Bus extends FuelAuto {
    private int passengerNumber;

    public Bus(String producer, String model, Engine engineType, int availablePatrol, int tankVolume, int passengerNumber) {
        super(producer, model, engineType, availablePatrol, tankVolume);
        this.passengerNumber = passengerNumber;
        System.out.println("Bus was initialized");
    }

    public void fuelUp() {
        int volume = getTankVolume() - getAvailablePatrol();
        fuelUp(volume);
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Bus is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(10);
        System.out.println("Bus has stopped");
    }

    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePatrol() + petrolVolume;
        if (volume>getTankVolume()){
            setAvailablePatrol(getAvailablePatrol());
        }
        System.out.println("Adding diesel");
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public void pickUpPassengers(int passengerNum) {
        this.passengerNumber += passengerNum;
        System.out.println("Picking up " + passengerNum + " pasengers");
    }

    public void releasePassengers() {
        if (isRunning) {
            stop();
        }
        passengerNumber = 0;
        System.out.println("Passengers released");
    }
}
