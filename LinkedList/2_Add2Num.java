//Approach :
//Add digits + carry → store last digit → forward carry → repeat

// Tc: O(max(m,n)) -->we traverse through both list once and each node exactly once
//Sc : O(1), total O(n) bcz of output list

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;

        while(l1 != null || l2 !=null ||carry!=0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            //Extract carry (tens place)
            carry=sum/10;
            //Store digit (ones place) in new node
            curr.next=new ListNode(sum%10);
            //Move curr forward
            curr=curr.next;

        }
        return dummy.next;
    }
}
