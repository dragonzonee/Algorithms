public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuffer sb = new StringBuffer(Integer.toBinaryString(n));
        while (sb.length() < 32) {
            sb.insert(0, 0);
        }
        sb.reverse();
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
    
    // public int reverseBits(int n) {
    //     int result = 0;
    //     for (int i = 0; i < 32; i++) {
    //         result += n & 1;
    //         n >>>= 1;   // CATCH: must do unsigned shift
    //         if (i < 31) // CATCH: for last digit, don't shift!
    //             result <<= 1;
    //     }
    //     return result;
    // }
}