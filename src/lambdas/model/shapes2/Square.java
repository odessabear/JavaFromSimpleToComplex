package lambdas.model.shapes2;

public class Square implements Shape{

    public Square(){
        System.out.println("Creating Square!!!");
    }

    @Override
    public double calcSquare() {
        return 16.0;
    }
}
