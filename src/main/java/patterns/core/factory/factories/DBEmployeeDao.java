package patterns.core.factory.factories;

public class DBEmployeeDao implements Dao{
    @Override
    public void save() {
        System.out.println("Write Employee in DB...");
    }
}
