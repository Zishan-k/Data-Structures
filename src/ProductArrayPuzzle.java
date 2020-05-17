public class ProductArrayPuzzle {

    /*
        Input: arr[]  = {10, 3, 5, 6, 2}
Output: prod[]  = {180, 600, 360, 300, 900}

Explanation: product array should be {180, 600, 360, 300, 900}
3 * 5 * 6 * 2 product of other array elements except 10 is 180
10 * 5 * 6 * 2 product of other array elements except 3 is 600
10 * 3 * 6 * 2 product of other array elements except 5 is 360
10 * 3 * 5 * 2 product of other array elements except 6 is 300
10 * 3 * 6 * 5 product of other array elements except 2 is 900


Input: arr[]  = {1, 2, 3, 4, 5}
Output: prod[]  = {120, 60, 40, 30, 24 }

Explanation: product array should be {120, 60, 40, 30, 24 }
2 * 3 * 4 * 5  product of other array elements except 1 is 120
1 * 3 * 4 * 5  product of other array elements except 2 is 60
1 * 2 * 4 * 5  product of other array elements except 3 is 40
1 * 2 * 3 * 5  product of other array elements except 4 is 30
1 * 2 * 3 * 4  product of other array elements except 5 is 24
    */
    public static void main(String[] args) {
        ProductArrayPuzzle pa = new ProductArrayPuzzle();
        int arr[] = {10, 3, 5, 6, 2};
        int n = arr.length;
        System.out.println("The product array is : ");
        pa.productArray(arr, n);
    }

    private void productArray(int[] arr, int n) {

        // Base case
        if (n == 1) {
            System.out.print("0");
            return;
        }

        int i, temp = 1;

        /* Allocate memory for the product array */
        int prod[] = new int[n];

        /* Initialize the product array as 1 */
        for (int j = 0; j < n; j++)
            prod[j] = 1;

        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
        for (i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }

        /* Initialize temp to 1 for product on right side */
        temp = 1;

        /* In this loop, temp variable contains product of
           elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }

        /* print the constructed prod array */
        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");

        return;
    }
}
