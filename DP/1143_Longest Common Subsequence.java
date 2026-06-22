//Approach 1: Recursive
//Tc:O(2^(n+m))

class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        return longestCommonSubsequenceH(text1,text2,n,m);
    }
    public int longestCommonSubsequenceH(String text1, String text2,int n,int m) {
        //base case
        if(n==0 || m==0){
            return 0;
        }

        //case 1: if the last character is the same
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return longestCommonSubsequenceH(text1,text2,n-1,m-1)+1;
        }
        else{
            //case 2:last character is different 
            int ans1=longestCommonSubsequenceH(text1,text2,n-1,m);
            int ans2=longestCommonSubsequenceH(text1,text2,n,m-1);
            return Math.max(ans1,ans2);
        }

    }
}
