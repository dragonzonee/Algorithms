class Solution {
    //1234 -- 1243
    //4321 -- -1
    //descending number is not valid
    //173952 -- 175932 when we find a none descending number, we need to find the smallest number that bigger than this number
    //we could use a stack to save all numbers, and pop one by one from smaller one
    //corner case of 0
    //1080
    public int nextGreaterElement(int n) {
        LinkedList<Character> queue = new LinkedList<>();
        char[] src = String.valueOf(n).toCharArray();
        int tgtIdx = -1;
        char prev = '1';
        for(int i=src.length-1;i>=0;i--){
            if(queue.isEmpty()||(src[i]-'0')>=(prev-'0')) queue.offer(src[i]);
            else {
                tgtIdx = i;
                break;
            }
            prev = src[i];
        }
        if(tgtIdx==-1) return -1;
        char[] tail = new char[queue.size()];
        int idx = 0;
        int candiIdx = src.length-1;
        while(!queue.isEmpty()){
            char candi = queue.poll();
            tail[idx++] = candi;
            if((candi-'0') > (src[tgtIdx]-'0')){
                char tem = src[tgtIdx];
                src[tgtIdx] = candi;
                src[candiIdx] = tem;
                tail[idx-1] = tem;
                while(!queue.isEmpty()){
                    tem = queue.poll();
                    tail[idx++] = tem;
                }
                //System.out.println(String.valueOf(src).substring(0,tgtIdx+1));
                //System.out.println(String.valueOf(tail));
                long res = Long.parseLong(String.valueOf(src).substring(0,tgtIdx+1)+String.valueOf(tail));
                if(res>Integer.MAX_VALUE) return -1;
                return (int)res;
            }
            candiIdx--;
        }
        return -1;
    }
}