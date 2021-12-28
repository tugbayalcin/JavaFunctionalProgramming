package lambda_stream_funcProg.linkedin.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineListFunctions extends StreamExercises
{
    //StreamExercises Class'ının static member inner classına erişebilirim
    public static void main(String[] args)
    {
        List<Employee> employeeList= Arrays.asList(
                new Employee("Jhon",34,"developer",120000f),
                new Employee("Sarah",34,"developer",130000f),
                new Employee("Emre",24,"QA",122000f),
                new Employee("Matheww",50,"devops",150000f),
                new Employee("Sophie",44,"project manager",100000f)
        );

        Float totalDevSalary=employeeList.
                stream().
                filter(employee ->employee.jobTitle=="developer").
                map(employee -> employee.salary).reduce(0f,(x,y)->x+y);

        System.out.println(totalDevSalary);//250000.0

        long numberOfDev=employeeList.
                        stream().
                        filter(x->x.jobTitle.equalsIgnoreCase("developer")).
                        collect(Collectors.counting());

        System.out.println(numberOfDev);

        Float averageSalaryOfDevs=totalDevSalary/numberOfDev;
        System.out.println(averageSalaryOfDevs);
        //250000.0
        //2
        //125000.0

        System.out.println(
                employeeList.
                stream().
                filter(employee ->employee.jobTitle=="developer").
                map(employee -> employee.salary).reduce(0f,(x,y)->x+y)
                        /
                employeeList.
                stream().
                filter(x->x.jobTitle.equalsIgnoreCase("developer")).
                collect(Collectors.counting())
        );//125000.0




    }
}
