package patterns.core.factory.pizza;

public class ChickenPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Chicken Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Chicken Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Chicken Pizza");
    }

}
