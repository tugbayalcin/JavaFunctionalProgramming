package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class map {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(12,13,65,3,7,34,22,60,42,55)); // list olusturduk

    }

    public static void printEleman(int t) // refere edilecek method create edildi
    {
        System.out.print(t + " ");
    }
    public static boolean ciftBul(int i) // refere edilecek tohum method create edildi
    {
        return i%2==0;
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

    // Functional Programming ile list elemanlarinin  cift olanlarinin karekoklerini
    // ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void printCiftKareKok(List<Integer> list)
    {
        list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t-> System.out.println(t + " "));
    }

}
