//TC:O(N*L)
//SC:O(N*L) 
//Trie stores nodes for characters.Worst case: no common prefixes ,every character creates new node
//Total nodes: ,N * L

class Solution {
    public static class Node{
        Node[] children=new Node[26];// a-z
        boolean endOfWord=false;
        int freq;
    
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=0;
        }
    }
    

    public static Node root = new Node();

    
    public static void insert(String word) { //For every word, you traverse all characters once.So: O(N * L)
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]== null){
                curr.children[idx]= new Node();// if node doesn't exist create new node 
            }
                
            curr.children[idx].freq++; // if exists, increase freq 
            curr=curr.children[idx]; //update curr
        }
        curr.endOfWord = true;
    }
    
    
     public static String getPrefix(String word) { //O(N*L) Again, for every word you traverse characters until unique prefix found.
         
         StringBuilder sb= new StringBuilder();
         
         Node curr=root;
         
         for(int i=0;i<word.length();i++){
             int idx=word.charAt(i)-'a';
             
             sb.append(word.charAt(i));
             
             curr = curr.children[idx];
              
             if(curr.freq == 1){
                 return sb.toString();
             }
             
         }
         return word;
     }
    
    static String[] findPrefixes(String[] arr, int N) {
        root = new Node();
        
        //insert all words
        for(int i=0;i<N;i++){
            insert(arr[i]);
        }
        
        
        
        String ans[]= new String[N];
        
        for(int i=0;i<N;i++){
            ans[i]= getPrefix(arr[i]);
        }
        return ans;
    }
};
