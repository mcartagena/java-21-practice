package patterns.core.factory.factories;

public class XmlEmployeeDao implements Dao{
    @Override
    public void save() {
        System.out.println("Write Employee in Xml...");
    }
}
