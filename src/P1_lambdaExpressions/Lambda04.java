package P1_lambdaExpressions;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {

        TechProEd trGunduz = new TechProEd("yaz", "TR gunduz", 97, 124);
        TechProEd engGunduz = new TechProEd("kis", "ENG gunduz", 95, 131);
        TechProEd trGece = new TechProEd("bahar", "TR gece", 98, 143);
        TechProEd engGece = new TechProEd("sonbahar", "ENG gece", 93, 151);

        List<TechProEd> list = new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));

        // bu class'da agirlikli olarak return type calisacagiz


        System.out.println(batchOrt92denBuyuk(list));
        System.out.println(ogrSayisi110danBuyuk(list));
        System.out.println(baharVarMi(list));
        System.out.println(ogrSayisiTersSiraliBatch(list));
        System.out.println(batchOrtTersSiraliBatch(list));
        System.out.println(ogrSayisiEnAzIkinciBatch(list));
        System.out.println(ogrOrt95tenBuyukOgrSayisiTop(list));
        System.out.println(ogrOrt95tenBuyukOgrSayisiTop1(list));
        System.out.println(ogrSayisi130danBuyukBatchOrt(list));
        System.out.println(gunduzBatchSayisi(list));
        System.out.println(ogrSayisi130danFazlaEnBuyukOrt(list));
        System.out.println(ogrSayisi150denAzEnKucukOrt(list));


    }

    // task 01 : batch ortalamalarinin 92'den buyuk olup olmadigini kontrol eden method create ediniz
    public static boolean batchOrt92denBuyuk(List<TechProEd> list)
    {
        return list.
                stream().
                allMatch(t -> t.getBatchOrt()>92); // akistaki her eleman batchOrt field'ina gore eslesmesi kontrol edildi
        // allMatch(TechProEd::getBatchOrt()>92);

    }

    // task 02: batchlerin ogrenci sayilarinin hicbirinin 110'dan kucuk olmadigini kontrol eden method create ediniz
    public static boolean ogrSayisi110danBuyuk (List<TechProEd> list)
    {
        return list.
                stream().
                //noneMatch(t -> t.getOgrcSayisi()<110); veya
                allMatch(t -> t.getOgrcSayisi()>=110);
    }

    // task 03 : batch'lerin herhangi birinin 'bahar' olup olmadigini kontrol eden methodu create ediniz
    public static boolean baharVarMi (List<TechProEd> list)
    {
        return list.stream().anyMatch(t -> t.getBatch().equals("bahar"));
    }

    // task 04 : batch'leri ogrenci sayilarina gore buyukten kucuge dogru siralayiniz
    public static List<TechProEd>  ogrSayisiTersSiraliBatch (List<TechProEd> list)
    {
        return list.
                stream().
                sorted(Comparator.comparing(TechProEd::getOgrcSayisi).
                        reversed()).
                collect(Collectors.toList()); // collect() akistan cikan elemanlari istenen sarta gore toplar, koleksiyonerdir
                // Collectors.toList() : collect'e toplanan elemanlari list'e cevirir
    }

    // task 05 : batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz.
    public static List<TechProEd> batchOrtTersSiraliBatch (List<TechProEd> list)
    {
        return list.
                stream().
                sorted(Comparator.comparing(TechProEd::getBatchOrt).reversed()). //ogrcSayisi parametresine gore ters siraladi //veya
                //sorted(Comparator.comparingInt(t -> t.getBatchOrt())). // data casting yaptik
                limit(3). // akistan gelen elemanlardan ilk 3'unu alir
                collect(Collectors.toList()); // collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }

    // //task 06 : ogrc sayisi en az olan 2. batch'i  yazdiriniz.
    public static List<TechProEd> ogrSayisiEnAzIkinciBatch (List<TechProEd> list)
    {
        return list.
                stream().
                sorted(Comparator.comparing(TechProEd::getOgrcSayisi)). //ogrcSayisi parametresine gore ters siraladi //veya
                //sorted(Comparator.comparingInt(t -> t.getBatchOrt())). // data casting yaptik
                        limit(2). // akistan gelen elemanlardan ilk 2'sini alir
                        skip(1). // aldigi 2 elemandan ilkini atlar
                        collect(Collectors.toList()); // collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }

    // task 07 : batch ortalamasi 95'ten buyuk olan batch'lerin ogrenci sayilarinin toplamini yazdiriniz
    public static int ogrOrt95tenBuyukOgrSayisiTop (List<TechProEd> list)
    {
        return list.
                stream().
                filter(t -> t.getBatchOrt()>95). // 95'ten buyuk sarti saglandi
                map(t -> t.getOgrcSayisi()). // batch ortalamasi olan datalar, ogrenci sayisi olarak update edildi
                reduce(0,Integer::sum); // ogrenci sayisi toplandi
    }

    public static int ogrOrt95tenBuyukOgrSayisiTop1 (List<TechProEd> list)
    {
        return list.
                stream().
                filter(t -> t.getBatchOrt()>95). // 95'ten buyuk sarti saglandi
                mapToInt(t -> t.getOgrcSayisi()). // mapToInt() data type'a gore verilen typte'dan deger return eder
                                                  // (biz burada int secmisiz mapToDouble filan da secilebilir)
                                                  // reduce'a gerek kalmadan daha kisa ve hizli kod yazmamizi saglar
                                                  // akisi farkli bir akisa cevirir
                sum(); // bu method lambda methodudur
    }

    // task 08 : Ogrenci sayilari 130'dan buyuk olan batch'lerin batch ortalamalarinin ortalamasini bulunuz
    public static OptionalDouble ogrSayisi130danBuyukBatchOrt (List<TechProEd> list)
    {
        return list.
                stream().
                filter(t -> t.getOgrcSayisi()>130).
                mapToDouble(t -> t.getBatchOrt()).
                average();  // lambda methodudur, ortalama hesaplar
    }

    // tas 09 : gunduz batch'lerinin sayisini yazdiriniz
    public static int gunduzBatchSayisi (List<TechProEd> list)
    {
        return (int) list.stream().filter(t -> t.getBatchName().contains("gunduz")).count();
    }

    // task 10 : Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ortalamasini bulunuz
    public static OptionalInt ogrSayisi130danFazlaEnBuyukOrt (List<TechProEd> list)
    {
        return list.
                stream().
                filter(t -> t.getOgrcSayisi()>130).
                mapToInt(TechProEd::getBatchOrt).
                max(); // kendi hata verdi ve optional yapti, alttaki soruda farkli bir cozum yaptik
    }

    // task 11 : Ogrenci sayilari 150'den az olan batch'lerin en kucuk batch ortalamasini bulunuz
    public static int ogrSayisi150denAzEnKucukOrt (List<TechProEd> list)
    {
        return list.
                stream().
                filter(t -> t.getOgrcSayisi()<150).
                mapToInt(TechProEd::getBatchOrt).
                min().
                getAsInt(); // getAsInt() methodu ciktiyi integer olarak return eder ve optional' a gerek kalmaz
    }



}
