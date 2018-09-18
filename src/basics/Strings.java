package basics;

public class Strings {
    public static void main(String[] args) {
        printMessage("Alex");
        System.out.println("Rectangle square = " + calcRectangleSquare(5,10));
        System.out.println("square = " + calcSquare(5));
        System.out.println("Sum of squares = " + calcRectangleSquare(5,10) + calcSquare(10));


        String string1 = "I like black coffee";
        String string3 = "I like coffee!!!";
        String string4 = new String("I like coffee");

        System.out.println(string1.toUpperCase());
        System.out.println(string1.toLowerCase());

        System.out.println(string3.substring(0,13));
        String string2 = "I like coffee";

        boolean b = string2.equals(string4);
        System.out.println(b);

        boolean like = string1.endsWith("fee!!!");

        System.out.println(like);
        System.out.println(string3.indexOf("abc"));

        System.out.println(string1.replace("black","white"));

        System.out.println(string3.indexOf("!!!"));
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

