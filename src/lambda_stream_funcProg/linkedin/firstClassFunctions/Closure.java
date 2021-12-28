package lambda_stream_funcProg.linkedin.firstClassFunctions;

public class Closure
{
    public static void main(String[] args)
    {

        NoArgsFunction<NoArgsFunction<String>> createGreeter = () ->{
            String name="Emre";
            return () -> "Hello, " + name;
        };

        System.out.println(createGreeter.apply());

        NoArgsFunction<String> greeter=createGreeter.apply();
        System.out.println(greeter.apply());

    }
}
