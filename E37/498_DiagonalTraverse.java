public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        int c = matrix[0].length, r = matrix.length;
        int[] res = new int[r*c];
        boolean flip = true;
        int count = 0;
        for(int sum = 0; sum <= r + c - 2; sum++){
            int rr,cc;
            if(flip == true){                               // Direction: to up-right
                rr = Math.min(sum, r-1);                    // if before diagonal, rr = sum; else rr = r-1
                cc = sum - rr;
                while(rr >= 00 && cc < c)                   // reach matrix upper or right bound
                    res[count++] = matrix[rr--][cc++];
            }
            else{                                           // Direction: to bottom-left
                cc = Math.min(sum, c-1);                    // if before diagonal, cc = sum; else cc = c-1
                rr = sum - cc;
                while(cc >= 00 && rr < r)                   // reach matrix bottom or left bound
                    res[count++] = matrix[rr++][cc--];
            }
            flip = !flip;           
        }
        return res;
    }
}