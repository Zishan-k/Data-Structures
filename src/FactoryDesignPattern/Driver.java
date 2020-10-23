package FactoryDesignPattern;

public class Driver {
    public static void main(String[] args) {
        FactoryImplementation f = new FactoryImplementation();
        OS os = f.getInstance("famous");
        os.getSpecification();
    }
}
