class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //check if 2 nodes exist(k=2)
        ListNode temp=head;
        int count=0;
        int k=2;
        while(count<k){
            if(temp==null){
                return head;
            }
            temp=temp.next;
            count++;
        }
        ListNode prev=swapPairs(temp);

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
