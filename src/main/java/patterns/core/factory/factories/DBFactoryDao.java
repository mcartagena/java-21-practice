package patterns.core.factory.factories;

public class DBFactoryDao extends AbstractFactoryDao{

    @Override
    protected Dao createDao(String type) {
        Dao persistence = null;
        if(type.equals("employee")){
            persistence = new DBEmployeeDao();
        } else if (type.equals("department")) {
            persistence = new DBDepartmentDao();
        } else {
            throw new IllegalArgumentException("Type is not supported...");
        }
        return persistence;
    }
}
