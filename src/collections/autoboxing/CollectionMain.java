package collections.autoboxing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {



        String[] colors = {"yellow","green","blue"};

        LinkedList<String> list1 = new LinkedList<String>(Arrays.asList(colors));
        list1.add("black");

        colors = list1.toArray(new String[list1.size()]);

        for (int i = 0;i<colors.length;i++){
            System.out.println(colors[i]);
        }
    }
}
