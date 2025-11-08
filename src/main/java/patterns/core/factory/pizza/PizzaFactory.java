package patterns.core.factory.pizza;

public class PizzaFactory {
    public static Pizza createPizza(String type) {
        Pizza pizza;
        switch (type.toLowerCase()) {
            case "cheese" -> pizza = new CheesePizza();
            case "veggie" -> pizza = new VeggiePizza();
            case "chicken" -> pizza = new ChickenPizza();
            default -> throw new IllegalArgumentException("Unknown pizza type: " + type);
        }

        return pizza;
    }
}
