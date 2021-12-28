package lambda_stream_funcProg.techproed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class LambdaForFile {
    public static void main(String[] args) throws IOException {

        //How to read a file by using lambda
        Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))
                .forEach(t->System.out.println(t));
        //Java is easy, lambda is easier.
        //If you learn lambda, coding will take less time.
        //Lambda is the last subject in our course.
        //Is the number correct.

        //Convert all characters to upper case then read it
        Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))
                .map(t->t.toUpperCase())
                .forEach(t->System.out.println(t));

        //Check if the text contain the word "Lambda"
        boolean result = Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))
                .anyMatch(t->t.equalsIgnoreCase("Lambda"));
        System.out.println(result);//true - lambda

        //Print all distinct words in the text on the console.
        Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))
                .map(t->t.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        System.out.println("===============");

        //Print all words which contains "e" in the text on the console.
        Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))
                .map(t->t.split(" "))
                .flatMap(Arrays::stream)
                .map(t->t.replace(",", ""))
                .map(t->t.replace(".", ""))
                .filter(t->t.contains("e"))
                .distinct()
                .forEach(System.out::println);

        //Print the number of letters in the text (Learn, Java. ==> 9)
        int numberOfLetters = Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))

                .map(t->t.split(" "))

                .flatMap(Arrays::stream)

                .map(t->t.replace("[,]", ""))

                .map(t->t.replace(".", ""))

                .map(t->t.replace(" ", ""))

                .map(t->t.length())

                .reduce(0, (t,u) -> t+u);
        System.out.println(numberOfLetters);//113

        //Print the distinct words which are ending with a
        Files.lines(Paths.get("src/lambda_stream_funcProg/techproed/TextFile"))
                .map(t->t.split(" "))
                .flatMap(Arrays::stream)
                .map(t->t.replace("[^a-zA-Z]", ""))
                .filter(t->t.endsWith("a"))
                .forEach(t->System.out.print(t+" "));//Java lambda Lambda

    }

}
