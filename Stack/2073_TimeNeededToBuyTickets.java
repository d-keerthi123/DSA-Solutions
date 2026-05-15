//SC:O(n) queue stores atmost n people
//TC:O(sum of all tickets)
//because every ticket purchase is one iteration of the while loop  and each iteration does constant work O(1)
//total iterations = total tickets purchased.

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        class pair{
            int index;
            int remTickets;

            pair(int index,int remTickets){
                this.index=index;
                this.remTickets=remTickets;
            }
        }
        Queue<pair> q= new LinkedList<>();

         int time=0; //initially
        for(int i=0;i<tickets.length;i++){
            q.add(new pair(i,tickets[i]));
        }
            while(!q.isEmpty()){
               pair front=q.peek();
               q.remove();
               front.remTickets--;
               time++;

                if(front.remTickets!=0){
                    q.add(new pair(front.index,front.remTickets));
                }
                if(front.index==k && front.remTickets==0){
                    return time;
                }
            }
        return -1;
    }
}
