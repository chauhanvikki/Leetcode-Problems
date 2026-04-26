class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalCost>totalGas)return -1;
        int starting=0;
        int currentGas=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            currentGas+=diff;
            if(currentGas<0){
                currentGas=0;
                starting=i+1;
            }
        }
        return starting;
    }
}