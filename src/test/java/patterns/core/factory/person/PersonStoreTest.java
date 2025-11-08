package patterns.core.factory.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PersonStoreTest {

    private final PersonStore personStore = new PersonStore();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void orderPerson_shouldReturnMalePerson_whenTypeIsMale() {
        // When
        Person person = personStore.orderPerson("male", "Hello!");

        // Then
        assertTrue(person instanceof Male);
        assertEquals("He says: Hello!", outputStreamCaptor.toString().trim());
        
        // Clear the output stream
        outputStreamCaptor.reset();
        
        // Test wish method directly
        person.wish("Another message");
        assertEquals("He says: Another message", outputStreamCaptor.toString().trim());
    }

    @Test
    void orderPerson_shouldReturnFemalePerson_whenTypeIsFemale() {
        // When
        Person person = personStore.orderPerson("female", "Hi there!");

        // Then
        assertTrue(person instanceof Female);
        assertEquals("She says: Hi there!", outputStreamCaptor.toString().trim());
        
        // Clear the output stream
        outputStreamCaptor.reset();
        
        // Test wish method directly
        person.wish("Welcome!");
        assertEquals("She says: Welcome!", outputStreamCaptor.toString().trim());
    }

    @Test
    void orderPerson_shouldThrowException_whenTypeIsInvalid() {
        // When/Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            personStore.orderPerson("invalid", "Hello!"));
        
        assertEquals("Unknown person type: invalid", exception.getMessage());
    }

    @Test
    void orderPerson_shouldWorkWithDifferentCasing() {
        // Testing that the type is case-insensitive
        // When
        Person person1 = personStore.orderPerson("MALE", "Test1");
        Person person2 = personStore.orderPerson("Female", "Test2");

        // Then
        assertTrue(person1 instanceof Male);
        assertTrue(person2 instanceof Female);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("He says: Test1"));
        assertTrue(output.contains("She says: Test2"));
    }
}