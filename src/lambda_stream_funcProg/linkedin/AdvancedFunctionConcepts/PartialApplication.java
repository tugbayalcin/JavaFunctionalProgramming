package lambda_stream_funcProg.linkedin.AdvancedFunctionConcepts;


import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplication {
    public static void main(String[] args) {

        //x+(y,z)
        TriFunction<Integer,Integer,Integer,Integer> add= (x,y,z)-> x+y+z;

        //(func) ->return (function)-> return integer
        Function<Integer, BiFunction<Integer,Integer,Integer>> addPartial=(x)->(y,z)->add.apply(x,y,z);
        //(x) function'ı baska bir function return, o da (x,y) 2 argumanlı integer return eden bir functionfunction

        BiFunction<Integer,Integer,Integer> add5= addPartial.apply(5);

        System.out.println(add5.apply(6,7));

        //en kısa yolu
        System.out.println(addPartial.apply(5).apply(6,7));




//(y+z)+(x)
        BiFunction<Integer,Integer, Function<Integer,Integer>> addPartial2=(x,y)->(z)->add.apply(x,y,z);
        Function<Integer,Integer> add5and6=addPartial2.apply(5,6);
        System.out.println(add5and6.apply(7));

        System.out.println(addPartial2.apply(5,6).apply(7));//18



        //(x)+(y)+(z)
        TriFunction<Integer,Integer,Integer,Integer> add2= (x,y,z)-> x+y+z;

        Function<Integer,Function<Integer,Function<Integer,Integer>>> add3Pieces=(x)->(y)->(z)->add2.apply(x,y,z);
        Function<Integer,Function<Integer,Integer>> firstOne=add3Pieces.apply(5);
        Function<Integer,Integer> secondOne= firstOne.apply(6);
        System.out.println(secondOne.apply(7));//18

        System.out.println(add3Pieces.apply(5).apply(6).apply(7));//18


    }
}

@FunctionalInterface
interface TriFunction<T,U,V,R>{
    R apply(T t,U u,V v);
}
