package lambda_stream_funcProg.linkedin.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercises
{
    static class Person {
        public final String name;
        public final Integer age;

        public Person(String name,Integer age){
            this.name=name;
            this.age=age;
        }
    }

    static class Car {
        public final String make;
        public final String color;
        public final Float price;

        public Car(String make,String color,Float price){
            this.make=make;
            this.color=color;
            this.price=price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "make='" + make + '\'' +
                    ", color='" + color + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

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

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person("Brandon",23),
                new Person("Hank",43),
                new Person("Jenna",33),
                new Person("Veronica",56)
        );
        //get a list contains all people's name
        List<String> nameList=personList.
                stream().
                map(person -> person.name).
                sorted(Comparator.comparing(name -> name.substring(name.length()-1))).////son harfine göre sırala
                collect(Collectors.toList());

        System.out.println(nameList);
        //[Jenna, Veronica, Hank, Brandon]



        List<Car> carList=Arrays.asList(
                new Car("Chevy","red",45000f),
                new Car("Ford","blue",23000f),
                new Car("Toyota","grey",14000f),
                new Car("Lamborghini","blue",150000f)
        );
        //get a list of all blue cars

        List<Car> blueCarList=carList.
                                stream().
                                filter(car -> car.color=="blue").
                                collect(Collectors.toList());

        System.out.println(blueCarList);//toString() methodunu override etmeseydim reference numberlar printed out olacaktı
        //[Car{make='Ford', color='blue', price=23000.0}, Car{make='Lamborghini', color='blue', price=150000.0}]


         List<Employee> employeeList=Arrays.asList(
                new Employee("Jhon",34,"developer",120000f),
                new Employee("Emre",24,"QA",122000f),
                new Employee("Matheww",50,"devops",150000f),
                new Employee("Sophie",44,"project manager",100000f)
        );
        //Find the sum of all the employees' salary over 100000f

        Float sumSalaries=employeeList.
                stream().
                map(x-> x.salary).
                distinct().
                filter(x->x>100000f).
                sorted().//sıraya dizdim
                reduce(0f,(x, y) -> x+y);

        System.out.println(sumSalaries);//392000.0






    }
}


