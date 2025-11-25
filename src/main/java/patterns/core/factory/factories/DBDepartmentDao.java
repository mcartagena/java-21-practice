package patterns.core.factory.factories;

public class DBDepartmentDao implements Dao{
    @Override
    public void save() {
        System.out.println("Write Department in DB...");
    }
}
