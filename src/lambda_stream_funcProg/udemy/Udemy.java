package lambda_stream_funcProg.udemy;

import java.util.ArrayList;

public class Udemy
{
    public static void main(String[] args) {
        Employee e1 = new Employee("Emre", 23);
        Employee e2 = new Employee("Tuba", 25);
        Employee e3 = new Employee("Emine", 23);

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        for (Employee e : empList) {
            infos(new Print() {//interface'in icine erisip methodu override eiyoruz
                @Override
                public void printInfos() {
                    System.out.println(e);
                }
            });
        }

        //Employee{name='Emre', age=23}
        //Employee{name='Tuba', age=25}
        //Employee{name='Emine', age=23}

        for (Employee e : empList) {
            infos(() -> System.out.println(e));//printInfos()'u override ediyoruz
        }


    }


    public static void infos(Print print){
        print.printInfos();
    }


}
