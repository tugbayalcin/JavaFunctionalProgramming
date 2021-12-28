package lambda_stream_funcProg.linkedin.streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectInJava
{
    public static void main(String[] args) {

        List<String> stringList= Arrays.asList("functional","programming","is","so","cool","!");

        List<String> toList= new ArrayList<>(stringList);
        List<String> toList2=stringList.stream().collect(Collectors.toList());
        System.out.println(toList2);
        //[functional, programming, is, so, cool, !]


        Set<String> toSet= new HashSet<>(stringList);
        Set<String> toSet2=stringList.stream().collect(Collectors.toSet());
        System.out.println(toSet2);
        //[!, functional, cool, is, so, programming]


        //joining(delimiter) combines all element of the list into A STRING
        String listToString=stringList.stream().collect(Collectors.joining("-"));
        System.out.println(listToString);
        //functional-programming-is-so-cool-!


        Long howManyLongWords= stringList.stream().filter(x -> x.length() < 5).count();
        Long howManyLongWords2= stringList.stream().filter(x-> x.length()<5).collect(Collectors.counting());
        System.out.println(howManyLongWords2);//uzunlugu 5'ten kucuk olan element sayısını return eder


        Map<Integer,List<String>> longWordsMap= stringList.
                                                        stream().
                                                        collect(Collectors.groupingBy( x-> x.length()));
        System.out.println(longWordsMap);
        //{1=[!], 2=[is, so], 4=[cool], 10=[functional], 11=[programming]}


        Map<Boolean,List<String>> wordLengthMap =stringList.
                                                stream().
                                                collect(Collectors.partitioningBy( x-> x.length()>5));
        System.out.println(wordLengthMap);
        System.out.println(wordLengthMap.size());//2
        //{false=[is, so, cool, !], true=[functional, programming]}



    }
}
