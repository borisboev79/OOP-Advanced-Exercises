package OOP.Polymorphism_Exercise.E04_Word;

public abstract class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface impl = new CommandImpl(text);
        impl.init();
        return impl;
    }
}
