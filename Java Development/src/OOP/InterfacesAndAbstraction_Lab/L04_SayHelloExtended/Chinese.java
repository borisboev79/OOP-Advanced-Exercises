package OOP.InterfacesAndAbstraction_Lab.L04_SayHelloExtended;

public class Chinese extends BasePerson {

    Chinese(String name){
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }

}
