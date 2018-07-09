A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02". 


class Solution {
    int[] hours = new int[]{1,2,4,8};
    int[] mins = new int[]{1,2,4,8,16,32};
    // List<String> res= new ArrayList<>(); 
    
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if(num> 10 || num<0) return res;
        
        for(int i=0;i<=num && i<hours.length;i++){
            List<Integer> hour = getNum(i,hours,new ArrayList<Integer>(),0,0);
            List<Integer> min = getNum(num-i,mins,new ArrayList<Integer>(),0,0) ;

            for(int x: hour){
                if(x>=12) continue;
                 for( int y : min){
                    if(y>=60) continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(x);
                    sb.append(":");
                    sb.append(y<10?"0"+y:y);
                    res.add(sb.toString());
                }
            }  
        }
        return res;     
    }
    private List<Integer> getNum(int nums, int[] arr, List<Integer> curr, int sum,int idx){
     
        if(nums==0){
            curr.add(sum);
            return curr;
        }
        for(int i=idx;i<arr.length;i++){
           getNum(nums-1,arr,curr,sum+arr[i],i+1); 
        }
        return curr;
    }
    
}