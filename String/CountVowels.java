import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String words[]=new String[n];
        for(int i=0;i<n;i++){
            words[i]=sc.next();
        }
        int m=sc.nextInt();
        int k=sc.nextInt();
        int queris[][]=new int[m][k];
        for(int i=0;i<m;i++){
            for(int j=0;j<k;j++){
                queris[i][j]=sc.nextInt();
            }
        }
        int res[]=new int[m];
        res=help(words,queris); 
        System.out.println(Arrays.toString(res));
    }

    private static int[] help(String[] words, int[][] queris) {
        Set<Character> st=new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int n=words.length;

        int prefix[]=new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i];
            if(st.contains(words[i].charAt(0))&& st.contains(words[i].charAt(words[i].length()-1))){
                prefix[i+1]++;
            }
        }
        
        int ans[]=new int[queris.length];
        for(int i=0;i<queris.length;i++){
           int l=queris[i][0];
          int  r=queris[i][1];
            ans[i]=prefix[r+1]-prefix[l];
        }

      return ans;
    }
}
