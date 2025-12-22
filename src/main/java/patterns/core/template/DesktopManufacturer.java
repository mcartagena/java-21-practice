package patterns.core.template;

public class DesktopManufacturer extends ComputerManufacturer{
    @Override
    public void addHardDisk() {
        System.out.println("DesktopManufacturer... addHardDisk");
    }

    @Override
    public void addRAM() {
        System.out.println("DesktopManufacturer... addRAM");
    }

    @Override
    public void addKeyboard() {
        System.out.println("DesktopManufacturer... addKeyboard");

    }
}
