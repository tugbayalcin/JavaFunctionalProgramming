package lambda_stream_funcProg.linkedin.firstClassFunctions;

import java.util.function.BiFunction;

public class BiFunctionInterface {
    public static void main(String[] args) {

        //1 of functional programming interface is BiFunction<T,U,R>
        //T,U arguments to execute
        // R means -> Return Type
        BiFunction<Integer,Integer,Integer> add=(x,y) -> x+y;
        System.out.println(add.apply(32,32));

    }
}
