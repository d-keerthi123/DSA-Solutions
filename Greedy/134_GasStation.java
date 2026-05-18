//Approach 1:Brute Force
//Tc:O(n^2)
//SC:O(1)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int i=0;i<n;i++){

            if(gas[i]<cost[i]){
                continue; //skip that index 
            }
            int j=(i+1)%n;//for circular rotation

            int currGas=gas[i]-cost[i]+gas[j]; 

            while( j != i){
                //currGas+=gas[j];

                if(currGas < cost[j]){
                    break;
                }
                int costForMoving=cost[j]; //cost for moving from this j
                j=(j+1)%n; //move next
                int  gasEarned=gas[j]; //gas earned in next station j
                currGas = currGas- costForMoving + gasEarned;
                
            }
            if(j==i){
                return i;
            }
        }
        return -1;
    }
}

======================================================================================================================================================
//Approach 2: Greedy
//TC:O(n)
//SC:O(1)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalGas=0;
        int totalCost=0;
        

        for(int i=0;i<n;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas < totalCost){
            return -1;
        }
        int total=0;
        int result=0;
        for(int i=0;i<n;i++){
            total=total+gas[i]-cost[i];
            if(total<0){ //total can't be -ve 
                total=0;
                result=i+1;//update result
            }
        }
        return result;
    }
}
