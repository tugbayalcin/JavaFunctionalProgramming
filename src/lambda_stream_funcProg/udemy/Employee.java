package lambda_stream_funcProg.udemy;

class Employee implements Runnable {
    private String name;
    private int age;

    public Employee() {

    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void run() {
        System.out.println("Employee Thread is working");
    }

    public void methodEmployee(String s) {
        System.out.println(s);
    }
}
