package lambda_stream_funcProg.linkedin.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceInJava
{
    public static void main(String[] args) {

        List<Integer> intList=Arrays.asList(1,2,3,4,5,6,7,8,9);


        BinaryOperator<Integer> getSum=(acc, x) ->{
            Integer result=acc+x;
            System.out.println("acc: "+ acc + ", x :" +x +" result: "+result);
            return result;
        };

        int i = intList.stream().reduce(0,getSum);//45
        System.out.println(i);

        System.out.println(intList.stream().reduce(0,(x,y)->x+y));//45




    }
}
