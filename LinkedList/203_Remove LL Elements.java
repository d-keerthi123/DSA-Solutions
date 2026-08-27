class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        //Handle all nodes at the beginning that match val first.
        while(head !=null && head.val==val){
            head=head.next;
        }

        //Now head is guaranteed to either be null or have a value different from val.
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.next.val== val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }
}
