package BackTracking;
public class RectangleOverlap {
    public static void main(String[] args) {
        Point l1 = new Point(-1, 0),
                r1 = new Point(1, 1),
                l2 = new Point(0, -1),
                r2 = new Point(0, 1);
        System.out.println(doRectanglesOverlap(l1, r1, l2, r2));
    }

    private static boolean doRectanglesOverlap(Point l1, Point r1, Point l2, Point r2) {
        if(r1.x < l2.x || r2.x < l1.x ) return false;
        if(r1.y > l2.y || r2.y > l1.y) return false;

        return true;
    }

}
