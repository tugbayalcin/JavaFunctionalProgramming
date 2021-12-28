package lambda_stream_funcProg.linkedin.firstClassFunctions;

import java.util.function.Function;

public class FunctionInterface01 {
    public static void main(String[] args)
    {
        //1. structured programming
        Function<Integer,Double> myTrile00= new Function<Integer, Double>() {
            @Override
            public Double apply(Integer integer) {
                return (double)integer*3;
            }
        };

        // 2.functional programming
        Function<Integer,Double> myTriple0 = (Integer x) -> Double.valueOf(x*3);//className.methodName(Integer i); return double
        Function<Integer,Double> myTriple01 = (x) -> (double) (x * 3);//className.methodName(Integer i); return double
        Function<Integer,Double> myTriple02 = x -> (double) (x * 3);//className.methodName(Integer i); return double

        //3. functional programming- overriding apply(R r) by another method
        Function<Integer,Double> myTriple = MyMath::triple;//className.methodName(Integer i); return double
        Double result= myTriple.apply(5);

        System.out.println(result);//15.0
        //input:Integer , output:Double

        Function<Integer,Double> myTriple2=new MyMath2()::triple2;//objectName.methodName();
        myTriple2.apply(5);//15

    }

    public static class MyMath{
        public static Double triple(Integer x){
            return (double)x*3;
        }
    }
}

class MyMath2{
    public Double triple2(Integer x){
        return (double)x*3;
    }
}