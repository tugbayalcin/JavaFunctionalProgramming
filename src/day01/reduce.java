package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class reduce {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55)); // list olusturduk
        maxElFunction(list);

    }

    public static void printEleman(int t) // refere edilecek method create edildi
    {
        System.out.print(t + " ");
    }
    public static boolean ciftBul(int i) // refere edilecek tohum method create edildi
    {
        return i%2==0;
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
