class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max=0;
        double diag=0;
        double side1=0;
        double side2=0;
        for(int i=0;i<dimensions.length;i++){
            double len=dimensions[i][0]*dimensions[i][0];
            double breadth=dimensions[i][1]*dimensions[i][1];
            double sum=len+breadth;
            double diagonal=Math.sqrt(sum);
            if(diagonal==diag){
                if((side1*side2)<dimensions[i][0]*dimensions[i][1]){
                    side1=dimensions[i][0];
                    side2=dimensions[i][1];
                }
            }
            if(max<diagonal){
                max=diagonal;
                diag=diagonal;
                side1=dimensions[i][0];
                side2=dimensions[i][1];
            }
        }
        return (int)side1*(int)side2;
    }
}