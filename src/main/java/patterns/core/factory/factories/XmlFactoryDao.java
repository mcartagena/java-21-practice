package patterns.core.factory.factories;

public class XmlFactoryDao extends AbstractFactoryDao {
    @Override
    protected Dao createDao(String type) {
        Dao persistence = null;
        if (type.equals("employee")) {
            persistence = new XmlEmployeeDao();
        } else if (type.equals("department")) {
            persistence = new XmlDepartmentDao();
        } else {
            throw new IllegalArgumentException("Type is not supported...");
        }
        return persistence;
    }
}
