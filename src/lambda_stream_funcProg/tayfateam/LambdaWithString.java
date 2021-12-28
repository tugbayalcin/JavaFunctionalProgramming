package lambda_stream_funcProg.tayfateam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaWithString {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("Alberto");
        list.add("Tucker");
        list.add("Christ");

        System.out.println(list);
        //[Ali, Mark, Jackson, Amanda, Mariano, Alberto, Tucker, Christ]

        //System.out.println(getRemainingEl(list));
        //[Ali, Mark]

        getSortedLenghtUpper(list);
        //ALI
        //MARK
        //AMANDA
        //TUCKER

        //CHRIST
        //JACKSON
        //MARIANO
        //ALBERTO

        System.out.println(checkLenght(list));
    }

    //Use “Functional Programming”
    //1)Create a method to remove the list elements whose lengths are less than 5.

    public static List<String> getRemainingEl(List<String>list){
        //removeIf() does not return immutable list
        list.removeIf(t->t.length()>5);
        return list;
    }

    /*
    Use “Functional Programming”
	2)Create a method to print the elements in uppercases after ordering according to their lengths
     */
    public static void getSortedLenghtUpper(List<String>list){
        //removeIf() does not return immutable list
        list.
            stream().
            map(String::toUpperCase).
            sorted(Comparator.comparing(t->t.length())).
                forEach(System.out::println);
    }

    //Use “Functional Programming”
    //3)Create a method to check if the lengths of all elements are less than 8
    public static boolean checkLenght(List<String>list){
        //removeIf() does not return immutable list
        return list.
                stream().
                allMatch(t->t.length()<8);
    }
}
