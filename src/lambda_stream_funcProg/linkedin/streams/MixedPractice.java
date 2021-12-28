package lambda_stream_funcProg.linkedin.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MixedPractice {
    public static void main(String[] args) {

        List<StreamExercises.Employee> employeeList= Arrays.asList(
                new StreamExercises.Employee("Jhon",34,"developer",120000f),
                new StreamExercises.Employee("Sarah",34,"developer",130000f),
                new StreamExercises.Employee("Emre",24,"QA",122000f),
                new StreamExercises.Employee("Matheww",50,"devops",150000f),
                new StreamExercises.Employee("Sophie",44,"devops",100000f)
        );

        //parca parca yazdırarak tüm parcayı anlamaya calsıyorum
        // data type'ı bu
        Map<String,List<StreamExercises.Employee>> map=employeeList.
                stream().
                collect(Collectors.groupingBy( emp-> emp.jobTitle));
        //[QA=[Employee{name='Emre', age=24, jobTitle='QA', salary=122000.0}], devops=[Employee{name='Matheww', age=50, jobTitle='devops', salary=150000.0}, Employee{name='Sophie', age=44, jobTitle='devops', salary=100000.0}], developer=[Employee{name='Jhon', age=34, jobTitle='developer', salary=120000.0}, Employee{name='Sarah', age=34, jobTitle='developer', salary=130000.0}]]

        Set<Map.Entry<String, List<StreamExercises.Employee>>> a=map.entrySet();
        //[QA=[Employee{name='Emre', age=24, jobTitle='QA', salary=122000.0}], devops=[Employee{name='Matheww', age=50, jobTitle='devops', salary=150000.0}, Employee{name='Sophie', age=44, jobTitle='devops', salary=100000.0}], developer=[Employee{name='Jhon', age=34, jobTitle='developer', salary=120000.0}, Employee{name='Sarah', age=34, jobTitle='developer', salary=130000.0}]]        System.out.println(a);


        Map<String,Float> averageSalariesMap=employeeList.
                stream().
                collect(Collectors.groupingBy( emp-> emp.jobTitle)).//jobTitle,List<StreamExercise.Employee> list
                //simdi elimizdeki,Map<Object, List<StreamExercises.Employee>> mapiyle  işlem yapıcaz

                entrySet().//// java.util.Set<java.util.Map.Entry<<String, List<StreamExercises.Employee>>>> entrySet()'in return ettiği type
                stream().//set'in icinde map'leri gezicez
                collect(Collectors.toMap(
                        entry-> entry.getKey(),//String degeri alıyoruz key olarak - Map.Entry::getKey olarak da yazılabilirdi
                        entry->entry.getValue().//List<StreamExercises.Employee> 'dan da float deger cıkarıcaz
                                stream().
                                map(employee -> employee.salary).//Float barındıran List oldu
                                reduce(0f,(acc,x)-> acc+x) //salary leri toplamı olan float oldu
                                / // divide by
                                entry.getValue().size()//number of employess

                ));
        System.out.println(averageSalariesMap);
        //{QA=122000.0, devops=125000.0, developer=125000.0}





    }
}
