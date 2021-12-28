package lambda_stream_funcProg.linkedin.AdvancedFunctionConcepts;


import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class Recursion {

    static Function<Integer, Integer> factorial;
    static {
        factorial = x -> x == 1
                ? x
                : x * factorial.apply(x - 1);
    }
    {
        System.out.println(factorial.apply(5));
    }

    public static void main(String[] args) {

        int sum=sum(10);
        System.out.println(sum);//55

        countDown(10);//10-0
        //10
        //9
        //8
        //7
        //6
        //5
        //4
        //3
        //2
        //1
        //0
        //Done!

        countUp(0);//0-10
        countUp2(5,20);//5-10


//    R apply(int value);
        IntFunction<Long> factorialCalc = Recursion::factorial;//int argumanı alıp herhangi bir data type retrun eden method konablir
        System.out.println(factorialCalc.apply(10));//10





    }

    public static int sum(int k) {//recursion
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    public static void countDown(Integer x){

        if(x<0){
            System.out.println("Done!");
            return;
        }
        System.out.println(x);
        countDown(x-1);

    }

    public static void countUp(Integer x){
        if(x>10){
            System.out.println("Done");
            return;
        }
        System.out.println(x);
        countUp(x+1);

    }

    public static void countUp2(Integer start,Integer end){
        if(start>end){
            System.out.println("Done");
            return;
        }
        System.out.println(start);
        countUp2(start+1,end);

    }



    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


}
