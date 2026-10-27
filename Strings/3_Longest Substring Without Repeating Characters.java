//Approach :HashSet
//TC:O(n^2)
//SC:O(n)-->due to hashset

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;

        for(int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            int count=0;
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);

                if(set.contains(ch)){
                    break; // Duplicate found
                }else{
                    set.add(ch);
                    count++;
                }
            }
            max=Math.max(max,count);
            
        }
        return max;
    }
}
