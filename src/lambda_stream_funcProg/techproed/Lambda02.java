package lambda_stream_funcProg.techproed;

import java.util.Arrays;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,1,2,2,3,4,5,6,7,8,9,10);
        System.out.println(list);//[1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        //even numbers with küpleriyle
        list.
            stream().
            filter(t -> t%2==0).
            map(t -> (int)Math.pow(t,3)).
            forEach(System.out::println);


        //add all elements - reduce()
        System.out.println(list.stream().reduce(0,(t,u) -> t+u ));//58
        int sum = list.stream().reduce(0, Integer::sum);//58
        System.out.println(sum);

        //multiply all odd numbers
        System.out.println(
                list.
                    stream().
                    filter(t -> t%2==1).
                    reduce(1,(t,u) -> t*u)//945
        );

        int result=list.stream().filter(t -> t%3==0).reduce(0,(t,u) -> t+(u+2));
        System.out.println(result);//24

        System.out.println(
                list.stream().filter(t -> t%3==0).map(t -> t+2).reduce(0, Integer::sum)
        );//24


        //distinct()
        //write all elements (once repeated ones)
        list.stream().distinct().forEach(System.out::println);




        result = list.
                 stream().
                 distinct()
                .filter(t->list.indexOf(t)>1)//listede 2. 3. 4. ... sırada olanların
                .map(t->t*t)//karelerının
                .reduce(0, (t,u)->t+u);//toplamı

        System.out.println(result);


        System.out.println("======================================");

        //We cannot use arrays in Lambda, but if you want to use arrays in Lambda convert it to a list the you can use
        //But for a list which is converted from an array, some methods will be disabled.
        int a[] = {12, 9, 13, 5, 8};
        List<int[]> al = Arrays.asList(a);
        al.stream()
                .sorted()
                .forEach(t -> System.out.print(Arrays.toString(t) + " "));



    }
}
