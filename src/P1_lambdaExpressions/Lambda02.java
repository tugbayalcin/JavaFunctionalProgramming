package P1_lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        // spesific(kucuk) yapilar daha hizli calisir
        // mesela ayni isi hem Integer classi ile hem de Math class'i ile yapabiliyorsam,
        // Math classi daha kucuk ve spesifict oldugu icin daha hizlidir

        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));

        ciftKareMax(list);
        System.out.println();
        toplaEleman1(list);
        System.out.println();
        toplaEleman2(list);
        System.out.println();
        carpCiftEleman1(list);
        System.out.println();
        carpCiftEleman2(list);

    }

    // List'in cift olan elelmanlarin karelerini aliniz ve en buyugunu yazdiriniz
    public static void ciftKareMax(List<Integer> list) {
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce(Math::max) da kullanilabilir ancak kapsami genis olur, daha spesific oldugu icin Integer::max tercih edilir
        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);

        // reduce() dan return edilen eleman null ya da int'den buyuk bir eleman olabilir. Bu ihtimal icin
        // Java guvenlik olarak handle ederek Optional class sart kosar

        System.out.println(maxEl);
    }

    // List'teki tum elemanlarin toplamini yazdiriniz (Lambda Expression ile ...)
    public static void toplaEleman1(List<Integer> list) {
        int toplam = list.stream().reduce(0, (t, u) -> t + u);     // burada 0 baslangic degeridir ve int toplam =0 gibi dusunebilirsin
        //  t parametresi her zaman ilk degerini atanan degerden (0) alir
        //  u parametresi her zaman ilk degerini list.stream() (akis) dan (yani sonuctan) alir
        //  t ilkd egerden sonraki degerleini islemden alir
        /*
            yukaridaki listimiz icin   t ve u degerlerinin nasil calistigini modellemeye calisalim
               t        u        sonuc
             -----    -----     -------
               0       12         12
               12      -3          9
               9       65         74
         */
        System.out.println(toplam);
        System.out.println(list.stream().reduce(0, (t, u) -> t + u)); // ust satirla ayni sey
    }

    // List'teki tum elemanlarin toplamini yazdiriniz (Method Referance ile ...)
    public static void toplaEleman2(List<Integer> list) {
        Optional<Integer> toplam = list.stream().reduce(Integer::sum);
        Optional<Integer> toplam1 = list.stream().reduce(Math::addExact);
        System.out.println(toplam);
        System.out.println(toplam1);
    }

    //  List'teki cift elemanlarin carpimini yazdiriniz (Method Referance ile ...)
    public static void carpCiftEleman1(List<Integer> list) {
        Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
        System.out.println(carp);
    }

    //  List'teki cift elemanlarin carpimini yazdiriniz (Lambda Expression  ile ...)
    public static void carpCiftEleman2(List<Integer> list) {
        Integer carp = list.stream().filter(Lambda01::ciftBul).reduce(1, (x, y) -> (x * y));
        System.out.println(carp);
    }

    // List'teki elemanlardan en kucugunu 4 farkli yontemle yazdiriniz
    // 1. Yontem: Method Reference -> Integer class
    public static void min1(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println(min);
    }

    // 2. Yontem: Method Reference -> Math class
    public static void min2(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Math::min);
        System.out.println(min);
    }

    // 3. Yontem: Method Reference -> Tugba class
    public static int minBul(int x, int y)
    {
        return x<y?x:y ;  //ternary
    }
    public static void min3(List<Integer> list) {
        Optional<Integer> min = list.stream().reduce(Lambda02::minBul);
        System.out.println(min);
    }

    // 4. Yontem: Lambda Expression ->
    public static void min4(List<Integer> list) {
        Integer min = list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y); // lambda expression icinde ternary kullandik
        // Integer.MAX_VALUE identity dir, yani baslangic degeridir
        // eger ilk degeri integer in min degerini secse idik hem listede olmadigi halde min o sayi olacakti
        // hem de listeden hangi sayi gelirse gelsin en kucuk daima kendisi olacakti
        System.out.println(min);
    }
}
