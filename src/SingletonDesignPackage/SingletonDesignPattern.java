package SingletonDesignPackage;

public class SingletonDesignPattern {
    private static SingletonDesignPattern single = new SingletonDesignPattern();
    private SingletonDesignPattern(){

    }

    public static SingletonDesignPattern getObject(){
        return single;
    }
    public void showMessage(){
        System.out.println("This is singleton design pattern...");
    }

}
