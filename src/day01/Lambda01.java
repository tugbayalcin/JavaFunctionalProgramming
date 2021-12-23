package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01
{
    public static void main(String[] args)
    {
        /*
           1) Lambda "Functional Programming"
              "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
           2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
           3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
           ve hatasiz code yazma acilarindan cok faydalidir.
           4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
              Lambda kullanmak hatasız code kullanmaktır.
        */

        // foreach : yazdir
        // stream : selale yap
        // filter : filtrele
        // yazarken her method 1 satira yazilir ve her satirda bir islem yapilir, hepsi yan yana yazilmaz bu seni prof gosterir

        //27. satirdaki kod= structural programming'tir
        List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55)); // list olusturduk

        //30. satirdaki kod structural programming'tir
        printElemanStructured(list); // method call
        System.out.println();
        printElemanFunctional(list);
        System.out.println();
        printElemanFunctional1(list);
        System.out.println();
        printCiftElemanStructured(list);
        System.out.println();
        //printCiftElemanFunctional(list);
        System.out.println();
        //printCiftAltmisKucuk(list);
        System.out.println();
        //printTekYirmiBuyuk(list);
        System.out.println();
        //printCiftKare(list);
        System.out.println();
       // printTekKupArtiBir(list);

    }

    // structured programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz
    public static <T> void printElemanStructured(List<T> list)
    {
        for (T w: list)
        {
            System.out.print(w +" ");
        }
    }

    // functional programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElemanFunctional(List<Integer> list)
    {

        list.stream().forEach(t-> System.out.print(t + " ")); // Lambda expression , method chain ile yaptik
        // buradaki t-> lambda operatorudur. conventional kullanimlardan biridir. tipki fordaki i, foreach deki each(veya w) gibi
        // stream() : bu method datalari yukaridan asagiya akis sekline getirir
        // forEach() : datanin parametresine gore her bir elemani isler

        // structural programming : bir sey insa etmen gerektiginde
        // functional programming : islevsellikle ilgilendiginde

        // ey list objesi, stream methodu ile calis,stream ol, selale gibi ol, ak. ve yazdir
        // list yatay bir yapidir
        // stream dikey bir yapidir. selale, akis demektir
        // burada list'in elemanlarini aliyoruz, stream ile list elemanlarini akis haline getiriyor, dikey yapiya donusturuyor
        // foreach ise her bir list elamanini alip t-> yerine koyuyor, t ile ne yapacagimiz da -> sonrasinda yaziyor
        // yanina bir bosluk ekleyerek yazilacakmis
        // stream methodu ile chain yapisinda yatayda olmayan methodlardan yararlanabilecegiz. Yani daha cok methoda erisebilmek icin stream kullaniriz
        // yatay methodlar, dikey methodlardan daha azdir ve bazi methodlar yalnizca ve yalnizca dikey yapilarda calisiyor
        // biz de stream ile once yatay elemanimizi dikey yapar sonra da istedigimiz methodu kullanabiliriz

        // Lambda Expression yapisi cok tavsiye edilmez, daha cok METHOD REFERENCE kullanilir

    }

    // Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile
    // ClassName::MethodName
    // seklinde bir kullanim saglanir

    public static void printEleman(int t) // refere edilecek method create edildi
    {
        System.out.print(t + " ");
    }
    public static void printElemanFunctional1(List<Integer> list)
    {
        list.stream().forEach(System.out::println);//elemanlari tektek yazdir
        //forEach( void methodAdi() ) yani -> forEach(gorev)
        // foreach methodu paraöetre olarak bir method, yani gorev alir.

        // int yas=10; bir structure 'dir
        // structural programming'de methodAdi(parametreType) olarak methodlari kullanirdik.

        // void println() bir method-gorev'dir
        //functional programming'te methodAdi(gorev)

        // structural (yapisal) programmingde void methodlar parametre olarak kullanilamazken,
        // functional (islevsel) programmingde void methodlar parametre olarak kullanilabilir


        list.stream().forEach(Lambda01::printEleman); // ey list stream ol ve git verdigim emthodu calis
        // method ne yapiyormus, gidip elemanlari yazdiriyormus
    }

    // structured programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftElemanStructured(List<Integer> list)
    {
        for (Integer w: list)
        {
            if(w%2==0)
            {
                System.out.print(w + " ");
            }
        }
    }

    public static boolean ciftBul(int i) // refere edilecek tohum method create edildi
    {
        return i%2==0;
    }













}
