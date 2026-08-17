class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int sc=0;
        int ec=mat[0].length-1;
        int n=mat.length;
       
       while(sc<=ec){
        int maxrow=0;
        int midcol=sc+(ec-sc)/2;

        for(int row=0;row<n;row++){
            maxrow=mat[row][midcol]>=mat[maxrow][midcol]?row:maxrow;

        }

        boolean left=midcol-1>=sc&&mat[maxrow][midcol-1]>mat[maxrow][midcol];

        boolean right=midcol+1<=ec&& mat[maxrow][midcol+1]>mat[maxrow][midcol];

        if(!left && !right){
            return new int[]{maxrow,midcol};
        }
        else if(right){
            sc=midcol+1;
        }else{
            ec=midcol-1;
        }
   
       }
        return null;
    }
}