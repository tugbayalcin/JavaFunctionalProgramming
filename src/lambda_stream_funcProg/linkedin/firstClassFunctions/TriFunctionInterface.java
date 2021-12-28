package lambda_stream_funcProg.linkedin.firstClassFunctions;

public class TriFunctionInterface {// I WILL BUILD IT
    public static void main(String[] args)
    {
        //1. structured programming imperative approach
        TriFunction<Integer,Integer,String,String> triFunction0=new TriFunction<Integer, Integer, String, String>() {
            @Override
            public String apply(Integer integer, Integer integer2, String s) {
                integer*=2;
                String r= integer+integer2+s;
                return r;
            }
        };

        //functional programming declarative approach
        TriFunction<Integer,Integer,String,String> triFunction=(x,y,z) -> {
            x*=2;
            String r= x+y+z;
            return r;
        };
        //triFunction -> anonymous clas nesnesi
        System.out.println(triFunction.apply(1,2,"emre"));//4emre

        TriFunction<Integer,Integer,String,String> triFunction1=(x,y,z) -> x+y+z;
        String s=triFunction1.apply(1,2,"3");
        System.out.println(s);//33

        TriFunction<Integer,Integer,String,String> triFunction2 = (x,y,z) ->{
            return x+y+z;
        };
        System.out.println(triFunction2.apply(1,2,"3"));




        NoArgsFunction<Integer> noArgsFunction0=new NoArgsFunction<Integer>() {
            @Override
            public Integer apply() {
                return 0;
            }
        };
        System.out.println(noArgsFunction0.apply());

        NoArgsFunction<String> noArgsFunction=() -> "hello!" ;//apply() methodu String return ediyor
        System.out.println(noArgsFunction.apply());//hello!


    }
}

@FunctionalInterface
interface TriFunction<T,U,V,R>{
     R apply(T t,U u,V v);
}

@FunctionalInterface
interface NoArgsFunction<R>{
    R apply();
}
