package lambda_stream_funcProg.linkedin.AdvancedFunctionConcepts;


import lambda_stream_funcProg.linkedin.streams.StreamExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Composition
{

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary){
            this.name=name;
            this.age=age;
            this.jobTitle=jobTitle;
            this.salary=salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
    public static void main(String[] args)
    {
        List<Employee> employeeList=Arrays.asList(
                new Employee("Jhon",34,"developer",120000f),
                new Employee("Emre",24,"QA",122000f),
                new Employee("Matheww",50,"devops",150000f),
                new Employee("Sophie",44,"project manager",100000f)
        );

        Function<Integer,Integer> twoTimes= x->x*2;
        Function<Integer,Integer> minusOne= x->x-1;

        //firstly multiply by 2 + and then execute minusOne function
        Function<Integer,Integer> twoTimes_minusOne=minusOne.compose(twoTimes);
        System.out.println(twoTimes_minusOne.apply(10));//10*2 -> 20-1; =// 19

        //firstly multiply by 2 and then minusOne()
        Function<Integer,Integer> minusOne_twoTimes=twoTimes.andThen(minusOne);
        System.out.println(minusOne_twoTimes.apply(10));//10*2 -> 20-1; =// 19


        Function<Employee,String> getNames=employee -> employee.name;
        Function<String,String> reverse = str->new StringBuilder(str).reverse().toString();

        Function<String,String> uppercase = str->str.toUpperCase();
        //Function<String,String> uppercase = String::toUpperCase;

        Function<Employee,String> getReversedUppercasedNames=getNames.andThen(reverse).andThen(uppercase);

        List<String> result=employeeList.
                            stream().
                            map(getReversedUppercasedNames).
                            collect(Collectors.toList());

        System.out.println(result);
        //[NOHJ, ERME, WWEHTAM, EIHPOS]


        List<String> result2=employeeList.
                stream().
                map(employee -> employee.name).////namelerden olusan bir list olustur
                map(name->name.toUpperCase()).
                map(String::toUpperCase).
                map(str->new StringBuilder(str).reverse().toString()).//string tersten yaz
                //sorted(Comparator.comparing(t->t)).////alfabetik sırala
                //sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());
        System.out.println(result2);

    }
}
