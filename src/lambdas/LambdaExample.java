package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number> {
    double process(T element);
}

@FunctionalInterface
interface ExecutiveFunction {
    void process();
}

public class LambdaExample {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.4);
        doubleList.add(8.6);
        doubleList.add(1.23);
        doubleList.add(4.13);
        doubleList.add(12.2);

        processElements(intList, x -> Math.sin(x.doubleValue()));
        processElements(doubleList, x -> Math.sin(x.doubleValue()));

        TimeUtil.measure(() -> Arrays.sort(createRandomArray()));

        String s = "Hello ";
        Double d = 0.123;

        TransformUtils<Double> doubleUtils = new TransformUtils<>();
        System.out.println(doubleUtils.transform(d, Math::sin));

        TransformUtils<String> stringTransformUtils = new TransformUtils<>();
        System.out.println(stringTransformUtils.transform(s, TransformUtils::exclaim));

        String suffix = "Alex";
        System.out.println(stringTransformUtils.transform(suffix, s::concat));

        System.out.println(stringTransformUtils.transform(s,String::toUpperCase));
        System.out.println(stringTransformUtils.transform(s,String::new));

        LambdaScopeTest scope = new LambdaScopeTest();
        LambdaScopeTest.LambdaScopeInner inner = scope.new LambdaScopeInner();
        inner.testsScope(9999.0000);
    }

    private static <T extends Number> void processElements(List<T> tList, ElementProcessor function) {
        List<Double> doubleList = new ArrayList<>();
        for (Number i : tList) {
            doubleList.add(function.process(i));
        }
        System.out.println(doubleList);
    }

    private static double multiply(int x, int y) {
        return x * y / 10.0;
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = r.nextInt(myArray.length);
        }
        return myArray;
    }

    public static class TimeUtil {
        private static void measure(ExecutiveFunction function) {
            long start = System.currentTimeMillis();
            function.process();
            long end = System.currentTimeMillis();
            System.out.println("Spent time : " + (end - start));
        }
    }
}
