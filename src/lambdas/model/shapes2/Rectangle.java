package lambdas.model.shapes2;

public class Rectangle implements Shape {

    public Rectangle(){
        System.out.println("Rectangle Creating!!!");
    }

    @Override
    public double calcSquare() {
        return 23.00;
    }
}
