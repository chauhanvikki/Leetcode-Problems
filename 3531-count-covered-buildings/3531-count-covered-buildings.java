class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,TreeSet<Integer>> rowToCol=new HashMap<>();
        HashMap<Integer,TreeSet<Integer>> colToRow=new HashMap<>();
        for(int[] building: buildings){
            int x=building[0];
            int y=building[1];
            rowToCol.computeIfAbsent(x,k -> new TreeSet<>()).add(y);
            colToRow.computeIfAbsent(y,k -> new TreeSet<>()).add(x);
        }
        int count=0;
        for(int[] building: buildings){
            int x=building[0];
            int y=building[1];
            Integer left=rowToCol.get(x).lower(y);
            Integer right=rowToCol.get(x).higher(y);
            Integer up=colToRow.get(y).lower(x);
            Integer down=colToRow.get(y).higher(x);
            if(left!=null && right!=null && down!=null && up!=null){
                count++;
            }
        }
        return count;
    }
}