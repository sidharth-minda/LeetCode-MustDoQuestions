import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

    public int minFallingPathSum(int[][] A) {

        int rows = A.length;
        int cols = A[0].length;
        for(int i=1;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                int min = A[i-1][j];
                if(j!=0)
                    min = Math.min(min, A[i-1][j-1]);
                if(j!=cols-1)
                    min = Math.min(min, A[i-1][j+1]);
                A[i][j] += min;
            }
        }
        return Arrays.stream(A[rows-1]).min().getAsInt();
    }
}
