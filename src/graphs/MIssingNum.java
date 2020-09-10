package graphs;

class MissingNum {
    public static int Find(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length-1;i++){
            sum+=arr[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,4,5,6,7,8};
        int sum1 = 0;
        for(int i = 1;i<=arr.length;i++){
            sum1+=i;
        }
        int res=Find(arr);
        int result= sum1 - res;
        System.out.println(result);
    }
}
