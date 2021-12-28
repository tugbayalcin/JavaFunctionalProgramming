package lambda_stream_funcProg.linkedin.streams;

//import requiredClasses.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapInJava {

    //public interface Stream<T> extends BaseStream<T, Stream<T>> {
    //Stream interface'inin methodlarını kullanıyoruz

    //    default Stream<E> stream() {
    //        return StreamSupport.stream(spliterator(), false);
    //    }

    //Collection Interface'inin icinde bulunan Stream return type'lı method ile Stream icindeki methodları kullanırız
    public static void main(String[] args) {

        Integer[] intArray= new Integer[]{1,2,3,4,5,6,7,8,9,10};//böyle de initializing olur
        List<Integer> intList=new ArrayList<>(Arrays.asList(intArray));

        List<Integer> doubledList=new ArrayList<>();
        for(Integer i : intList) {
            int result=i*2;
            doubledList.add(result);
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println(intList);
        System.out.println(doubledList);
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        //[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

        Function<Integer,Integer> timesTwo= (x) -> x*2;
        List<Integer> doubledList2=intList.stream().map(timesTwo).collect(Collectors.toList());
        System.out.println(doubledList2);
        //[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]

        System.out.println(intList.stream().map((x) -> x*2).collect(Collectors.toList()));
        //[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]






    }
}
