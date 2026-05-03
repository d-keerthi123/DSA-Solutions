//Approach 1: Intutive
//Tc:O(n)   
//Sc: O(n) --> bcz we are using hashmap to store the original node --> its copied node
//we are using hash map because we need a fast way to find the copied node corresponding to any original node
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node,Node> mp= new HashMap<>();
        Node curr=head; //original list
        Node prev=null;// to create a deep copy -- new list
        Node newHead=null;

        while(curr != null){
            Node temp= new Node(curr.val);

            mp.put(curr,temp);//storing

            if(newHead==null){
                newHead=temp;
                prev=newHead;
            }else{
                prev.next=temp;
                prev=temp;
            }
            curr=curr.next;
        }

        //fill random pointers
        curr=head;
        Node newCurr=newHead;
        while(curr != null){
            if(curr.random == null){
                newCurr.random=null;
            }else{
                newCurr.random=mp.get(curr.random);
            }
            curr=curr.next;
            newCurr=newCurr.next;
        }
        return newHead;
    }
}

==========================================================================================================================================================================

//Approach 2:
//SC : O(1) bcz we did not take any extra space but to create the new nodes sc is O(n)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //A->B->C original linked list
        // A->X->B->Y->Z  after adding new nodes in between

        // step 1:insert the new nodes in between the original linked list
        Node curr=head;
        while(curr != null){
            Node currNext=curr.next; // store B 1st bcz its changing
            curr.next= new Node(curr.val); //
            curr.next.next=currNext;// A->X->B

            curr=currNext; //curr=B
        }

        //step 2: deep copy of random pointers
        curr=head;
        while(curr != null && curr.next != null){
            if(curr.random == null){
                curr.next.random=null;
            }else{
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        //step 3: separate original and deep copy linked list
        curr =head;  //original
        Node newHead=head.next; // deep copy
        Node newCurr=newHead;
        while(curr != null && newCurr !=null){
            curr.next =  curr.next==null? null:curr.next.next;
            newCurr.next= newCurr.next==null? null:newCurr.next.next;

            curr=curr.next;
            newCurr=newCurr.next;
        }

        return newHead;
    }
}
