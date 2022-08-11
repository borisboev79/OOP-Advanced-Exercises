package OOP.InterfacesAndAbstraction_Lab.L04_SayHelloExtended;

public class European extends BasePerson {

    European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

}
