package lambda_stream_funcProg.techproed;

import java.util.Arrays;
import java.util.List;

public class Lambda04 {
    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,7);

        //Print the cubes(a*a*a) of all even elements by using "Functional Programming"
        list.
            stream().
            distinct()
            .filter(Lambda04::isEven)
            .map(t->(int)Math.pow(t,3))
            .forEach(t->System.out.print(t + " "));//8 64 216

    }




    private static boolean isEven(int num) {
        return num%2==0;
    }
}
