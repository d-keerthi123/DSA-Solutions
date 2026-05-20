class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //base case
        if(s.length() == 0){
            return true;
        }
        for(int i=1;i<=s.length();i++){

            String firstPart=s.substring(0,i);

             // check dictionary + recursive call
            if(wordDict.contains(firstPart) &&  wordBreak(s.substring(i),wordDict)){
                return true;
            }
        }
        return false;
    }
}
