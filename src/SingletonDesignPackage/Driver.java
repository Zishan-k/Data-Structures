package SingletonDesignPackage;

public class Driver {
    public static void main(String[] args) {
        SingletonDesignPattern sin = SingletonDesignPattern.getObject();
        sin.showMessage();
    }
}
