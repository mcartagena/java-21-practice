package patterns.core.factory.factories;

public abstract class AbstractFactoryDao {
    protected abstract Dao createDao(String type);
}
