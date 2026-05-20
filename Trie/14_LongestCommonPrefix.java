class Solution {
    public static class Node{
        Node[] children = new Node[26];
        boolean eow=false;
        int freq;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=0;
        }
    }
    public static Node root= new Node();

    public static void insert (String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            char ch=word.charAt(level);
            if(curr.children[ch-'a']== null){
                curr.children[ch-'a']= new Node();
            }
            curr.children[ch-'a'].freq++;
            curr=curr.children[ch-'a'];
        }
        curr.eow = true;
    }

     public static String getPrefix(String word,int N) { 
         
         StringBuilder sb= new StringBuilder();
         
         Node curr=root;
         
         for(int i=0;i<word.length();i++){
             int idx=word.charAt(i)-'a';
             
             
             
             curr = curr.children[idx];
              
             if(curr.freq == N){
                 sb.append(word.charAt(i));
             }else{
                break;
             }
         }
          return sb.toString();
     }

    public String longestCommonPrefix(String[] strs) {
        root= new Node();
        int N=strs.length;

        //insert all words
        for(int i=0;i<strs.length;i++){
            insert(strs[i]);
        }
        return getPrefix(strs[0],N);
    }
}
