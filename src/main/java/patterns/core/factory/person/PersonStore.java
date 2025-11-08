package patterns.core.factory.person;

public class PersonStore {
    public Person orderPerson(String type, String message) {
        Person person = PersonFactory.createPerson(type);
        person.wish(message);
        return person;
    }
}
