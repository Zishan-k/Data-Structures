package FactoryDesignPattern;

public class IOS implements OS{
    @Override
    public void getSpecification() {
        System.out.println("IOS is most secure Operating System");
    }
}
