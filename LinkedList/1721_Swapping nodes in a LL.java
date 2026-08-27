class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        // Find kth node from beginning
        ListNode left=head;
        for(int i=1;i<k;i++){
            left=left.next;
        }
        // Find kth node from end
        ListNode right=head;
        int r=size-k+1;
        for(int i=1;i<r;i++){
            right=right.next;
        }
        //swap
        int t=left.val;
        left.val=right.val;
        right.val=t;


        return head;
    }
}
