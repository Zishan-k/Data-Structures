package MethodOverloading;

public class AbstractParent {
    int i;
    AbstractParent(int i){//Used to initialize instance variable using child class.
        this.i = i;
    }

    public AbstractParent() {

    }
}

class Child extends AbstractParent{
    Child(){
        super(10);
    }
    Child child = new Child();
}
