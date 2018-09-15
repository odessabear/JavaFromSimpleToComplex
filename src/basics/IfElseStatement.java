package basics;

public class IfElseStatement {
    public static void main(String[] args) {

        int testScore = 75;
        System.out.println("You've got ");

        if (testScore >= 90) {
            System.out.println("an excellent ");
        } else if (testScore >= 75) {
            System.out.println("a good ");
        }else if (testScore >= 60){
            System.out.println("a satisfactory ");
        }

        System.out.println("mark ");
    }
}
