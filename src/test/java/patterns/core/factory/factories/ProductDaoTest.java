package patterns.core.factory.factories;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {
    @Test
    void writeEmployeeInXml() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        System.setOut(new PrintStream(baos));
        try {
            AbstractFactoryDao factory = ProductDao.createFactory("xml");
            Dao employee = factory.createDao("employee");
            employee.save();
        } finally {
            System.setOut(previous);
        }
        String out = baos.toString();
        assertTrue(out.contains("Write Employee in Xml"), "The output should contain the logged message");
    }
    @Test
    void  writeDepartmentInXml(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        System.setOut(new PrintStream(baos));
        try{
            AbstractFactoryDao factory = ProductDao.createFactory("xml");
            Dao department = factory.createDao("department");
            department.save();
        } finally {
            System.setOut(previous);
        }
        String out = baos.toString();
        assertTrue(out.contains("Write Department in Xml"), "The output should contain the logged message");
    }
    @Test
    void writeEmployeeInDb() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        System.setOut(new PrintStream(baos));
        try {
            AbstractFactoryDao factory = ProductDao.createFactory("db");
            Dao employee = factory.createDao("employee");
            employee.save();
        } finally {
            System.setOut(previous);
        }
        String out = baos.toString();
        assertTrue(out.contains("Write Employee in DB"), "The output should contain the logged message");
    }
    @Test
    void  writeDepartmentInDb(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        System.setOut(new PrintStream(baos));
        try{
            AbstractFactoryDao factory = ProductDao.createFactory("db");
            Dao department = factory.createDao("department");
            department.save();
        } finally {
            System.setOut(previous);
        }
        String out = baos.toString();
        assertTrue(out.contains("Write Department in DB"), "The output should contain the logged message");
    }
    @Test
    void shoultThrowExceptionWhenFactory(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            AbstractFactoryDao factory = ProductDao.createFactory("notSupported");
        });
        assertTrue(ex.getMessage().contains("Type is not supported"));
    }
    @Test
    void shoultThrowExceptionWhenXmlDao(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            AbstractFactoryDao factory = ProductDao.createFactory("xml");
            Dao notSupported = factory.createDao("notSupported");
        });
        assertTrue(ex.getMessage().contains("Type is not supported"));
    }
    @Test
    void shoultThrowExceptionWhenDbDao(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            AbstractFactoryDao factory = ProductDao.createFactory("db");
            Dao notSupported = factory.createDao("notSupported");
        });
        assertTrue(ex.getMessage().contains("Type is not supported"));
    }
}