package P1_lambdaExpressions;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("mehmet", "emre", "nilgun", "yildiz", "kader", "emine", "islam", "islam", "emre"));

        buyukHarfTekrarsizSira(list);
        System.out.println();
        charSayisiTekrarsizTersSirali(list);
        System.out.println();

    }
    // List elemanlarini alfabetik buyuk harf sirasi ile ve tekrarsiz olarak yazdiriniz
    public static void buyukHarfTekrarsizSira(List<String> list)
    {
        list.
                stream(). // akisa girdi
                map(t -> t.toUpperCase()). // hepsini buyuk harf yapti // map(String::t.toUpperCase()) ile yani method referance ile de yapabilirdik)
                sorted(). // naturel order ile alfabetik siraladi
                distinct(). // tekrarsiz olmasini sagladi
                forEach(t -> System.out.print(t + " ")); // yazdirdi // veya forEach(System.out::println()); ile de yapilabilir
    }

    // List elemanlarinin karakter sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void charSayisiTekrarsizTersSirali(List<String> list)
    {
        list.
                stream().
                map(t -> t.length()). // String data character sayisina update edildi
                sorted(Comparator.reverseOrder()). // ters siralama yapildi
                distinct(). // tekrarsiz olmasi saglandi
                forEach(Lambda01::printEleman); // yazdirildi, degerlerim integer oldugu inin Lambda classindaki print methodunu kullanabildik
    }

    // List elemanlarini character sayisina gore kucukten buyuge dogru yazdiriniz
    public static void charSayisiSiraliEleman(List<String> list)
    {
        list.stream().
                sorted(Comparator.comparing(t -> t.length())). // sirala, karsilastir --> eleman karakter sayisina gore ozel siralama yapildi
                forEach(t -> System.out.println(t + " "));
        // buyukten kucuge deseydi t.length().reverseOrder() derdik
    }

    // Lİst elemanlarini son harfine gore ters sirali olarak yazdiriniz (yani once z den baslayacak)
    public static void sonHarfeGoreTersSiraliEleman(List<String> list)
    {
        list.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString(). // comparing karsilastirma methodudur
                                charAt((t.toString().length()-1))). // elemanin son index'inee karsilik gelen karakteri alir
                        reversed()). // alinan karakterleri ters siralar (z den a ya)
                forEach(t -> System.out.println(t + " "));
        // sorted() tek basina naturel order yapar eger ben ozel bir kosula gore siralama yaptirmak istiyorsam
        // icine Comparator classindan comparing methodunu cagirmam ve expressionumu yazmam gerekir
        // foreach ile int yazdirabiliriz, string yazdiramayiz
    }

    // Listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  yaziniz.
    // Cift sayili elemanlarin eleman sayilarinin karelerini hesaplayan, tekrarsiz olarak ve buyukten kucuge dogru yazdiran bir program yaziniz.
    public static void ciftKareTekrarsizTersSira(List<String> list)
    {
        list.
                stream().
                // filter(t -> t.length()%2==0).
                map(t -> t.length()*t.length()). // string elemanlar character sayilarina donusturuldu
                filter(Lambda01::ciftBul). // cift sarti calisti
                distinct(). // tekrarsiz
                sorted(Comparator.reverseOrder()). // ters sira --> buyukten kucuge
                forEach(Lambda01::printEleman); // yazdirildi
    }

    // List elemanlarinin character sayisin 7 ve 7'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7Kontrol (List<String> list)
    {
        /*
       boolean kontrol = list.stream().allMatch(t -> t.length()<=7);
       // allMatch methodu tum listeyi gezer ve arranilan ozellikte 1 tane bile eleman bulursa hemen true dondurur bulamazsa false dondurur
        if(kontrol)
        {
            System.out.println("List'te 7 harften daha buyuk eleman yoktur.");
        }
        else
        {
            System.out.println("List'te 7 harften daha kucuk eleman vardir");
        }
         */
        // mantik bu sekildedir ancak lambda kisa kpod yazmak iken bu kadar uzun if else yazmak hos degil o zaman soyle yapariz
        // ternary kullaniriz

        System.out.println(list.stream().allMatch(t -> t.length()<=7) ?
                "List'te 7 harften daha buyuk eleman yoktur." :
                "List'te 7 harften daha kucuk eleman vardir" );
    }

    // List elemanlarinin "w" ile baslayip baslamadigini kontrol ediniz
    public static void baslangicWKontrol (List<String> list)
    {
        System.out.println(list.
                stream().
                noneMatch(t -> t.startsWith("w"))? // noneMatch hicbiri eslesmesin demek, eger bir tane bile eslesen varsa false doner
                " w ile baslayan isim yoktur" :
                " w ile baslayan isim vardir");

        // hem lambda hem ternary
    }
    // List elemanlarinin "x" ile biten  en az bir elemani olup olmadigini kontrol ediniz
    public static void bitisXKontrol (List<String> list)
    {
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x"))? // anymatch demek en az bir tane bu ozellikte eleman olsun bana yeter demek, 1 tane bulsa true doner
                " w ile baslayan isim vardir" :
                " w ile baslayan isim yoktur");

        // hem lambda hem ternary
    }

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // List'teki karakter sayisi en buyuk elemani yazdiriniz
    public static void enBuyukKarakterliEleman (List<String> list)
    {
        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()). // length karakter uzunluguna gore siraladi kucukten buyuge dogru
                        reversed()). // ters siraladi buyukten kucuge
                findFirst()); // ilk elemani aldi

    }

    public static void karakteriEnBuyukEleman2 (List<String> list)
    {
        Stream<String> sonIsim = list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
                        reversed()).//ters sirlad b->k
                //  findFirst());//ilk elelmani aldi
                        limit(1);//limit(a) akısdan cıkan elemanları a parametresine dore ilk a elamanı alır
        System.out.println(Arrays.toString(sonIsim.toArray()));
    }

    // List elemanlarini son harfine göre siralayip ilk eleman haric kalan elemanlari yazdiniz
    public static void ilkElemanHaricSonHarfSirali (List<String> list)
    {
        list.stream().sorted(Comparator.comparing(t -> t.toString().charAt(t.length()-1))).skip(1).forEach(t -> System.out.print(t + " "));
        // skip(1) dersen akistan cikan elemanlardan ilk elemani atlar
        // skip() dersen akistan cikan elemanlardan ilk 3 elemani atlar
    }
}
