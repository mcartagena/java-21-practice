package patterns.core.factory.factories;

public class ProductDao {
    private ProductDao(){
    }

    public static AbstractFactoryDao createFactory(String type){
        AbstractFactoryDao factory = null;
        if(type.equals("xml")){
            factory = new XmlFactoryDao();
        } else if (type.equals("db")){
            factory = new DBFactoryDao();
        } else {
            throw new IllegalArgumentException("Type is not supported!");
        }
        return factory;
    }
}
