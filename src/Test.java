public class Test {


static void m() { throw new Error();
}static void m(int i) {

}
    public static void main(String args[]){
      try {

          m();
          System.out.println("A");
      } catch (Exception e) {
          System.out.println("B");

      }finally {
          System.out.println("C");
      }
        System.out.println("D");
    }
}
