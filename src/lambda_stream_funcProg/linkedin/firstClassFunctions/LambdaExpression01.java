package lambda_stream_funcProg.linkedin.firstClassFunctions;

import java.util.function.Function;

public class LambdaExpression01 {
    public static void main(String[] args) {

        //1 of functional programming interfaces is Function<U,R>
        Function<Integer,Integer> myFunction = (Integer x) -> x*2;
        System.out.println(myFunction.apply(5));

        Function<Integer,Integer> myFunction2 = (x) -> x*2;
        System.out.println(myFunction2.apply(5));

        Function<Integer,Integer> myFunction3 = (x) -> {//apply(R r) method overriding
            if(x<0)
                return x;//artıysa eksi yap
            else
                return -x;
        };
        System.out.println(myFunction3.apply(5));//-5

        Function<Integer,Integer> myFunction4=(x) -> x<0 ? x : -x ;//lambda+ternary in apply(R r) body
        System.out.println(myFunction4.apply(5));//-5


    }
}
