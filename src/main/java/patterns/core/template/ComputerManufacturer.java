package patterns.core.template;

public abstract class ComputerManufacturer {
    public void buildComputer(){
        System.out.println("ComputerManufacturer... buildComputer");
        addHardDisk();
        addRAM();
        addKeyboard();
    }

    public abstract void addHardDisk();
    public abstract void addRAM();
    public abstract void addKeyboard();
}
