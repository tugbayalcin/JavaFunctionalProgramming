package lambda_stream_funcProg.linkedin.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ParallelStreams {
    public static void main(String[] args) {

        //stream()-serial stream - processes one after the other in order
        //parallelStream()- parallel stream -processes in parallel instead of sequentially
        // java seperate data and process each of it concurrently on seperate threads
        // - boost performance by using multiple threads
        List<String> stringList=Arrays.asList("functional","programming","is","so","cool");

        List<String> processWords=stringList.
                                  parallelStream().
                                  map(word->{
                                                System.out.println("Uppercasing "+word);
                                                return word.toUpperCase();
                                            }).
                                  map(word->{
                                              System.out.println("Adding exlamation point to "+word);
                                              return word+"!";
                                            }).
                                  collect(Collectors.toList());
        /*
        //Uppercasing is
        //Adding exlamation point to IS
        //Uppercasing cool
        //Adding exlamation point to COOL
        //Uppercasing so
        //Adding exlamation point to SO
        //Uppercasing programming
        //Adding exlamation point to PROGRAMMING
        //Uppercasing functional
        //Adding exlamation point to FUNCTIONAL
         */

       System.out.println(processWords);
        //[FUNCTIONAL!, PROGRAMMING!, IS!, SO!, COOL!]




    }
}
