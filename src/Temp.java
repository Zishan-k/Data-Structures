import MethodOverloading.Animal;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Temp{

    private int n;
    public int getN(int n) {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }

    Temp(){
        this(5);
    }
    Temp(int n) {
        System.out.println("int constructor called");
        this.n = n;
    }

    Temp(long n){
        System.out.println("double constructor called");
        this.n = (int)n;
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
    }
}


