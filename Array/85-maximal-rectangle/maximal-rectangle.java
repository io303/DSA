import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for(int i = 0; i < rows; i++) {

            // Build histogram
            for(int j = 0; j < cols; j++) {

                if(matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            maxArea = Math.max(
                maxArea,
                largestRectangleArea(heights)
            );
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack <Integer> stack =new Stack<>();
        int nse[]=new int[n];
        int pse[]=new int[n];
        // nse[]
        stack.push(n-1);
        nse[n-1]=n;
        for(int i=n-2;i>=0;i--){
            while(stack.size()>0&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()==0){
                nse[i]=n;
            }
            else{
                nse[i]=stack.peek();
            }
            stack.push(i);
        }
        //empty stack
        while(stack.size()>0){
            stack.pop();
        }
        // pse[]
        stack.push(0);
        pse[0]=-1;
        for(int i=1;i<n;i++){
             while(stack.size()>0&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
             if(stack.size()==0){
                pse[i]=-1;
            }
            else{
                pse[i]=stack.peek();
            }
            stack.push(i);
        }
        // max area 
        int max=-1;
        for(int i=0;i<=n-1;i++){
            int area =heights[i]*(nse[i]-pse[i]-1);
            max=Math.max(max,area);
        }
       return max;
    }
  
}