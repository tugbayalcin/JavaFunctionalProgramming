package P1_lambdaExpressions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        //TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** techProEd.txt dosyasini okuyunuz -->  ");
        Files.
                lines(Paths.get("/Users/tugbayalcin/IdeaProjects/JavaLambda/src/P1_lambdaExpressions/techProEd.txt")). // file'daki herbir satir akisin bir elemani oldu
                forEach(System.out::println);
        System.out.println();

        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** techProEd.txt dosyasini buyuk harflerle okuyunuz -->  ");
        Files.
                lines(Paths.get("/Users/tugbayalcin/IdeaProjects/JavaLambda/src/P1_lambdaExpressions/techProEd.txt")).
                map(String::toUpperCase). // akistaki satirlar buyuk harf ile update edildi
                forEach(System.out::println);
        System.out.println();

        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** techProEd.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        Files.
                lines(Paths.get("/Users/tugbayalcin/IdeaProjects/JavaLambda/src/P1_lambdaExpressions/techProEd.txt")).
                limit(1). // ilk satir alindi
                map(String::toLowerCase). // hepsi kucuk yapildi
                forEach(System.out::println); // yazdirildi
        System.out.println();

        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** techProEd.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.
                lines(Paths.get("/Users/tugbayalcin/IdeaProjects/JavaLambda/src/P1_lambdaExpressions/techProEd.txt")).
                filter(t -> t.contains("masa")). // masa kelimesini icerme sarti
                count()); // sarti saglayan elemanlarin(satirlarin) sayilmasi
        System.out.println();

        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** techProEd.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        System.out.println(Files.
                lines(Paths.get("/Users/tugbayalcin/IdeaProjects/JavaLambda/src/P1_lambdaExpressions/techProEd.txt")).
                map(t -> t.split(" ")). // her bir elemani kelmelerine parcalayip arrya'e atadi
                        flatMap(Arrays::stream). // Arrays classindan stream methodu ile array elemanlarindan her bir kelime ile yeniden bir akis olusturdu
                        distinct(). // yeni akistaki array elemanlarinin tekrarsiz olmasini sagladi
                        collect(Collectors.toList())); // yeni akistaki tekrarsiz array elemanlarini list'e atadi
        System.out.println();

        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** techProEd.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** techProEd.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** techProEd.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** techProEd.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** techProEd.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** techProEd.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");






    }

}
