package lambda_stream_funcProg.tayfateam;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaWithInt {

    public static void main(String[] args) {

        List<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);
        list01.add(3);
        list01.add(4);
        list01.add(5);

        printEvenElements1(list01); //2 4
        printEvenElements2(list01); //2 4
        printEvenElements3(list01);//24
        printEvenElements4(list01);//2 4

        printSquareOfOddElements1(list01);//1925
        printSquareOfOddElements2(list01);//1 9 25
        printSquareOfOddElements3(list01);//1 9 25

        System.out.println(printSumOfSquareOfOddElements1(list01));//35
        System.out.println(printSumOfSquareOfOddElements2(list01));//Optional[35]
        System.out.println(printSumOfSquareOfOddElements3(list01));//Optional[35]

        System.out.println(getMaxElement(list01));//Optional[5]
        System.out.println(getMinElement(list01));//Optional[5]
        System.out.println(getMinElement2(list01));//Optional[1]
        System.out.println();
    }

    /*
    1)Use "Structured Programming"
          Create a method to print the even list elements on the console in the same line
          with a space between two consecutive elements.
     */
    public static void printEvenElements1(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
    }


    /*
    Use “Functional Programming”
    	Create a method to print the even list elements on the console in the same line
   	with a space between two consecutive elements.
     */
    //1st Way: By using lambda expression
    public static void printEvenElements2(List<Integer> list) {
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
        //stream() list'deki objectleri alt alta yazdırır
        //t sembolize object
        //if the inside of the filter is true object will be put another list
        //foreach(), filter()'ın olusturduğu listi yazdırır
        System.out.println();
    }


    //2nd Way: By using Method Reference, use Java methods
    //method reference==> ClassName :: methodName
    public static void printEvenElements3(List<Integer> list) {
        list.stream().filter(t -> t % 2 == 0).forEach(System.out::print);
        //System.out'ı class print'i method olarak düsün
        System.out.println();
    }

    //3rd Way: By using Method Reference, use your own methods
    public static void printEvenElements4(List<Integer> list) {
        list.stream().filter(LambdaWithInt::getEven).forEach(LambdaWithInt::getPrint);
        System.out.println();
    }



    /*
    Use “Functional Programming”
	 2)Create a method to print the squares of every odd element
	   on the console in the same line with a space between two consecutive elements.
     */
    public static void printSquareOfOddElements1(List<Integer> list) {
        list.stream().filter(t->t%2==1).map(t->t*t).forEach(t-> System.out.print(t));
        System.out.println();
        //map() elementi update lemek icin kullanılır
    }

    public static void printSquareOfOddElements2(List<Integer> list) {
        list.stream().filter(LambdaWithInt::getOdd).forEach(LambdaWithInt::getSquare);
        System.out.println();
    }

    public static void printSquareOfOddElements3(List<Integer> list) {
        list.stream().filter(LambdaWithInt::getOdd).map(LambdaWithInt::getSquare2).forEach(LambdaWithInt::getPrint);
        System.out.println();
    }


    public static int printSumOfSquareOfOddElements1(List<Integer> list) {
        return list.
                stream().
                filter(LambdaWithInt::getOdd).
                map(LambdaWithInt::getSquare2).
                reduce(0,(x,y)->x+y);
        //x:0 y:1  x+y:1
        //x:1 y:9  x+y:10
        //x:10 y:25 X
        //x:35
    }

    public static Optional printSumOfSquareOfOddElements2(List<Integer> list) {
        return list.
            stream().
                filter(LambdaWithInt::getOdd).
                    map(LambdaWithInt::getSquare2).
                        reduce(Math::addExact);
        //public static int addExact(int x,int y)
        //Returns the sum of its arguments, throwing an exception if the result overflows an int.
    }

    public static Optional printSumOfSquareOfOddElements3(List<Integer> list) {
        return list.
                stream().
                filter(LambdaWithInt::getOdd).
                map(LambdaWithInt::getSquare2).
                reduce(Integer::sum);
        //public static int sum(int a,int b)
        //Adds two integers together as per the + operator.
    }

    public static Optional maxValueOfList(List<Integer> list) {
        return list.
                stream().
                reduce((x,y)->x>y ? x : y);//ternary

        //reduce(Integer::max);
            //public static int sum(int a,int b)
            //Adds two integers together as per the + operator.

        //reduce(Math::max);
            //public static int max(int a,int b)
            //Returns the greater of two int values.
            // That is, the result is the argument closer to the
    }

    public static Optional<Integer> getMaxElement(List<Integer> list) {
        return list.stream().sorted().reduce((x,y)->y);
    }


    public static Optional<Integer> getMinElement(List<Integer> list) {
        return list.stream().sorted().reduce((x,y)->y);
    }

    public static Optional<Integer> getMinElement2(List<Integer> list) {
        return list.stream().sorted().findFirst();
    }

    //Use “Functional Programming”
    //	6)Create a method to print the squares of even list elements in reverse order.
    //	   Print the repeated elements just once.
    public static List<Integer> getEvenSquaresRevSorted1(List<Integer> list) {
        return list.
                stream().
                filter(LambdaWithInt::getEven).
                distinct().
                map(LambdaWithInt::getSquare2).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
    }




    public static boolean getEven(int a) {
        return a%2==0;
    }
    public static void getPrint(int a) {
        System.out.print(a+" ");
    }

    public static boolean getOdd(int a) {
        return a%2==1;
    }
    public static void getSquare(int a) {
        System.out.print( a*a + " ");
    }
    public static int getSquare2(int a) {
        return a*a;
    }


}