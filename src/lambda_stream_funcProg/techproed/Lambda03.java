package lambda_stream_funcProg.techproed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> list =new ArrayList<>(Arrays.asList("Ali","Mark","Jackson","Amanda","Ali","Mark"));

        list.
            stream().
            distinct().
            sorted().//alfabetik sırala
            forEach(System.out::println);
        //Ali
        //Amanda
        //Jackson
        //Mark

        list.
            stream().
            distinct().
            sorted(Comparator.comparing(t -> t.length())).//uzunluğuna göre sırala
            forEach(System.out::println);
        //Ali
        //Mark
        //Amanda
        //Jackson

        list.
            stream().
            distinct().
            sorted(Comparator.comparing(t -> t.substring(t.length()-1))).//son harfine göre sırala
            forEach(System.out::println);
        //Amanda
        //Ali
        //Mark
        //Jackson

        list.
            stream().
            distinct().
            sorted(Comparator.reverseOrder()).
            forEach(System.out::println);
        //Mark
        //Jackson
        //Amanda
        //Ali

        //Print distinct elements whose length is less than 7 with upper cases on the console, in reverse order.
        list.stream()
                .distinct()//her eleman 1 kez
                .filter(t->t.length()<7)//7 char'dan kısa olanlar
                .map(String::toUpperCase)//uppercase yap
                .sorted(Comparator.reverseOrder())//reverse order yap
                .forEach(t->System.out.println(t + " "));//print out
        ///MARK
        //AMANDA
        //ALI


        //Another way to see distinct elements on the console
        //Note: If you want to see the elements as sorted do not use ==> collect(Collectors.toSet()))
        System.out.println(list.stream()
                .filter(t->t.length()<7)
                .map(t->t.toUpperCase())
                .collect(Collectors.toSet()));
        //[AMANDA, ALI, MARK]


        //Print the number of characters of every element on the console by using "Functional Programming"
        list.stream()
                .map(t->t + " = " + t.length())
                .forEach(System.out::println);
        //Ali = 3
        //Mark = 4
        //Jackson = 7
        //Amanda = 6
        //Ali = 3
        //Mark = 4


        /*
		 1)Add "!" to the end of every element
		 2)Find the total number of characters which contain "k"
		 3)Use "Functional Programming"
		*/

        int result = list.
                stream()
                .map(t->t + "!")//Mark! Jackson! Mark!
                .filter(t->t.contains("k"))
                .map(t->t.length())
                .reduce(0, (t,u)->t+u);
        System.out.println(result);//18


        /*
		 Print the minimum value of the lengths of the elements
		*/
        int result3 = list
                .stream()
                .map(t->t.length())
                .reduce(Integer.MAX_VALUE, (t,u) -> t<u ? t : u);//EN KISAYI T YAP
        System.out.println(result3);//3

		/*
		 Print the maximum value of the lengths of the elements
		*/
        int result4 = list.stream()
                .map(t->t.length())
                .reduce(Integer.MIN_VALUE, (t,u) -> t>u ? t : u);//EN UZUNU T YAP
        System.out.println(result4);//7

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        //-2147483648
        //2147483647



    }
}
