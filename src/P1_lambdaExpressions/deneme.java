package P1_lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class deneme
{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55)); // list olusturduk
        yapisalCiftEleman(list);
        System.out.println();
        fonksiyonelCiftEleman(list);
        System.out.println();


    }
    // Bir listeyi parametre olarak alan ve listedeki cift elemanlari yan yana yazdiran methodu yapisal(structered) olarak create ediniz
    public static void yapisalCiftEleman(List<Integer> list)
    {
        for (Integer each:list)
        {
            if(each%2==0)
                System.out.print(each + " ");

        }
    }

    // Bir listeyi parametre olarak alan ve listedeki cift elemanlari yan yana yazdiran methodu fonksiyonel(functional) olarak create ediniz
    public static void fonksiyonelCiftEleman(List<Integer> list)
    {
        list.stream().filter(t -> t%2==0).forEach(t -> System.out.print(t + " "));
    }
}
