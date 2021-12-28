package lambda_stream_funcProg.linkedin.firstClassFunctions;

import java.util.function.BiFunction;

public class PassingFunctionsAsArgs {

    public static void main(String[] args)
    {
        System.out.println(MyMath3.add(2,3));

        System.out.println(MyMath3.combine2and3(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        }));

        System.out.println(MyMath3.combine2and3( (x,y) -> x+y));

        System.out.println(MyMath3.combine2and3(MyMath3::add));//int return eden, 2 int parametreli methodu koyablirim  R apply(T t, U u); yerine
        System.out.println(MyMath3.combine2and3(MyMath3::subtract));


        System.out.println(MyMath3.combine2and3((x,y) -> 2*x+y));//yukardaki overriding ile aynı
        System.out.println(MyMath3.combine2and3(Integer::sum));//int return eden,2 integer parametresi alan bir method koydum


    }


    public static class MyMath3{

        public static Integer add(Integer a,Integer b){
            return a+b;
        }

        public static Integer subtract(Integer a,Integer b){
            return a-b;
        }

        public static Integer combine2and3(BiFunction<Integer,Integer,Integer> biFunction){
            return biFunction.apply(2,3);
        }
    }
}
