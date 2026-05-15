//TC:O(n)
//Sc:O(n) due to queue 
class Solution {
    public int firstUniqChar(String s) {
        Queue<Integer>q= new LinkedList<>();
        int freq[]=new int[26]; // a-z  O(1) -->fixed size

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            q.add(i); //store index
            freq[ch-'a']++; //increase the freq

            while(!q.isEmpty() && freq[s.charAt(q.peek())-'a']>1){
                q.remove(); //remove repeating character index
            }
        }
        if(q.isEmpty()){
            return -1; //No non-repeating letter
            }
        return q.peek();
    }
}
