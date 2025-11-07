# java-21-practice

Example project configured for Java 21.

Includes:
- `pom.xml` (Maven) configured for Java 21.
- `src/main/java/com/example/App.java` - class with `main`.
- `src/test/java/com/example/AppTest.java` - simple test using JUnit 5.

How to build and run:

Build and package with Maven:

```bash
mvn -B clean package
```

Run the `main` class from compiled classes (without packaging):

```bash
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
java -cp out com.example.App
```

Run tests with Maven:

```bash
mvn -B test
```

If you don't have Maven installed, you can compile and run with `javac`/`java` as shown above.
