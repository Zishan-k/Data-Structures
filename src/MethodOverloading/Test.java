package MethodOverloading;

public class Test {
    public void m1(Animal a) {
        System.out.println("Animal version");
    }

    public void m1(Dog d) {
        System.out.println("Dog version");
    }

    public static void main(String[] args) throws InterruptedException {
        /*Test t = new Test();
        Animal animal = new Animal();
        Dog dog = new Dog();*/
        //System.out.println(Thread.currentThread().getName());
        //t.m1(new Dog());
        MyThread mt = new MyThread();
        mt.start();
        mt.join(5000); // main thread waiting for mt thread to complete its execution
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread");
        }
    }
}
