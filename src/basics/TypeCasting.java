package basics;

public class TypeCasting {
    public static void main(String[] args) {
        byte b = 10;
        short c = 200;
        int a = b + 60000;
        long myLongValue = 123_456_789_876_543_211_2L;
        float myFloatValue = 23.56f;
        double myDoubleValue = 56.45d;

        double sum = a + b + c + myLongValue + myDoubleValue + myFloatValue;
//        System.out.println("b = " + b);
//        System.out.println("c = " + c);
//        System.out.println("a = " + a);
//        System.out.println("ma Long Value is " + myLongValue);
//        System.out.println(sum);


        short someShort = b;
        int someint = someShort;
        someShort = (short) someint;

        System.out.println(myLongValue);
        someint = (int) myLongValue;
        System.out.println(someint);

        double someDouble = myFloatValue;
        System.out.println(someDouble);

        double someIntToDouble = someint;
        System.out.println(someIntToDouble);

        double someLongToDouble = myLongValue;
        System.out.println(someLongToDouble);
    }
}
