package lambda_stream_funcProg.udemy;

import java.util.Arrays;
import java.util.List;

public class Udemy04 {
    public static void main(String[] args) {

        String word="Emre Duman QA Automation Developer";

        new Thread(new Runnable() {
            @Override
            public void run() {
                String [] words=word.split(" ");
                List<String> wordList= Arrays.asList(words);

                wordList.forEach(System.out::println);
            }
        }).start();
        //Emre
        //Duman
        //QA
        //Automation
        //Developer

       new Thread(() -> {//run() methodunu override ediyorum
           Arrays.asList(word.split(" ")).forEach(System.out::println);
       }).start();
       //Emre
        //Duman
        //QA
        //Automation
        //Developer
    }


}
