public class LongestWordInAllPrefix {
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
    public static String ans="";

    public static void longestWord(Node root,StringBuilder temp){
        //base case
        if(root==null){
            return ;
        }
        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].endOfWord==true){
                char ch=(char)(i+'a'); // get character
                temp.append(ch);
                if(temp.length()> ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                //backtracking
                temp.deleteCharAt(temp.length()-1);
            }
        }

    }
    public static void main(String[] args) {
        String words[]={"a","ap","app","appl","banana","apple","apply"};

        //insert all words in trie
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(" "));
        System.out.println(ans);

    }
}
