package Temp;

class Shape {
    int x,y;
    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void printShape(){
        System.out.println("Superclass");
    }
}

class Rectangle extends Shape{
    private int x = 10,y = 20;
    public Rectangle(int x, int y){
        super(x, y);
    }

    public void getX() {
        System.out.println(super.x);
        System.out.println(this.x);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(33, 44);
        r.printShape();
    }
}
