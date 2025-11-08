package patterns.core.factory.pizza;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PizzaStoreTest {

    private final PizzaStore pizzaStore = new PizzaStore();
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
    void orderPizza_shouldReturnCheesePizza_whenTypeIsCheese() {
        // When
        Pizza pizza = pizzaStore.orderPizza("cheese");

        // Then
        assertTrue(pizza instanceof CheesePizza);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Preparing Cheese Pizza"));
        assertTrue(output.contains("Baking Cheese Pizza"));
        assertTrue(output.contains("Cutting Cheese Pizza"));
        assertTrue(output.contains("Boxing Cheese Pizza"));
    }

    @Test
    void orderPizza_shouldReturnVeggiePizza_whenTypeIsVeggie() {
        // When
        Pizza pizza = pizzaStore.orderPizza("veggie");

        // Then
        assertTrue(pizza instanceof VeggiePizza);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Preparing Veggie Pizza"));
        assertTrue(output.contains("Baking Veggie Pizza"));
        assertTrue(output.contains("Cutting Veggie Pizza"));
        assertTrue(output.contains("Boxing Veggie Pizza"));
    }

    @Test
    void orderPizza_shouldReturnChickenPizza_whenTypeIsChicken() {
        // When
        Pizza pizza = pizzaStore.orderPizza("chicken");

        // Then
        assertTrue(pizza instanceof ChickenPizza);
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Preparing Chicken Pizza"));
        assertTrue(output.contains("Baking Chicken Pizza"));        
        assertTrue(output.contains("Cutting Chicken Pizza"));
        assertTrue(output.contains("Boxing Chicken Pizza"));
    }

    @Test
    void orderPizza_shouldThrowException_whenTypeIsInvalid() {
        // When/Then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            pizzaStore.orderPizza("invalid"));
        
        assertEquals("Unknown pizza type: invalid", exception.getMessage());
        String output = outputStreamCaptor.toString();
        assertEquals("", output); // No output should be produced
    }
}