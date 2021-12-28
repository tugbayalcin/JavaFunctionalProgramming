package lambda_stream_funcProg.techproed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    /*
    Lambda = Functional Programming - using predefined methods
    Normal Java = Structured Programming - coding
     */
    public static void main(String[] args)
    {

        List<String> list01 = new ArrayList<>();
        list01.add("emre");
        list01.add("duman");
        list01.add("beyza");
        list01.add("emine");

        //Structured Programming
        for (String s : list01) {
            System.out.println(s);
        }

        //Functional Programming - forEach()
        list01.
            stream().
            forEach(t -> System.out.println(t));

        for (String s : list01) {
            if (s.length() >= 5)
                System.out.println(s);
        }

        //filter()
        list01.
            stream().//elemanları yukarıdan asagı dizer
            filter(t -> t.length()>=5).//filtreleme yaparız
            forEach(t -> System.out.println(t));//forEach gibi elemanları gezeriz

        System.out.println(list01);//stays same

        for (String s : list01) {
            if (s.endsWith("e"))
                System.out.println(s);
        }

        list01.
            stream().
            filter(t -> t.endsWith("e") && t.contains("m")).
            forEach(t -> System.out.println(t));

        //char sayısı 5ten büyük olanları upperCase olarak yazdır
        list01.
            stream().
            filter(t -> t.length() >=5).
            map(t -> t.toUpperCase()).//objectler üzerinde islem yapmak ıcın kullanırız
            forEach(t -> System.out.println(t));

        //map()
        //List<String> list02= list01. de olur
        Collection<String> list02= list01.
                stream().
                filter(t -> t.length() >=5).
                map(String::toUpperCase).//mevcut objeleri String Classındaki toUpperCase() ile kullan
                collect(Collectors.toList());//return a Collection -

        list02.forEach(System.out::println);//System.out.println(t);

        //elemanların lenght'ini yazdır
        list01.stream().forEach(t -> System.out.println(t.length()));
        list01.
            stream().
            map(t -> t.length()).//eleman sayları ile işlem yapıcam
            forEach(t -> System.out.println(t));

        //e icerenlerın char sayısının karesını yazdır
        list01.
            stream().
            filter(t -> t.contains("e")).
            map(t -> t.length()*t.length()).
            forEach(System.out::println);


        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("John");
        list.add("Ali");
        list.add("Alexander");
        list.add("Taylor");
        list.add("Ali");
        list.add("Jackson");

        list.stream()
                .filter(t -> !t.startsWith("J"))//J ile baslamayanlar
                .distinct()
                .sorted(Comparator.comparing(t -> t.length()))//uzunluguna gore sırala
                .map(t -> t.toUpperCase())
                .forEach(t -> System.out.print(t + " "));
        ///ALI TAYLOR ALEXANDER





    }

}