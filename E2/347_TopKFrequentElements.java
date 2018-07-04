// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
class Solution {
    //Aparently we need to loop the array at least once
    //Hence the time complexity for this problem at most is O(N)
    //The fastest way to get first k biggest value is to define an array that use its index to indicate the value and save the key into this index
    
    //ArrayList[] array = new ArrayList[length];
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> src = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num:nums){
            src.put(num,src.getOrDefault(num,0)+1);
        }
        ArrayList[] ls = new ArrayList[nums.length+1];
        for(int key:src.keySet()){
            if(ls[src.get(key)]==null){
                ls[src.get(key)] = new ArrayList<Integer>();
            }
            ls[src.get(key)].add(key);
        }
        int times = 0;
        for(int i=ls.length-1;i>0&&times<k;i--){
            if(ls[i]!=null){
                ArrayList<Integer> tgt = ls[i];
                for(int key:tgt){
                    res.add(key);
                    times++;
                }
            }
        }
        return res;
    }
}