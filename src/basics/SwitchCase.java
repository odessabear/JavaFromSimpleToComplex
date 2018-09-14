package basics;

public class SwitchCase {
    public static void main(String[] args) {
        int choice = 5;
        String dayOfTheWeek = "Monday";

        switch (dayOfTheWeek) {
            case "Monday":
                System.out.println("this is a first working day");
                break;
            case "Tuesday":
                System.out.println("this is a second working day");
                break;
            case "Wednesday":
                System.out.println("this is a third working day");
                break;
            case "Thursday":
                System.out.println("this is a fourth working day");
                break;
            case "Friday":
                System.out.println("this is a fifth working day");
                break;
            case "Saturday":
                System.out.println("Finally weekend");
                break;
            case "Sunday":
                System.out.println("Finally weekend");
                break;
            default:
                System.out.println("Not a day of the week");

        }
        System.out.println("Final");
    }
}
