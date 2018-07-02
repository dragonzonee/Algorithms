//simple dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0||wordDict.size()==0) return false;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(res[j]&&wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}