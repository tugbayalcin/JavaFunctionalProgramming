package lambda_stream_funcProg.linkedin.firstClassFunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {
    public static void main(String[] args) {

        BiFunction<Float,Float,Float> divide =(x, y)-> x/y;

        Function<BiFunction<Float,Float,Float>, BiFunction<Float,Float,Float>> secondArgIsntZeroCheck=(func) -> (x,y)->
        {//func = BiFunction<Float,Float,Float> tipinde bir deger
            //(x,y) ise func veri tipinin icindeki apply(x,y) methodunu asagıda override da ediliyor
            if(y== 0f){
                System.out.println("Error: cant divided by 0");
                return 0f;
            }

            return func.apply(x,y);
            //    R apply(T t, U u);
        };

        BiFunction<Float,Float,Float> divideSafe= secondArgIsntZeroCheck.apply(divide);
        System.out.println(divideSafe.apply(10f,0f));
        System.out.println(divideSafe.apply(10f,2f));
        //Error: cant divided by 0
        //0.0
        //5.0


    }
}
