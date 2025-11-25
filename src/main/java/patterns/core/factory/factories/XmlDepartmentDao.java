package patterns.core.factory.factories;

public class XmlDepartmentDao implements Dao{
    @Override
    public void save() {
        System.out.println("Write Department in Xml...");
    }
}
