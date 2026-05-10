//Approach 1: Recursive 
//TC: O(n) Each node is visited once (reversing + recursion traversal)
//SC: O(n) bcz of the call stack in the worst case scenario

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if( head.next == null){
            return head;
        }
        //check if k nodes exist
        ListNode temp=head;
        int count=0;
        while(count <k){
            if(temp == null){
                return head;
            }
            temp=temp.next;
            count++;
        }
        
        ListNode prev=reverseKGroup(temp,k);

        temp=head;
        count=0;
        while(count <k){
            ListNode next=temp.next;
            temp.next=prev;
            //update
            prev=temp;
            temp=next;

            count++;
        }

        return prev;
    }
}

===============================================================================================================================================================
//Approach 2: Iterative
//Sc:O(1) 

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null|| k==1){
            return head;
        }
        //we will make dummy bcz in the end head will change 
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prevGroupEnd=dummy;
        
        while(true){

            //Find Kth node
            ListNode kth=prevGroupEnd;
            for(int i=0;i<k;i++){
                kth=kth.next; // check if valid k nodes exist
                if(kth== null){ // if not ,then stop 
                    return dummy.next;
                }
            }
            
        
        // mark boundaries
        ListNode groupStart=prevGroupEnd.next;
        ListNode nextGroupStart=kth.next;

        //Reverse
        ListNode prev=nextGroupStart;//While reversing, attach tail of reversed group to next group automatically.
            //[1 2 3] -> 4  before reversing
            //3 -> 2 -> 1 -> 4 after reversing  
        ListNode curr=groupStart;

        while(curr != nextGroupStart){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //Connect
        prevGroupEnd.next=kth;
        prevGroupEnd=groupStart;
        }
    }
}


    

