package lambda_stream_funcProg.udemy;

public class Udemy02 {
    public static void main(String[] args)
    {
        new Thread(new Employee()).start();//Employee Thread is working

        new Thread(new Employee(){
            @Override
            public void run() {
                System.out.println("Anonymous Employee Thread");
            }
        }).start();//Anonymous Employee Thread

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous new Thread");
            }
        }).start();//Anonymous new Thread

        new Thread(() ->System.out.println("Thread classındaki parametresiz run methodu calıstı - lambda")).start();
        //Thread classındaki parametresiz run methodu calıstı - lambda

        //bir classtan anonymous nesne olusturdum ve içindeki 1 tane run() methodunu override ettim
        // {} -> bnun ici run() methodunun ıcı
        new Thread(() -> {
            System.out.println("1");
            System.out.println("2");
        }).start();



        //normal anonymous class
        Employee e = new Employee(){
            @Override
            public void methodEmployee(String s) {
                super.methodEmployee(s);
            }
        };

        // Thread threadd= () -> System.out.println("thread"); - error


        //bir class'ın icindeki methodu lambda ile override edemeyiz
        //bir interface'in icindeki methodu lambda ile override edebiliriz
        Runnable r =() -> System.out.println("thread");
        Thread thread = new Thread(r);
        thread.start();


    }

}
