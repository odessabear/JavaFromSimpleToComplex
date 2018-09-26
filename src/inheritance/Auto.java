package inheritance;

public abstract class Auto {
    private String producer;
    private String model;
    private Engine engine;
    private int currentSpeed;
    protected boolean isRunning;

    public Auto(String producer, String model, Engine engine) {
        this.producer = producer;
        this.model = model;
        this.engine = engine;
        System.out.println("Auto was initialised");
    }

    public abstract void energize();

    public static void doSomething(){}

    public  void start(){
        isRunning = true;
        currentSpeed = 0;
        System.out.println("Auto is starting");
    }

    public void stop(){
        System.out.println("Auto is stopped");
    }

    public void accelerate(int kmPerHour){
        currentSpeed += kmPerHour;
        System.out.println("Accelerating.Current speed is " + currentSpeed + " kmPerHour");
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngineType() {
        return engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
