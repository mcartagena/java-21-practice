package patterns.core.factory.person;

public class Female implements Person {
    @Override
    public void wish(String message) {
        System.out.println("She says: " + message);
    }

}
