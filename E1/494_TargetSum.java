class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        HashMap<Integer, Integer> sumNum = new HashMap<>();
        sumNum.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> e: sumNum.entrySet()) {
                int prevSum = e.getKey();
                int add = prevSum + nums[i];
                int sub = prevSum - nums[i];
                next.put(add, next.getOrDefault(add, 0) + e.getValue());
                next.put(sub, next.getOrDefault(sub, 0) + e.getValue());
            }
            sumNum = next;
        }
        return sumNum.getOrDefault(S,0);
    }
}