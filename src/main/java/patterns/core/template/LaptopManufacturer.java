package patterns.core.template;

public class LaptopManufacturer extends ComputerManufacturer{
    @Override
    public void addHardDisk() {
        System.out.println("LaptopManufacturer... addHardDisk");
    }

    @Override
    public void addRAM() {
        System.out.println("LaptopManufacturer... addRAM");
    }

    @Override
    public void addKeyboard() {
        System.out.println("LaptopManufacturer... addKeyboard");

    }
}
