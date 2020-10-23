package FactoryDesignPattern;

public class Windows implements OS{
    @Override
    public void getSpecification() {
        System.out.println("Windows is Neutral Operating System");

    }
}
