package P2_individualStudy;

import java.util.ArrayList;
import java.util.function.Consumer;

public class C01
{
    interface StringFunction {
        String run(String str);
    }
    public static void main(String[] args) {

        /*
        --------------------------------------------------------------
        WHAT IS THE LAMBDA EXPRESSIONS
        --------------------------------------------------------------
        */

        /*
        Bir diger adı Closures olan Lambda ifadeleri kisaca kendi baslarina tanimlanabilen fonksiyonlardir.
        Neden kendi basina diyoruz cunku bir sinifa bagimli olmalarina gerek kalmadan tanimlayabiliyoruz

                       (name)                  ->           (System.out.println("Hello" + name)
                 method parametresi      Lambda operatoru             Method Govdesi

        Lambda ifadelerinin sonucu bir degiskene atanabilir veya bir fonksiyona parametre olacak gecilebilir.

        Lambda Expression'lar parametre alip, bu parametrei bir method gibi isleyerek geriye deger donduren kisa kod block'laridir.
        Bu yuzden methodlara cok benzerler.
        Ancak methodlar gibi isimleri yoktur ve dogrudan bir methodun body'si icinde kullanilabilirler

        Basit Lambda Expression'lar bir parametre ve ifade(expression) dan olusurlar.
        parameter -> expression
        Expression, parametreyi alip ne yapacagimizi gosteren bir fonksiyon gibi dusunulebilir

        Eger Lambda Expression birden fazla parametre icerecekse, bu parametreler parantez icerisinde yazilmalidir
        (parameter1, parameter2) -> expression

        Expression'lar sinirlidir ve bazi kurallari saglamak zorundadirlar:
        1.Kullanildigi anda geriye bir deger dondurmelidirler
        2.Dondurulen deger variable, assignment veya statement icermemelidir (if ya da for gibi)
        3.Expression olarak karmasik islemler yaptirilacaksa bu islemler (kod blogu) suslu parantez icerisine yazilmalidir
          (parameter1, parameter2) -> { code block }
        4.Eger expression'in geriye deger dondurmesi gerekiyorsa code block return statement icermelidir.
        */

        /*
          --------------------------------------------------------------
          USING LAMBDA EXPRESSIONS
          --------------------------------------------------------------
        */

        //  Using 1: Lambda ifadeleri genellikle bir fonksiyona parametre olarak gonderilir
        //  Example: Lambda expression kullanarak verilen bir array list'in tum elemanlarini foreach methodu ile yazdiralim:
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        // List<Integer> numbers = new ArrayList<>(Arrays.asList(5,9,8,1)); ile de ArrayList olusturabiliriz
        // Liste olusturup kolayca elemanlarini atayabilmek icin pratik bir yontem
        numbers.forEach( (n) -> { System.out.println(n); } );

        // Using 2: Lambda expressions can be stored in variables if the variable's type is an interface which has only one method.
        // The lambda expression should have the same number of parameters and the same return type as that method.
        // Java has many of these kinds of interfaces built in, such as the Consumer interface (found in the java.util package) used by lists.
        // Example: Java Consumer interface'ini kullanarak Lambda Expresion ile degisken saklayalim
        ArrayList<Integer> numbers1 = new ArrayList<Integer>();
        numbers1.add(5);
        numbers1.add(9);
        numbers1.add(8);
        numbers1.add(1);
        Consumer<Integer> method = (n) -> { System.out.println(n); };
        numbers.forEach( method );

        // Using 3: To use a lambda expression in a method, the method should have a parameter with a single-method interface as its type.
        // Calling the interface's method will run the lambda expression
        // Burada functional interface'den mi bahsediyor acaba?
        // (functional interface: yalnizca 1 tane soyut method iceren ve sayisiz default method
        // (body'si olan, hatirlarsan burada iki ozel kelime vardi default ve static)
        // icerebilen interface'lerdir
        // Example: Lambda expression'i parametre olarak alan bir method create edelim ve main icerisinden cagirarak kullanalim
        // ornegin interface i yukarida tanimli
        StringFunction exclaim = (s) -> s + "!";
        StringFunction ask = (s) -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);
        // ornegin lambda exp. iceren emthodu asagida tanimli

    }
    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }
}
