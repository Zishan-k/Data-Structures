import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class TestClass {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,3};
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> arl = new ArrayList<>();
        for (int k : arr) {
            hm.put(k, hm.containsKey(k) ? (hm.get(k) + 1) : 1);
        }
        System.out.println(hm);

        for (int temp : hm.keySet()) {
            if (hm.get(temp) > 1) {
                arl.add(temp);
            }
        }
        System.out.println(arl);
    }
}