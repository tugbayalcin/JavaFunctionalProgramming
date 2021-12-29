package P1_lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Lambda01 Class'i remote tugba1 branchi commit yapildi
public class Lambda01 {
    public static void main(String[] args) {
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
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55)); // list olusturduk

        //30. satirdaki kod structural programming'tir
        printElemanStructured(list); // method call
        System.out.println();
        printElemanFunctional(list);
        System.out.println();
        printElemanFunctional1(list);
        System.out.println();
        printCiftElemanStructured(list);
        System.out.println();
        printCiftElemanFunctional(list);
        System.out.println();
        printCiftAltmisKucuk(list);
        System.out.println();
        printTekYirmiBuyuk(list);
        System.out.println();
        printCiftKare(list);
        System.out.println();
        printTekKupArtiBir(list);
        System.out.println();
        printCiftKareKok(list);
        System.out.println();
        maxElFunction(list);

    }

    // structured programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz
    public static <T> void printElemanStructured(List<T> list) {
        for (T w : list) {
            System.out.print(w + " ");
        }
    }

    // functional programming ile list elemanlarinin tamamini aralarina bosluk birakarak yazdiriniz
    public static void printElemanFunctional(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));
        /*
        // Lambda expression , method chain ile yaptik
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

         */
    }

    // Method Reference --> kendi create ettigimiz veya java'dan aldigimiz method ile
    // ClassName::MethodName
    // seklinde bir kullanim saglanir

    public static void printEleman(int t) // refere edilecek method create edildi
    {
        System.out.print(t + " ");
    }

    // method reference + java methodlari(System.out::println)
    public static void printElemanFunctional1(List<Integer> list) {
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
    public static void printCiftElemanStructured(List<Integer> list) {
        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    public static boolean ciftBul(int i) // refere edilecek tohum method create edildi
    {
        return i % 2 == 0;
    }

    // functional programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
    // method reference + kendi methodlarimiz(Lambda01::printEleman)
    public static void printCiftElemanFunctional(List<Integer> list)
    {
        list.stream().filter(t->t%2==0).forEach(Lambda01::printEleman);
        // filter ile if in yaptigi isi yaptik ve filtreledik
        // neye gore filtreledigimizi de icine lambda expression ile yazdik
        // 2 ile tam bolunen t leri al dedik
        // filter() : elemanlari istenen sarta gore filtreler
    }

    // filter icine de method cagirarak cozmeyi deneyelim
    public static void printCiftElemanFunctional0(List<Integer> list) // iki tane emthod refere etmis olduk
    {
        list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEleman);
    }

    // functional programming ile list elemanlarinin cift olanlarinin 60'dan kucuk olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftAltmisKucuk(List<Integer> list)
    {
        list.stream().filter(t-> t%2==0 &  t<60).forEach(Lambda01::printEleman); // burada filter icinde & nin iki yaninda da ayni yapiyi kullanmalisin
        // ya her ikisi de method call olmali ya da her ikisi de lambda expression olmali
        // lambda exprettion kullaniyorsan t-> yi bir kere kullanmalisin sonrasinda kosulunu & baglaci ile yazabilirsin
        // veya pes pese iki tane filter() da kullanabilirsin
        // malzemeyi eline al(list).arzular selale(stream).filtre
    }

    // functional programming ile list elemanlarinin tek olanlarini veya 20'den buyuk olanlarini ayni satirda aralarinda bosluk birakarak yazdiriniz
    public static void printTekYirmiBuyuk(List<Integer> list)
    {
        list.stream().filter(t-> t%2==1 || t>20).forEach(Lambda01::printEleman);
    }

    // functional programming ile list elemanlarinin cift olanlarinin karelerini ayni satirda aralarinda bosluk birakarak yazdiriniz
    public static void printCiftKare(List<Integer> list)
    {
        list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEleman);
        // map() : degisiklik yap demektir, verilen elmani al ve evrdigim kurala gore degistir
        // map() : bir ara islemde kullanilir. elemanlari istenen isleme gore degistirmek ve update etmek icin kullanilir
    }

    // ayni methodu mopdifiye edecegiz
    public static void printCiftKare1(List<Integer> list)
    {
        // list.stream().filter(Lambda01::ciftBul).map(Math::pow).forEach(Lambda01::printEleman);
        // burada type missmatch'den dolayi hata verdi (double olmaliymis bizim typeimiz int) ama ana fikir su idi:
        // biz method referance expression icin yalnizca kendi yazdigimiz methodlari degil
        // javada var olan class ve methodşari da kullanabiliriz
    }

    // Functional Programming ile list elemanlarinin  tek olanlarinin kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printTekKupArtiBir(List<Integer> list)
    {
        list.stream().filter(t-> t%2==1).map(t-> (t*t*t)+1).forEach(Lambda01::printEleman);
    }

    // Functional Programming ile list elemanlarinin  cift olanlarinin karekoklerini
    // ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftKareKok(List<Integer> list)
    {
        list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t-> System.out.println(t + " "));
    }

    // list in en buyuk elemanini yazdiriniz
    public static void maxElFunction(List<Integer> list)
    {
        //list.stream().reduce(Math::max);
        // reduce() :  reduce kelime olarak azaltmak demektir, cok elemani az elemana azaltir, huni gibi
        // reduce() : bir cok datayi tek bir dataya cevirmek icin kullanilir, ma

        Optional<Integer> maxEl = list.stream().reduce(Math::max);
        System.out.println(maxEl);
        // optional
    }


}
