package lambda_stream_funcProg.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Udemy03 {

    public static void main(String[] args) {

        Employee e1 = new Employee("Emre", 24);
        Employee e2 = new Employee("Tuba", 25);
        Employee e3 = new Employee("Emine", 23);

        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);

        Collections.sort(empList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        System.out.println(empList);
        //[Employee{name='Emine', age=23}, Employee{name='Emre', age=23}, Employee{name='Tuba', age=25}]


        //int compare(T o1, T o2);

        Collections.sort(empList,(Employee o1, Employee o2) -> o1.getAge() > o2.getAge() ? 1 : -1);
        System.out.println(empList);
        //[Employee{name='Emine', age=23}, Employee{name='Emre', age=24}, Employee{name='Tuba', age=25}]

        empList.sort((Employee o1, Employee o2) -> o1.getAge() > o2.getAge() ? -1 : 1);//buyukse sola kucukse saga yazdır
        System.out.println(empList);
        //[Employee{name='Tuba', age=25}, Employee{name='Emre', age=24}, Employee{name='Emine', age=23}]
    }
}
