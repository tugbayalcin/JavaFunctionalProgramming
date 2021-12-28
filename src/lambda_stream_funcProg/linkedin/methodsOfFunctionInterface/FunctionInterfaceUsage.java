package lambda_stream_funcProg.linkedin.methodsOfFunctionInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionInterfaceUsage {

    //The Function Interface is a part of the java.util.function package which has been introduced since Java 8,
    // to implement functional programming in Java.
    // It represents a function which takes in one argument and produces a result.

    //Hence this functional interface which takes in 2 generics namely:-
    //T: denotes the type of the input argument
    //R: denotes the return type of the function

    //The lambda expression assigned to an object of Function type is used to define its apply()
    // which eventually applies the given function on the argument.
    public static void main(String[] args) {

       // 1. apply()
        //This method applies the given function on its only argument.

        // Function which takes in a number
        // and returns half of it
        Function<Integer, Double> half = (a) -> a / 2.0;//apply(R r) overrided

        // apply the function to get the result
        System.out.println(half.apply(10));//5.0

        System.out.println("------------------------------------------------------");



        //2. andThen()
        //It returns a composed function wherein the parameterized function will be executed after the first one.
        // If evaluation of either function throws an error,
        // it is relayed to the caller of the composed function.



        // Function which takes in a number and
        // returns half of it

        Function<String, Integer> function = (t)-> t.length();//overriding apply(R r)
        Function<Integer, Integer> function2 = (number)-> number*2;//overriding apply(R r)

        Integer integer=function.andThen(function2).apply("emre");
        System.out.println(integer);//8



        System.out.println("------------------------------------------------------");




        Function<Integer, Double> half22 = a -> a / 2.0;//overriding apply(R r)
        System.out.println(half22.andThen(a -> 3 * a).apply(10));//15.0


        System.out.println("------------------------------------------------------");



        // Function which takes in a number and
        // returns half of it

        Function<Integer, Double> half3 = a -> a / 2.0;

        try {
            // try to pass null as parameter
            half3 = half3.andThen(null);
        }
        catch (Exception e) {
            System.out.println("Exception thrown "
                    + "while passing null: " + e);
        }


        System.out.println("------------------------------------------------------");


        //structured programming
        List<String> list= Arrays.asList("java","C++","pyhton","javaScript");
        Map<String,Integer> map=convertListToMap(list, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println(map);


        //functional programming
        Map<String,Integer> map2=convertListToMap(list,(x)->x.length());
        System.out.println(map2);


        System.out.println("------------------------------------------------------");


    }

    private static <T,R> Map<T,R> convertListToMap(List<T> list, Function<T,R> function){
        Map<T,R> result = new HashMap<>();
        for (T t : list){
            result.put(t,function.apply(t));
        }
        return result;
    }
}
