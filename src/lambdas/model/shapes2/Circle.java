package lambdas.model.shapes2;

public class Circle implements Shape, AnotherShape {

    public Circle() {
        System.out.println("Creating Circle!!!");
    }

    @Override
    public double calcSquare() {
        return 3.5;
    }

    @Override
    public double calcSomething() {
        return Shape.super.calcSomething();
    }
}
