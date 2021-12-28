package lambda_stream_funcProg.linkedin.firstClassFunctions;

import java.util.function.Function;

public class ReturningFunctions {

    public static class MyMath{
        public static Integer twoTimes(int x){
            return x*2;
        }

        public static Integer threeTimes(int x){
            return x*3;
        }

        public static Integer fourTimes(int x){
            return x*4;
        }
        //instead of repeating methods use lambda

        public static Function<Integer,Integer> createMultiplier2(Integer y){
            return new Function<Integer, Integer>() {
                @Override
                public Integer apply(Integer integer) {
                    return integer*y;
                }
            };
        }

        public static Function<Integer,Integer> createMultiplier(Integer y){
            return (x) -> x*y;///function return ediyor
        }
    }

    public static void main(String[] args) {

        NoArgsFunction<NoArgsFunction<String>> createGreeter11 = new NoArgsFunction<NoArgsFunction<String>>() {
            @Override
            public NoArgsFunction<String> apply()
            {
                return new NoArgsFunction<String>()
                {
                    @Override
                    public String apply()
                    {
                        return "hello functional";
                    }
                };
            }
        };


        NoArgsFunction<NoArgsFunction<String>> createGreeter = () -> () -> {
        return "hello functional";
        };

        //override icinde override
        NoArgsFunction<NoArgsFunction<String>> createGreeter2 = () -> () -> "hello functional";
        //there is a function without parameter which returns another function without parameter which return String

        System.out.println(createGreeter2.apply());

        NoArgsFunction<String> greeter= createGreeter2.apply();
        System.out.println(greeter.apply());//hello functional

        Function<Integer,Integer> twoTimes=MyMath.createMultiplier(2);
        Function<Integer,Integer> threeTimes=MyMath.createMultiplier(3);
        Function<Integer,Integer> fourTimes=MyMath.createMultiplier(4);

        System.out.println(twoTimes.apply(5));//2 times 5 =10
        System.out.println(threeTimes.apply(5));//3 times 5 =15
        System.out.println(fourTimes.apply(5));//4 times 5 =20


    }
}
