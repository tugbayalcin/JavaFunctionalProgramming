package lambda_stream_funcProg.udemy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Udemy05 {

    public static void main(String[] args) {

        //Represents a function that accepts one argument and produces a result.
        //This is a functional interface whose functional method is apply(Object).
        //Since: 1.8
        //Type parameters:
        //<T> – the type of the input to the function
        //<R> – the type of the result of the function
        Function<String,String> function =new Function<String, String>() {
            //input bir string
            //output ise cıft numaralı ındexlerdeki karakterlerden olusmus kelime
            @Override
            public String apply(String s) {
                StringBuilder stringBuilder=new StringBuilder();

                for (int i=0 ; i<s.length() ; i++){
                    if(i%2==0)
                        stringBuilder.append(s.charAt(i));
                }

                return stringBuilder.toString();
            }
        };

        System.out.println(function.apply("emreduman"));//erdmn



        Thread thread = new Thread( () -> //run() methodu override ediliyor
        {

            System.out.println(Thread.currentThread().getName()+" is working");
            StringBuilder stringBuilder = new StringBuilder();

            System.out.println
            (
                new Function<String,String>(){
                    @Override
                    public String apply(String s) {
                        for (int i = 0; i < s.length(); i++) {
                            if (i % 2 == 0) {
                                stringBuilder.append(s.charAt(i));
                            }
                        }
                        return stringBuilder.toString();
                    }
                }.apply("emreduman")
            );//end of apply(String s) method

        });// end of run()
        thread.setName("lambda thread");
        thread.start();
        //lambda thread is working
        //erdmn



        //function1 'i dısarı declared edip icerde kullanamam cünkü
        //functional programming'de state final ve immutable'dır
        Thread thread2 = new Thread( () -> //run() methodu override ediliyor
        {

            System.out.println(Thread.currentThread().getName()+" is working");
            StringBuilder stringBuilder = new StringBuilder();

            Function<String,String> function1=(s) ->{//apply(R r) methodu  overriding - interface'in icinde
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 == 0) {
                        stringBuilder.append(s.charAt(i));
                    }
                }
                return stringBuilder.toString();
            };
            //System.out.println(function1.apply("emreduman")); alttaki ile aynı
            System.out.println(getCharsInEvenIndex(function1,"emreduman"));

        });// end of run()
        thread2.setName("lambda2 thread");
        thread2.start();
        ///lambda2 thread is working
        //erdmn




        System.out.println(getCharsInEvenIndex(function,"emreduman"));

        abc<Integer> a= new abc<>() {
       //interface variable= anonymous class objesidir
            @Override
            public Integer method(Integer i) {
                return i*2;
            }
        };
        System.out.println(a.method(10));

        abc<String> b=new abc<String>() {
            @Override
            public String method(String s) {
                return "emre"+s;
            }
        };
        System.out.println(b.method("duman"));

    }

    public static String getCharsInEvenIndex( Function<String,String> function,String source){
        return function.apply(source);
    }


}


interface abc<R>{

     R method(R r);
}

