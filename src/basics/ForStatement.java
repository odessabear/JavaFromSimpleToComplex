package basics;

public class ForStatement {
    public static void main(String[] args) {
        int factorialLimit = 10;
        int factorial = 1;
        for (int i = 1; i < factorialLimit; i++) {
            factorial *= i;
            System.out.println("Factorial = " + factorial);
        }
        System.out.println("Result is - " + factorial);

        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
