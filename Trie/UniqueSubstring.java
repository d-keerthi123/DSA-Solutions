public class UniqueSubString{
    public static class Node{
        Node[] children=new Node[26];
        boolean endOfWord=false;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root= new Node();

    public static void insert(String word) { //O(L)  L---> length of word
        Node curr=root;
        for(int level=0;level<word.length();level++){
            char ch=word.charAt(level);
            if(curr.children[ch-'a']== null){
                curr.children[ch-'a']= new Node();
            }
            curr=curr.children[ch-'a'];
        }
        curr.endOfWord = true;
    }
    
    public static  boolean search(String word) { //O(L)  L---> length of word
        Node curr=root;
        for(int level=0;level<word.length();level++){
            char ch=word.charAt(level);
            if(curr.children[ch-'a']== null){
                return false;
            }
            curr=curr.children[ch-'a']; //This line moves curr to the next node in the Trie.
        }
        return curr.endOfWord;// if eow = true --> returns true else false
    }
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static void  main (String args[]){
        String str= "ababa";
        //find all suffixes of string
        for(int i=0;i<str.length();i++){
            String suffix=str.substring(i);
            //create trie and insert
            insert(suffix);
        }
        
        //count nodes of trie
        System.out.print(countNode(root));
    }
}
