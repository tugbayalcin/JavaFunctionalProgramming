package lambda_stream_funcProg.linkedin.firstClassFunctions;

public class FunctionsAsData {
    public static void main(String[] args)
    {
        final Boolean IS_DEVELOPMENT=true;

        DataLoader dataLoader=new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.apply());


        //bunun lambda ile alakası yok bu ternary expression'dır
        int a= 10<11 ? 10 : 11;
        System.out.println(a);//10
    }


    protected static class Personx {
        private String name;
        private int age;

        public Personx(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    protected static class DataLoader{

        public final NoArgsFunction<Personx> loadPerson;

        public DataLoader(Boolean isDevelopment){

            //NoArgsFunction İNTERFACE'İNDEKİ Personx dataType 'ını return eden R apply() methodu override edip
            //interface NoArgsFunction<R>{
            //    R apply();
            //}
            //loadPerson'a esitle

            //1. yol
            this.loadPerson=isDevelopment ?  ()-> {
                System.out.println("Loading Real Person");
                return new Personx("Emre",24);
            } : () -> {
                System.out.println("Loading Fake Person");
                return new Personx("Emre2",19);
            };

            //2. yol
            //this.loadPerson=isDevelopment ? this::loadPersonReal : this::loadPersonFake;
            //apply() methodu gibi parameter almayan ve Personx return eden bir methodu kullanrak
            // R apply() methodunu override edebiliriz

        }
        private Personx loadPersonReal(){
            System.out.println("Loading Real Person");
            return new Personx("Emre",24);
        }

        private Personx loadPersonFake(){
            System.out.println("Loading Fake Person");
            return new Personx("Emre2",19);
        }
    }


}
