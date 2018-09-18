package basics;

public class Methods {
    public static void main(String[] args) {
        printMessage("John");
        int a = 5;
        int b = 10;
        int square1 = calcSquare(b);
        int square = calcRectangleSquare(a, b);
        System.out.println("square is " + square);
        System.out.println("square1 is " + square1);
        int sum = square+square1;
        System.out.println("Sum of squares is " + sum);

    }

    public static void printMessage(String name) {
        System.out.println("Hello " + name + " !");
    }

    public static int calcRectangleSquare(int x, int y) {
        int square = x * y;
        return square;
    }

    public static int calcSquare(int x) {
        return x * x;
    }
}
