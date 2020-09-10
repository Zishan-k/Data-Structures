package Temp;

import java.util.Arrays;

class Matrix {

    Integer[][] addMatrix(Integer[][] matrix1, Integer[][] matrix2){
        Integer[][] resultMatrix = new Integer[2][2];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }
    public static void main(String[] args){
        Matrix m= new Matrix();
        Integer[][] arr= {{1,2},{3,4}}, arr1= {{1,2},{3,4}};
        Integer[][] result= m.addMatrix(arr, arr1);
        System.out.println(Arrays.deepToString(result));
    }
}
