package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//REMOTE tugba1 branch'i
public class fFilter
{
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55)); // list olusturduk
        printCiftElemanFunctional(list);
    }

    public static void printEleman(int t) // refere edilecek method create edildi
    {
        System.out.print(t + " ");
    }
    public static boolean ciftBul(int i) // refere edilecek tohum method create edildi
    {
        return i%2==0;
    }

    // functional programming ile list elemanlarinin cift olanlarini ayni satirda aralarina bosluk birakarak yazdiriniz
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

    // Functional Programming ile list elemanlarinin  tek olanlarinin kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printTekKupArtiBir(List<Integer> list)
    {
        list.stream().filter(t-> t%2==1).map(t-> (t*t*t)+1).forEach(Lambda01::printEleman);
    }

}
