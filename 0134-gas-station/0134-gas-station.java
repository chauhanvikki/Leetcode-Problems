class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        for(int i=0;i<cost.length;i++){
            totalCost+=cost[i];
            totalGas+=gas[i];
        }
        if(totalCost>totalGas)return -1;
        int starting=-1;
        int tank=0;
        for(int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                tank=0;
                starting=-1;
                continue;
            }
            else if(starting==-1){
                starting=i;
            }
        }
        return starting;
    }
}