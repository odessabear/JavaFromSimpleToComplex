package inheritance;

public class InheritanceMain {
    public static void main(String[] args) {
        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);
        Engine busEngine = new Engine(3.0, EngineType.DIESEL, 150);

        Auto truck = new Truck("Volvo", "VNL 300", truckEngine, 300, 500, 1000);

        Auto electricCar = new ElectricCar("Tesla", "Model S", 4, 100500);

        Auto bus = new Bus("Mercedes", "Sprinter", busEngine, 30, 75, 12);

        Auto auto = new Auto("WV","POLO",busEngine);


        runCar(bus);
        runCar(truck);
        runCar(electricCar);
        runCar(auto);
    }

    private static void runCar(Auto auto) {
        auto.start();
        auto.stop();
        if (auto instanceof FuelAuto){
            FuelAuto fuelAuto = (FuelAuto) auto;
            fuelAuto.fuelUp(50);
        }
    }
}
