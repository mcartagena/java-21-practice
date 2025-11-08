package patterns.core.factory.person;

public class Male implements Person {
    @Override
    public void wish(String message) {
        System.out.println("He says: " + message);
    }

}
