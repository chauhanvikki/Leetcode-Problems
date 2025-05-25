class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int original=image[sr][sc];
        for(int i=sr;i<image.length;i++){
            for(int j=sc;j<image[0].length;j++){
                if(image[sr][sc]!=color){
                    image[sr][sc]=color;
                    if(sc-1>=0 && image[sr][sc-1]==original){
                        floodFill(image,sr,sc-1,color);
                    }
                    if(sc+1<n && image[sr][sc+1]==original){
                        floodFill(image,sr,sc+1,color);
                    }
                    if(sr-1>=0 && image[sr-1][sc]==original){
                        floodFill(image,sr-1,sc,color);
                    }
                    if(sr+1<m && image[sr+1][sc]==original){
                        floodFill(image,sr+1,sc,color);
                    }
                }
            }
            // return image;
        }
        return image;
    }
}