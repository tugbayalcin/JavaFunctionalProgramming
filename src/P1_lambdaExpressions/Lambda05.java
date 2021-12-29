package P1_lambdaExpressions;

import java.util.stream.IntStream;

public class Lambda05
{
    public static void main(String[] args)
    {
        System.out.println(topla(10));
        System.out.println(topla1(10));
        System.out.println(topla2(10));
        System.out.println(ciftleriTopla(10));
        System.out.println(ciftleriTopla1(10)); // 2 4 6 8 10 12 14 16 18 20
        System.out.println(ilkTekleriTopla(10)); // 1 3 5 7 9 11 13 15 17 19
        ikiIlkXKuvvet(5);
        System.out.println();
        sayininIlkXKuvvet(2,3); // 2'nin ilk 3 kuvvetini veririr: 2 4 8
        System.out.println();
        sayininIlkXKuvvet(3,4); // 3'un ilk 4 kuvvetini veririr: 3 9 27 81
        System.out.println();
        sayininIlkXKuvvet(5,3); // 5'in ilk 3 kuvvetini veririr: 5 25 125
        System.out.println();
        sayininIlkXKuvvet(1,10); // 1'in ilk 10 kuvvetini veririr: 1 1 1 1 1 1 1 1 1 1
        System.out.println();
        System.out.println(sayininXinciKuvvet(3, 4));
        sayininXinciKuvvet1(2,3);
    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
    public static int topla(int x)
    {
        int toplam =0;
        for(int i=0; i<=x; i++)
        {
            toplam += i;
        }
        return toplam;
    }
    // functional programming
    public static int topla1(int x)
    {
        return IntStream.
                range(1, x+1). // range() aralik demektir, icine yazilan ilk eleman inclusive(dahil), ikinci eleman exclusive(haric) tir
                               // 1 dene x'e kadar olan sayilarin akisini aldi
                sum();


    }
    // rangeClosed()
    public static int topla2(int x)
    {
        return IntStream.
                rangeClosed(1, x). // rangeClosed() kapali aralik demektir, icine yazilan her iki eleman da dahildir
                                     // 1 dene x'e kadar olan sayilarin akisini aldi
                sum();


    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
    public static int ciftleriTopla(int x)
    {
        return IntStream.rangeClosed(1,x). // 1 2 3 ... elemanlarin akisi
                //filter(Lambda01::ciftBul). // 2 4 6  elemanlarinin akisi
                filter(t -> t%2==0). // 2 4 6 elemanlarinin akisi
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
    public static int ciftleriTopla1(int x)
    {
        return IntStream.iterate(2, t-> t+2). // 2 4 6  elemanlarinin akisi
                limit(x). // nerede duracagini soyluyoruz yoksa cift sayilari sonsuza kadar yazdirmaya devam eder
                          // akistaki ilk x elemani al demis oluyoruz
                                  // x/2 dersen x'e kadar olan sayilari getirir
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
    public static int ilkTekleriTopla(int x)
    {
        return IntStream.iterate(1, t-> t+2). // 2 4 6  elemanlarinin akisi
                limit(x). // nerede duracagini soyluyoruz yoksa cift sayilari sonsuza kadar yazdirmaya devam eder
                // akistaki ilk x elemani al demis oluyoruz
                sum();
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void ikiIlkXKuvvet(int x)
    {
         IntStream.iterate(2, t-> t*2). // 2 4 6  elemanlarinin akisi
         limit(x). // nerede duracagini soyluyoruz yoksa cift sayilari sonsuza kadar yazdirmaya devam eder
         // akistaki ilk x elemani al demis oluyoruz
         forEach(Lambda01::printEleman);

    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
    public static void sayininIlkXKuvvet(int a, int x)
    {
        IntStream.iterate(a, t-> t*a). // hangi elemanin kuvvetlerini istiyorsan o elemandan baslamalisin
                limit(x). // nerede duracagini soyluyoruz yoksa cift sayilari sonsuza kadar yazdirmaya devam eder
                // akistaki ilk x elemani al demis oluyoruz
                forEach(Lambda01::printEleman);

    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz
    public static int sayininFaktoriyeli(int x)
    {
        return IntStream.
                rangeClosed(1,x).
                //reduce(Math::multiplyExact); // method reference
                reduce(1, (t,u)->t*u); // burada t degeri identitiy'den u degeri akistan gelir !!!
    }
    //TASK 06 --> Istenilen bir sayinin x. kuvvetini ekrana yazdiran programi yaziniz
    public static int sayininXinciKuvvet(int a, int x)
    {
        return IntStream.iterate(a, t-> t*a). // hangi elemanin kuvvetlerini istiyorsan o elemandan baslamalisin
                limit(x). // nerede duracagini soyluyoruz yoksa cift sayilari sonsuza kadar yazdirmaya devam eder
                // akistaki ilk x elemani al demis oluyoruz
                reduce(0,(t,u) -> u);

    }
    // ikinci yol
    public static void sayininXinciKuvvet1(int a, int x)
    {
         IntStream.iterate(a, t-> t*a). // hangi elemanin kuvvetlerini istiyorsan o elemandan baslamalisin
                limit(x). // nerede duracagini soyluyoruz yoksa cift sayilari sonsuza kadar yazdirmaya devam eder
                // akistaki ilk x elemani al demis oluyoruz
                skip(x-1). // son sayiya gelene kadar atla demek ancak skipten sonra cikan elemanla toList veya forEach ile yazdirilmalidir
                forEach(Lambda01::printEleman);

    }

}
