class Solution {
    //why this solution is not right?
    // public boolean judgeCircle(String moves) {
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(int i=0;i<moves.length();i++){
    //         if(!map.containsKey(moves.charAt(i))) map.put(moves.charAt(i),1);
    //         else map.put(moves.charAt(i),map.get(moves.charAt(i))+1);
    //     }
    //     return (map.get('L')==map.get('R')&&map.get('U')==map.get('D'));
    // }
    
    public boolean judgeCircle(String moves){
        int h = 0;
        int s = 0;//shuiping
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L') s++;
            if(moves.charAt(i)=='R') s--;
            if(moves.charAt(i)=='U') h++;
            if(moves.charAt(i)=='D') h--;
        }
        return (s==0&&h==0);
    }
}