package patterns.core.factory.person;

public class PersonFactory {
    public static Person createPerson(String type) {
        return switch (type.toLowerCase()) {
            case "male" -> new Male();
            case "female" -> new Female();
            default -> throw new IllegalArgumentException("Unknown person type: " + type);
        };
    }
}
