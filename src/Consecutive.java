import java.util.*;

public class Consecutive {
    public static void main(String[] args){
        //Scanner s=new Scanner(System.in);
        int arr[];
        arr=new int[]{11,15,20};
        int n=arr.length,i=0;
        while(i<n){
            if(arr[i+1]-arr[i] != 1) {
                System.out.println("First missing consecutive number:" + (arr[i] + 1));
                break;
            }
            i++;
        }

    }
}
