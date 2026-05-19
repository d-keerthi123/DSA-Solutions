public class Node{
        Node children[]=new Node[26];
        boolean endOfWord=false;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

class Trie {
    Node root;
    public Trie() {
        root= new Node();
    }
    
    public void insert(String word) { //O(L)  L---> length of word
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
    
    public boolean search(String word) { //O(L)  L---> length of word
        Node curr=root;
        for(int level=0;level<word.length();level++){
            char ch=word.charAt(level);
            if(curr.children[ch-'a']== null){
                return false;
            }
            curr=curr.children[ch-'a'];
        }
        return curr.endOfWord;// if eow = true --> returns true else false
    }
    
    public boolean startsWith(String prefix) { //O(L)  L---> length of prefix
         Node curr=root;
        for(int level=0;level<prefix.length();level++){
            char ch=prefix.charAt(level);
            if(curr.children[ch-'a']== null){
                return false;
            }
            curr=curr.children[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
