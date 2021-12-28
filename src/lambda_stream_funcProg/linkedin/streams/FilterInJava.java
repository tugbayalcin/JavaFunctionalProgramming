package lambda_stream_funcProg.linkedin.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterInJava
{
    public static void main(String[] args) {

        List<Integer> intList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //produceral way
        List<Integer> evens=new ArrayList<>();
        for(Integer i : intList) {
            Boolean isEven=i%2==0;
            if(isEven)
                 evens.add(i);
        }

        System.out.println(evens);
        //[2, 4, 6, 8, 10]


        //Represents a predicate (boolean-valued function) of one argument.
        Predicate<Integer> isEven = (x) -> x%2==0;//test(R r) methodu override  ediliyor
        List<Integer> evens2= intList.stream().filter(isEven).collect(Collectors.toList());
        System.out.println(evens2);
        //[2, 4, 6, 8, 10]

        System.out.println(intList.stream().filter((x) -> x%2==0).collect(Collectors.toList()));
        //[2, 4, 6, 8, 10]




        List<String> stringList=Arrays.asList("functional","programming","is","so","cool","!");

        Predicate<String> isLongerThan5=(x) -> x.length()>5;
        List<String> stringList2=stringList.stream().filter(isLongerThan5).collect(Collectors.toList());
        System.out.println(stringList2);
        //[functional, programming]


        Function<Integer,Predicate<String>> createLenghtTest=(minLenght) -> {//apply(R r) override edildi
            return (str) -> str.length()>minLenght;//Predicate Int'deki method override edildi
        };

        Predicate<String> isLongerThan3=createLenghtTest.apply(3);
        Predicate<String> isLongerThan10=createLenghtTest.apply(10);

        List<String> strList=stringList.stream().filter(isLongerThan3).collect(Collectors.toList());
        System.out.println(strList);
        //[functional, programming, cool]

        System.out.println(stringList.stream().filter(isLongerThan10).collect(Collectors.toList()));
        //[programming]
    }
}
